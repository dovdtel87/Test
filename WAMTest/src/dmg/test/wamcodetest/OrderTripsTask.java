package dmg.test.wamcodetest;

import java.util.ArrayList;
import java.util.Map;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

/**
 * @author dmgdavid2109@gmail.com
 * Class that order the trip in an asynchronous task   
 */

public class OrderTripsTask extends AsyncTask<String, Integer, ArrayList<RouteVO>>{
	private Activity activity;
	private ProgressDialog pd;
	private Context contexto;
	private Map<Object,RouteVO> mDestiny; 
	private Map<Object,RouteVO> mOrigin;
	private String destiny;
	
	public OrderTripsTask(Map<Object,RouteVO> mDestiny,Map<Object,RouteVO> mOrigin,String destiny,Activity activity) {
		this.mDestiny=mDestiny;
		this.mOrigin=mOrigin;
		this.destiny=destiny;
        this.activity = activity;
        this.contexto = activity.getApplicationContext();
        this.pd = new ProgressDialog(this.contexto);
    }
	
	@Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.pd = new ProgressDialog(this.activity);
        this.pd.setMessage("Sorting Trips");
        this.pd.setIndeterminate(false);
        this.pd.setCancelable(false);
        this.pd.show();
    }

    @Override
    protected ArrayList<RouteVO> doInBackground(String... destinyArray) {
    	SortAlgorithm tmpSortAlgorithm=new SortAlgorithm(mDestiny,mOrigin,destiny);
    	ArrayList<RouteVO> order = new ArrayList<RouteVO>();
    	order=tmpSortAlgorithm.Sort();
    	    	
		return order;
    }

	@Override
	protected void onPostExecute(ArrayList<RouteVO> routes) {
        // Se debe navegar a MainActivity al tener todo el listado de ofertas
		Intent i = new Intent(activity, OrderedListActivity.class);
		i.putExtra("Routes", routes);
		activity.startActivity(i);
				
		if (this.pd.isShowing()) {
            this.pd.dismiss();
        }
	}
}

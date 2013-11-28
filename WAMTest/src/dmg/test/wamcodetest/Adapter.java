package dmg.test.wamcodetest;

import java.util.ArrayList;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 
 * @author dmgdavid2109@gmail.com
 * 
 * Class to adapt the information of the routes contained
 * in the ArrayList to the ListView 
 */

public class Adapter extends BaseAdapter{
	public final Activity actividad;
	private final ArrayList<RouteVO> routes;
	private LayoutInflater mInflater;
	
	public Adapter(Activity actividad, ArrayList<RouteVO> routes) {
		super();
		this.actividad = actividad;
		this.routes = routes;
		this.mInflater = actividad.getLayoutInflater();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		RouteVO route = routes.get(position);
		ViewHolder holder;

		if (convertView == null) 
		{
			convertView = mInflater.inflate(R.layout.list_element, parent, false);
			holder = new ViewHolder();
			holder.textViewOrigen = (TextView) convertView.findViewById(R.id.origen);
			holder.textViewDestiny = (TextView) convertView.findViewById(R.id.destiny);
			holder.textViewTransport = (TextView) convertView.findViewById(R.id.transport);
			holder.textViewAdditionalInfo = (TextView) convertView.findViewById(R.id.additionalinfo);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.textViewOrigen.setText(route.getOrigen());
		holder.textViewDestiny.setText(route.getDestiny());
		holder.textViewTransport.setText("Transport: "+route.getTransport());
		holder.textViewAdditionalInfo.setText(route.getInfo());
	
		return convertView;
	}

	public int getCount() {
		return routes.size();
	}

	public Object getItem(int arg0) {
		return routes.get(arg0);
	}

	public long getItemId(int position) {
		return position;
	}

	private static class ViewHolder {
		public TextView textViewOrigen;
		public TextView textViewDestiny;
		public TextView textViewTransport;
		public TextView textViewAdditionalInfo;
	}
}

package dmg.test.wamcodetest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;

/**
 * @author dmgdavid2109@gmail.com
 *
 *	Class for handle the main Activity
 */
public class MainActivity extends ListActivity {
	
	//Two Hashmaps: Key1: Origen Place Key2: Destiny Place
	//Value: Route
	public Map<Object,RouteVO> mDestiny=new HashMap<Object, RouteVO>();
	public Map<Object,RouteVO> mOrigin=new HashMap<Object, RouteVO>();
	public String destiny="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			
		ArrayList<RouteVO> notOrderroutes=new ArrayList<RouteVO>();
		
		// Read the file routes.json from assets
		try {
			String readPositionsFile =	Util.loadJSONFromInputStream(getAssets().open("routes.json"));
			JSONArray ja = new JSONArray(readPositionsFile);

			// ITERATE THROUGH AND RETRIEVE CLUB FIELDS
			int n = ja.length();
			for (int i = 0; i < n; i++) 
			{
				// GET INDIVIDUAL JSON OBJECT FROM JSON ARRAY
				JSONObject jo = ja.getJSONObject(i);
				
				// RETRIEVE EACH JSON OBJECT'S FIELDS
				String origin = jo.getString("origin");
				String jDestiny = jo.getString("destiny");
				String transport = jo.getString("transport");
				String additionalInfo = jo.getString("additional_info");
				
				if(i==0){
					destiny=jDestiny;
				}
		
				// CONVERT DATA FIELDS OBJECT
				RouteVO route = new RouteVO(origin,jDestiny,transport,additionalInfo);
				notOrderroutes.add(route);
				
				//Add the information to the HashMaps
				mDestiny.put(jDestiny, route);
				mOrigin.put(origin, route);
			}
		} catch (JSONException je) {
			System.out.println("error " + je.toString());
		} catch (IOException e) {
			System.out.println("error " + e.toString());
		}
		
		setListAdapter(new Adapter(this, notOrderroutes));
	}

	//method call when button is pressed
	public void callSortTrip(View v){
		new OrderTripsTask(mDestiny,mOrigin,destiny,MainActivity.this)
			.execute();
	}

}

package dmg.test.wamcodetest;

import java.util.ArrayList;
import android.app.ListActivity;
import android.os.Bundle;

/**
 *  @author dmgdavid2109@gmail.com
 *
 *	Class to handle the Activity OrderedList
 */

public class OrderedListActivity extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.orderedlist);
		
		@SuppressWarnings("unchecked")
		ArrayList<RouteVO> routes = (ArrayList<RouteVO>) getIntent().getSerializableExtra("Routes");		
		setListAdapter(new Adapter(this, routes));
	}
}

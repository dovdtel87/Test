package dmg.test.wamcodetest;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author dmgdavid2109@gmail.com
 * 
 * Class that implements the Sorting Algorithm
 */
public class SortAlgorithm {
	private Map<Object,RouteVO> mDestiny; 
	private Map<Object,RouteVO> mOrigin;
	private String destiny;
	
	public SortAlgorithm(Map<Object,RouteVO> mDestiny,Map<Object,RouteVO> mOrigin,String destiny){
		this.mDestiny=mDestiny;
		this.mOrigin=mOrigin;
		this.destiny=destiny;
	}
	
	public ArrayList<RouteVO> Sort(){
		ArrayList<RouteVO> order = new ArrayList<RouteVO>();
		String origen="";
		RouteVO auxRouteVO=new RouteVO();
		Boolean exit=false;
				 				 
		do
		{
			//go through the destiny Hasmap looking for the origen of the set destiny
			//when a "destiny" has no origen, then the current destiny is the
			//origen of all the route
		 	try{
		 		auxRouteVO=mDestiny.get(destiny);
		 		destiny=auxRouteVO.getOrigen();
		 	}
		 	catch(NullPointerException npe){
		 		origen=destiny;
		 		exit=true;
		 	}
		}while(exit==false);
		 
		//In this point the variable "origen" has the origen of all the route
		exit=false;
		do{
			//go through the origen Hasmap looking for the destiny of the current origen
			//when a "origen" has no destiny, then the current origen is the
			//end of all the route
			//The routes are added in order in the arrayList that will be shown in the screen
			try{
				RouteVO auxRoute=mOrigin.get(origen);
				origen=auxRoute.getDestiny();
				order.add(auxRoute);
						 
			}catch(NullPointerException npe){
				exit=true;
			}
		}while(exit==false);
		   
		return order;
	}
}
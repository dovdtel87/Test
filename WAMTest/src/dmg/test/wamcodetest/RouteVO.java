package dmg.test.wamcodetest;

import java.io.Serializable;

/**
 * @author dmgdavid2109@gmail.com
 * 
 * Object with the information of the routes
 */

public class RouteVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Origin of the route
	private String origen;
	
	//Destiny of the route
	private String destiny;
	
	//Vehicle use in the route
	private String transport;
	
	//Additional info inclue in the route
	private String info;
	
	public RouteVO() {
	}
	
	public RouteVO(String origen, String destiny, String transport, String info) {
		this.origen=origen;
		this.destiny=destiny;
		this.transport=transport;
		this.info=info;
	}	
	
	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
}

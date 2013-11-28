package dmg.test.wamcodetest;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author dmgdavid2109@gmail.com
 * 
 * Class that implements useful methods for the application
 *
 */
public class Util 
{
	public Util() {
	}
	
	public static String loadJSONFromInputStream(InputStream is) {
		String json = null;
		try {
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();
			json = new String(buffer, "UTF-8");

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
		return json;
	}
	
}
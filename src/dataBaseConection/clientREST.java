package dataBaseConection;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.*;

//Para el manejo de json
import org.json.*;


public class clientREST {

	public static void main(String[] args) {
		
		clientREST connect = new clientREST();
		//Ejemplo GET OBTENER TODOS LOS PRODUCTOS
		//JSONObject resultC = connect.connectionDDBB("GET","getAllProducts", null);
		
		//Ejemplo POST INSERTAR PRODUCTO
		String paramProduct = "description=Prueba descripcion&img=Prueba imagen&id_owner=1&id_category=3";
		
		JSONObject resultC = connect.connectionDDBB("POST","insertProduct", paramProduct);
		
		try {
			System.out.println(resultC.getJSONArray("result"));
			System.out.println(resultC.getString("status"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public JSONObject connectionDDBB (String MethodTYPE,String MethodURL,String Param) {
	  try {
		URL url = new URL("http://www.jesusjavega.es/is/servidor/services/ .php/" + MethodURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		if(MethodTYPE == "POST"){
			/* POST */
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			//conn.setRequestProperty("Accept", "application/json");
			
			String input = Param;
			/*
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();*/
			
			PrintStream ps = new PrintStream(conn.getOutputStream());
		    // send your parameters to your site
		    ps.print(Param);
			
			/* END POST */
		}else{
			/* GET */
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			/* END GET */		
		}

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		//Crear el json del bufferedreader
		StringBuilder sb = new StringBuilder();
				
		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

	    String line;
	    while ((line = br.readLine()) != null) {
	        sb.append(line);
	    }
	    
	    //Parseamos JSON y ya tenemos un objeto al que podemos acceder a sus atributos
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(sb.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //JSONObject newJSON = jsonObject.getJSONObject("stat");
        //System.out.println(jsonObject.getString("status"));
        //System.out.println(jsonObject.getJSONArray("result"));
		conn.disconnect();
		
		return jsonObject;

	  } catch (MalformedURLException e) {
		e.printStackTrace();
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	  return null;

	}

}
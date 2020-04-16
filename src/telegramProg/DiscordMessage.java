package telegramProg;
/**
 * @author kelli
 *
 */
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.*;

public  class DiscordMessage extends DiscordChannelDb  {
	
	String json_message ;
	Read_Write_file db = new Read_Write_file();
	//------------------------------------------------------------------------------------------------
	
	private void open_gateway() {
		try {
		URL obj = new URL(discord_gateway_url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization",  db.getAuthKey());
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { //------>> success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//---->> print result
			System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}}
		
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			
		}
	}
	//--------------------------------------------------------------------------------------------------------------------------
	public void get_message(String resource, String Id , String limit) {
		open_gateway();
		String final_url = discord_API_endpoint+"/"+resource+"/"+Id+"/messages";
		System.out.println(resource + Id);
		try {
			URL obj = new URL(final_url);
			
			 HttpURLConnection connect = (HttpURLConnection) obj.openConnection();
			 connect.setRequestMethod("GET");
			connect.setRequestProperty("limit", limit);
			 connect.setRequestProperty("Authorization", db.getAuthKey());
			 int responseCode = connect.getResponseCode();
			 
			 System.out.println("GET Response Code :: " + responseCode);
				if (responseCode == HttpURLConnection.HTTP_OK) { //------>> success
					BufferedReader in = new BufferedReader(new InputStreamReader(
							connect.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					//---->> print result
					this.json_message = response.toString();
					//System.out.println(json_message);
					Messages response1 = new Messages();
					response1.parseJSONResponse(json_message);
					
				} else {
					System.out.println("GET request not worked");
				}

				
		} 
		
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Messages response = new Messages();
		response.parseJSONResponse(json_message);
	}}
	

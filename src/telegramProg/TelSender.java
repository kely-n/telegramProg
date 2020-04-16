
/**
 * 
 */
package telegramProg;

/**
 * @author kelli
 *
 */


	import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.InputStreamReader;
	import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import forwarder.TelegramTable;

	public class TelSender extends Run{
		TelegramTable table = new TelegramTable();	
	public void send_to_telegram (){
		
		Messages get = new Messages();
		
		
		Read_Write_file db = new Read_Write_file();
		ArrayList <String> mes = get.messageList;
		int i = mes.size();
		String chat_id = table.chatid;
		
		int count;
		String FUNCTION = "/sendMessage?";
		//method to forward message to telegram, 
		//void send_message_to_telegram(String message, String bot_key, String chat_id) throws Exception {
			
		
		for(count = (i-1); count >= 0; count--) {
			//prepare body for post in string;
			 System.out.println(chat_id);
			
			String JSON_body = "{\"chat_id\":\""+chat_id+"\",\"text\":\""+mes.get(count)+"\"}";
			
			String telegram_url = TELEGRAM_MAIN_URL + db.getBotKey() + FUNCTION;
			URL obj;
			try {
				obj = new URL(telegram_url);
			
			HttpURLConnection connect = (HttpURLConnection) obj.openConnection();
			 
			//setting up a post request
			connect.setRequestMethod("POST");
			connect.setRequestProperty("Content-Type","application/json");
			connect.setDoOutput(true);
			String jsonInputString = JSON_body;
 
			try(OutputStream os = connect.getOutputStream()) {
			    byte[] input = jsonInputString.getBytes();
			    os.write(input, 0, input.length); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//changing response to string
			try(BufferedReader br = new BufferedReader(
					  new InputStreamReader(connect.getInputStream(), "utf-8"))) {
					    StringBuilder response = new StringBuilder();
					    String responseLine = null;
					    while ((responseLine = br.readLine()) != null) {
					        response.append(responseLine.trim());
					    }
					//    System.out.println(response.toString());
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ProtocolException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	}

	


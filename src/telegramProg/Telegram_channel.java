package telegramProg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Telegram_channel extends TelSender {
	static int count = 0;
	private int id;
	private String chatid;
	private String channelName;
	private String botKey;
	 
 public void getchannel() { 
	 		
	 		count = 0;
			FormEvent formevent = new FormEvent(null);
			String datastring = formevent.readLog();
			
			JSONArray data_string = new JSONArray();
			JSONParser parser = new JSONParser();
			
			try {
				data_string = (JSONArray) parser.parse(datastring);
			} catch (ParseException parseException) {
				// TODO Auto-generated catch block
				parseException.printStackTrace();
			}
			
			JSONObject channel = new JSONObject();
			for(int i = 0 ; i <data_string.size(); i++) {
				channel = (JSONObject) data_string.get(i) ;
				String chatid = (String) channel.get("chatID");
				String channelName = (String) channel.get("channelName");
				String botKey = (String) channel.get("botKey");
				
				
				
				}
			}
		}

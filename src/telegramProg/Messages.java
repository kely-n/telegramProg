package telegramProg;


import java.util.ArrayList;

//------>> read JSON from a file 
  
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 

public class Messages extends DiscordMessage { 
	public static ArrayList<String> messageList = new ArrayList<String>();
	
//	public static void main(String [] args) {
//	Messages nc = new Messages();
	
	
	
	
	//JSONObject messages = new JSONObject(Json_input);
//	nc.parseJSONResponse(Json_input);
//	}
	public int messagelimit ;
	public void parseJSONResponse(String json_message) {	 
	try {
		JSONParser parser = new JSONParser();

		JSONArray array = (JSONArray) parser.parse(json_message);

			messagelimit = array.size();
		 
		for (int i = ((array.size())-1); i>=0; i--) {

		JSONObject message = (JSONObject) array.get(i);
//		System.out.println(array.get(i));

		Message new_message = new Message(); 
		
		//----->>getting and setting timestamp
	//	System.out.println("getting timestamp");
		String timestamp = (String) message.get("timestamp");
		
		
		//----->>getting content
	//	System.out.println("getting content");
		String content = (String) message.get("content");
		messageList.add(content);
		//---->>getting type
	//	System.out.println("getting type");
		long type = (long) message.get("type");
		
		//----->>getting message_id
	//	System.out.println("getting message_id");
		String message_id = (String) message.get("id");
		
		
		new_message.message(timestamp, message_id, content, type);
		
	}}
	catch (ParseException e) {
		e.printStackTrace();
		}
	
	}
	
}

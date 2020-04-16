package telegramProg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DiscordChannelDb extends Run{

		private String channelId;
		private String channelName;
		private String lastmessageID;
		public Object [][]data;
		public  int data_row; 
		
		public String [][]data1;
		
		public static String channel_Id;
		Path logfile =	Paths.get(path + "/discordlog.txt");
		 
		

public String readLog() {
	
	String savedData = "[]";
	try (InputStream in = Files.newInputStream(logfile);
		     BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	savedData=line;
		    }
		} catch (IOException x) {
		    System.err.println(x);
		    
		}
	
	return savedData;
	
}
private void saveDiscordChannel() {
	
		
	JSONObject channel = new JSONObject();
	
	
	channel.put("channelId", this.channelId);
	channel.put("channelName", this.channelName);
	channel.put("lastmessageID", this.lastmessageID);
	
	JSONArray dis_channels = new JSONArray();
	//---->>read file and save to json array
	String savedData = readLog();
	
	JSONParser parser = new JSONParser();
	
	try {
		dis_channels = (JSONArray) parser.parse(savedData);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//----->> add channel t0 tel array and save to file
	dis_channels.add(channel);
	String saveToFile =  dis_channels.toString();
	

	//Convert the string to a byte array.
	
	String s = saveToFile;
	Charset charset = Charset.forName("US-ASCII");
	try (BufferedWriter writer = Files.newBufferedWriter(logfile, charset)) {
	    writer.write(s, 0, s.length());
	} 
	    
	 catch (IOException x) {
	    System.err.println(x);
	 }
	
	}
	
 public void setDiscordChannel(String channelId, String channelName, String lastmessageID){
		this.channelId = channelId;
		this.channelName = channelName;
		this.lastmessageID = lastmessageID;
		saveDiscordChannel();
	}
public void getDiscordChannelsString(){
	 JSONArray channels = new JSONArray();
		//---->>read file and save to json array
		String savedData = readLog();
		
		JSONParser parser = new JSONParser();
		
		try {
			channels = (JSONArray) parser.parse(savedData);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  String [][]data1 = new String [channels.size()][4];
		JSONObject channel = new JSONObject();
		
		for(int i = 0; i< channels.size(); i++) {
			channel = (JSONObject) channels.get(i);
			
			String channelId = (String) channel.get("channelId");
			String channelName = (String) channel.get("channelName");
			String lastmessageID = (String) channel.get("lastmessageID");
			
			data1[i][0] = channelName;
			data1[i][1] = channelId;
			data1[i][2] = "";
			data1[i][3] = lastmessageID;
		}
		this.data1 = data1;
}
 public Object[][] getDiscordChannels(){
	 JSONArray channels = new JSONArray();
		//---->>read file and save to json array
		String savedData = readLog();
		
		JSONParser parser = new JSONParser();
		
		try {
			channels = (JSONArray) parser.parse(savedData);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  Object [][]data = new Object [channels.size()][4];
		JSONObject channel = new JSONObject();
		
		for(int i = 0; i< channels.size(); i++) {
			channel = (JSONObject) channels.get(i);
			
			String channelId = (String) channel.get("channelId");
			String channelName = (String) channel.get("channelName");
			String lastmessageID = (String) channel.get("lastmessageID");
			
			data[i][0] = channelName;
			data[i][1] = new String (channelId);
			data[i][2] = new Boolean( false);
			data[i][3] = lastmessageID;
		}
		this.data = data;
	return data;
	 
 }
	
}

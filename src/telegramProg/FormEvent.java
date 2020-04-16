package telegramProg;

import java.util.EventObject;

import telegramProg.Telegram_channel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class FormEvent extends EventObject {

	private String channelName;
	private String chatID;
	private String botKey;
	Telegram_channel telchannel = new Telegram_channel();
	
	public FormEvent(Object source) { 
		 
		super(source);
		
	}
	
public FormEvent(Object source, String channelName, String chatID, String botKey ) {
		
		super(source);
		if(chatID != null && channelName != null && botKey != null) {
		this.channelName=channelName;
		this.chatID = chatID;
		this.botKey = botKey;
		saveChannels();
		System.out.println(channelName +"  "+chatID+ " is here" );
		}
	}
 
public String readLog() {
	
	String savedData = "[]";
	Path logfile =	Paths.get(Telegram_channel.path + "/telegramlog.txt");
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
//--->>>saving telegram channel to file.
private void saveChannels() {
	//--->> path to file
	try {
	Path logfile =	Paths.get(Telegram_channel.path + "/telegramlog.txt");
	//System.out.println(logfile);
	JSONObject channel = new JSONObject();
	
	//Add data to JSON object.
	
	channel.put("chatID", chatID);
	channel.put("channelName", channelName);
	channel.put("botKey", botKey);
	
	JSONArray telchannels = new JSONArray();
	
	//---->>read file and save to json array
	
	String savedData = readLog();
	
	
	JSONParser parser = new JSONParser();
	
	try {
		telchannels = (JSONArray) parser.parse(savedData);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//----->> add channel t0 tel array and save to file
	telchannels.add(channel);
	String saveToFile =  telchannels.toString();
	

	//Convert the string to a byte array.
	
	String s = saveToFile;
	Charset charset = Charset.forName("US-ASCII");
	try (BufferedWriter writer = Files.newBufferedWriter(logfile, charset)) {
	    writer.write(s, 0, s.length());
	} 
	    
	 catch (IOException x) {
	    System.err.println(x);
	 }
	}finally {
		
	}
	}

//---->>>getters and setters
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChatID() {
		return chatID;
	}

	public void setChatID(String chatID) {
		this.chatID = chatID;
	}

	public String getBotKey() {
		return botKey;
	}

	public void setBotKey(String botKey) {
		this.botKey = botKey;
	}

	
}

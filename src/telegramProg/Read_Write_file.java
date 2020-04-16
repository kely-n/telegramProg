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

public class Read_Write_file extends Run{
	 String chat_id;
	
	public  void setChat_id(String chat_id) {
		this.chat_id = chat_id;
	}
	public String readTelLog() {
		String savedData = "[]";
		Path logfile =	Paths.get(path + "/telegramlog.txt");
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
	public String readLog() {
		String savedData = "[]";
		Path logfile =	Paths.get(path + "/logfile.txt");
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
	public String getBotKey(){
		String savedData = readLog();
		JSONArray data = new JSONArray();
		
		
		JSONParser parser = new JSONParser();
		
		try {
			data =  (JSONArray) parser.parse(savedData);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject dataObj = (JSONObject) data.get(0);
		
		return  (String) dataObj.get("bot_Key");
		
		
	}
	
	public String getAuthKey(){
		String savedData = readLog();
		JSONArray data = new JSONArray();
		
		JSONParser parser = new JSONParser();
		
		try {
			data =  (JSONArray) parser.parse(savedData);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject dataObj = (JSONObject) data.get(0);
		
		return  (String) dataObj.get("auth_key");
		
		
	}
	public void savefile(String auth_key, String bot_Key) {
		// TODO Auto-generated method stub
		
		try {
			Path logfile =	Paths.get(path + "/logfile.txt");
			//System.out.println(logfile);
			JSONObject channel = new JSONObject();
			
			//Add data to JSON object.
			
			channel.put("auth_key", auth_key);
			channel.put("bot_Key", bot_Key);
			
			
			JSONArray programlog = new JSONArray();
			
			//---->>read file and save to json array
			
			String savedData = readLog();
			
			
			JSONParser parser = new JSONParser();
			
			try {
				programlog = (JSONArray) parser.parse(savedData);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//----->> add channel t0 tel array and save to file
			programlog.add(channel);
			String saveToFile =  programlog.toString();
			

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

	}


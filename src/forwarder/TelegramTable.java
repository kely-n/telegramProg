package forwarder;

import javax.swing.table.AbstractTableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import telegramProg.Read_Write_file;

public class TelegramTable extends AbstractTableModel  {
	public static String chatid;
	Boolean DEBUG = false;
	Read_Write_file event = new Read_Write_file() ;
	JSONArray telchannels = new JSONArray();
	private String chatID;
	private String channelName;
	private String botKey;
	private static int count;
	static int rows; static int col = 4;
	private Object[][] data;
	
	private  static String [][] sending;
  private String[] columnNames = {
             
             "chatID",
             "channelName","botKey", "sending to"
             };
  
 public  void setdata(){
	 try { 
		 String savedData = "[]";
        savedData = event.readTelLog() ;
 JSONParser parser = new JSONParser();
	
	
		telchannels = (JSONArray) parser.parse(savedData);
		rows = telchannels.size();
		int a = 0;
		Object[][] data1 = new Object[rows][col];
		String [][] sending_to = new String[rows][col];
		for (int i = ((telchannels.size())-1); i>=0; i--) {

			JSONObject channel = (JSONObject) telchannels.get(i);
			String chatID = (String) channel.get("chatID");
			String channelName = (String) channel.get("channelName");
			String botKey = (String) channel.get("botKey");
			
			if(chatID != "" && channelName != "" & botKey != "") {
				this.chatID = chatID;
				this.channelName = channelName;
				this.botKey = botKey;
				
			data1[a][0]= this.chatID;
			data1[a][1]= this.channelName;
			data1[a][2]= this.botKey;
			data1[a][3] = new Boolean(false);
			
			sending_to[a][0]= this.chatID;
			sending_to[a][1]= this.channelName;
			sending_to[a][2]= this.botKey;
			sending_to[a][3] = "";
			a++;
			}
			
			}
		this.sending = sending_to;
		this.data = data1;
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
 }
 
	@Override
	public int getRowCount() {
		if (data == null) {
			return 0;
		}else {
		 return data.length;
		}
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	public String getColumnName(int col) {
        return columnNames[col];
        
    }
	@Override
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	 public boolean isCellEditable(int row, int col) {
         if (col != 3) {
             return false;
         } else {
             return true;
         }
     }
	 public void setValueAt(Object value, int row, int col) {
         if (DEBUG) {
             System.out.println("Setting value at " + row + "," + col
                                + " to " + value
                                + " (an instance of "
                                + value.getClass() + ")");
         }
 
         data[row][col] = value; 
         fireTableCellUpdated(row, col);
         
         //----->> select channel
         int rowselect = row;
         String telchat_id = sending[rowselect][0];
         
         System.out.println(telchat_id);
         this.chatid = telchat_id;
         
         if (DEBUG) {
             System.out.println("New value of data:");
             printDebugData();
         }
     }

     private void printDebugData() {
         int numRows = getRowCount();
         int numCols = getColumnCount(); 

         for (int i=0; i < numRows; i++) {
             System.out.print("    row " + i + ":");
             for (int j=0; j < numCols; j++) {
                 System.out.print("  " + data[i][j]);
             }
             System.out.println();
         }
         System.out.println("--------------------------");
     }
 }


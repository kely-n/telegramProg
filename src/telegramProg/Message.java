package telegramProg;

import forwarder.Table;

public class Message extends Messages{
	
	
	
	private static int count = 0;
	
	private String timestamp;
	private String message_id;
	private String content;
	//private long type;f
	
	static int i =	101; static int j = 2;
	
	public static Object[][] data = new Object[i][2];

	public void message(String timestamp, String message_id, String content, long type) {
		this.timestamp=timestamp;
		this.message_id = message_id;
		this.content = content;
		Message.data[count][0] = this.message_id;;
		Message.data[count][1] = this.content;
		count++;
	}
	
	
	}
	

package forwarder;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import telegramProg.Message;

public class Table extends AbstractTableModel {
	
	Message message = new Message();
	int count = 0;
	
	
	 
	 private String[] columnNames = {
             
             "message_id",
             "content"
             };
	   private Object[][] data = message.data; 
	    
	@Override
	public int getRowCount() {
		
		 return data.length;
		
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
//		System.out.println(data[row][col]+" : "+data[row][col]);
//		count++;
		return data[row][col];
	}

	public void setData( Object[][] data) {
		 this.data = data;
	}

	public Object[][] getData() {
		return data;
	}
	
	
}

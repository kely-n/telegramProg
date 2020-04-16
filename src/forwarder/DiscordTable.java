package forwarder;

import javax.swing.table.AbstractTableModel;

import org.json.simple.JSONArray;


import telegramProg.DiscordChannelDb;

public class DiscordTable extends AbstractTableModel {
	Boolean DEBUG = false;
	
	DiscordChannelDb discord = new DiscordChannelDb();
	
	static int rows; static int col = 4;
	private Object[][] data= discord.getDiscordChannels();
	
  private String[] columnNames = {
             
             "channel ID",
             "channel Name","getting from", "last Message id"
             };
  
  
	
	public int getRowCount() {
		return data.length;
	}


	public int getColumnCount() {
		return 3;
	}

	public String getColumnName(int col) {
        return columnNames[col];
        
    }

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	 public boolean isCellEditable(int row, int col) {
        if (col != 2) {
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
        
        discord.getDiscordChannelsString();
        String id =  discord.data1[row][0];
        discord.channel_Id= id;
        System.out.println(discord.channel_Id);
         
        
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
      
    }
}

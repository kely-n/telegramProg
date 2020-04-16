package forwarder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

public class Telegram_channels extends JFrame {

	private JPanel contentPane;
	private JTable table;
	TelegramTable tabledata = new TelegramTable();
	
	public Telegram_channels() {
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		setTitle("telegram channels");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 949, 616);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Forwarder.telWindow.setVisible(false);
			}
		});
		exit.setMnemonic('x');
		exit.setFont(new Font("Dialog", Font.BOLD, 15));
		exit.setBounds(716, 529, 204, 41);
		contentPane.add(exit);
		 
		JPanel channel_list = new JPanel();
		channel_list.setBorder(new LineBorder(new Color(153, 102, 51), 2));
		channel_list.setBounds(0, 80, 949, 414);
		contentPane.add(channel_list);
		channel_list.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 949, 414);
		channel_list.add(scrollPane);
		
		
		tabledata.setdata();
		table = new JTable(tabledata);
		table.setRowHeight(24);
		table.setName("");
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setFont(new Font("Dialog", Font.BOLD, 15));
		
		table.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Telegram_channels.class.getResource("/forwarder/images/telegram_icon.png")));
		label.setBounds(0, 0, 84, 68);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Saved Channels");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(108, 12, 226, 39);
		contentPane.add(lblNewLabel);
	}
}

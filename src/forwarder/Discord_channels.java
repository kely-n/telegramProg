package forwarder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import telegramProg.DiscordChannelDb;
import telegramProg.DiscordMessage;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class Discord_channels extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	DiscordTable tablemodel = new DiscordTable();
	DiscordChannelDb db = new DiscordChannelDb();
	DiscordMessage newMessage = new DiscordMessage();
	
	public Discord_channels() {
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		setTitle("Discord Channels");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 824, 564);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(39, 41, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 76, 824, 352);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 824, 352);
		panel.add(scrollPane);
		
		 
		
		table = new JTable(tablemodel);
		table.setRowHeight(24);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setFont(new Font("Dialog", Font.BOLD, 15));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Discord_channels.class.getResource("/forwarder/images/discored-_con.png")));
		lblNewLabel.setBounds(0, 2, 85, 84);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Discord_channels.class.getResource("/forwarder/images/discordpic.png")));
		lblNewLabel_1.setBounds(83, 21, 188, 43);
		contentPane.add(lblNewLabel_1);
		
		Button submit = new Button("select");
		submit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Forwarder.discordwindw.setVisible(false);
				newMessage.get_message("channels", db.channel_Id, "100");
				
			}
		});
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Dialog", Font.BOLD, 19));
		submit.setBounds(626, 466, 156, 37);
		contentPane.add(submit);
	}
}

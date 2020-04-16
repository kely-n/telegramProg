package forwarder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import telegramProg.FormEvent;
import telegramProg.Read_Write_file;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Telegram extends JFrame {
	Read_Write_file logs = new Read_Write_file();
	private JPanel contentPane;
	private JTextField channel_name;
	private JTextField chat_id;
	private JTextField bot_key;
	
	Telegram_channels telChanelsWindow = new Telegram_channels();
	boolean fieldset = false;
	
	public Telegram() {
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		setTitle("telegram");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 590);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel body = new JPanel();
		body.setBounds(0, 62, 450, 414);
		contentPane.add(body);
		body.setLayout(null);
		
		channel_name = new JTextField();
		channel_name.setText(null);
		channel_name.setFont(new Font("Dialog", Font.BOLD, 14));
		channel_name.setBounds(161, 52, 277, 40);
		body.add(channel_name);
		channel_name.setColumns(1);
		
		Label label = new Label("Channel Name");
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setAlignment(Label.CENTER);
		label.setBounds(30, 56, 111, 36);
		body.add(label);
		
		Label label_1 = new Label("add a new channel");
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setAlignment(Label.CENTER);
		label_1.setBounds(99, 10, 204, 36);
		body.add(label_1);
		
		Label label_2 = new Label("Chat ID");
		label_2.setFont(new Font("Dialog", Font.BOLD, 14));
		label_2.setAlignment(Label.CENTER);
		label_2.setBounds(30, 145, 111, 36);
		body.add(label_2);
		
		chat_id = new JTextField();
		chat_id.setText(null);
		chat_id.setFont(new Font("Dialog", Font.BOLD, 14));
		chat_id.setColumns(1);
		chat_id.setBounds(161, 141, 277, 40);
		body.add(chat_id);
		
		bot_key = new JTextField();
		//bot_key.setText(logs.getBotKey());
		bot_key.setFont(new Font("Dialog", Font.BOLD, 14));
		bot_key.setColumns(1);
		bot_key.setBounds(161, 241, 277, 40);
		body.add(bot_key);
		
		Label label_3 = new Label("Bot Key");
		label_3.setFont(new Font("Dialog", Font.BOLD, 14));
		label_3.setAlignment(Label.CENTER);
		label_3.setBounds(30, 241, 111, 36);
		body.add(label_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Telegram.class.getResource("/forwarder/images/telegram_icon.png")));
		lblNewLabel.setBounds(0, -9, 74, 72);
		contentPane.add(lblNewLabel);
		
		Button save_telegram_channels = new Button("save");
		save_telegram_channels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//----->>System.exit(0);
			}
		});
		save_telegram_channels.setActionCommand("");
		save_telegram_channels.addMouseListener(new MouseAdapter() {//----->>getting channels from input
			
			public void mouseClicked(MouseEvent e) {
				
				String channelName;
				channelName = channel_name.getText();
				String chatID;
				chatID = chat_id.getText();
				String botKey;
				botKey = bot_key.getText();
				String empty="";
				
				if(!(((channelName == null)|| empty.equals(channelName) ) && ((chatID == null)|| empty.equals(chatID)) && ((botKey == null)|| empty.equals(botKey)) )) {
					FormEvent ev = new FormEvent(this, channelName, chatID, botKey);
					channel_name.setText(null);
					chat_id.setText(null);
					bot_key.setText(null);
				}else {
					System.out.println("all fields required");
				}
				}
				
			
		});
		save_telegram_channels.setFont(new Font("Dialog", Font.BOLD, 14));
		save_telegram_channels.setForeground(Color.WHITE);
		save_telegram_channels.setBounds(325, 500, 95, 46);
		contentPane.add(save_telegram_channels);
		
		Button saved_telegram_channels = new Button("my channels");
		
		saved_telegram_channels.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				telChanelsWindow.setVisible(true);
				telChanelsWindow.getFocusableWindowState();
				if(telChanelsWindow.isActive()) {
			
					
				}
			}
		});
		saved_telegram_channels.setForeground(Color.WHITE);
		saved_telegram_channels.setFont(new Font("Dialog", Font.BOLD, 14));
		saved_telegram_channels.setBounds(170, 500, 133, 46);
		contentPane.add(saved_telegram_channels);
		
		Label label_4 = new Label("Manage telegram channels");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Dialog", Font.BOLD, 15));
		label_4.setBounds(102, 10, 274, 33);
		contentPane.add(label_4);
		
	}
}

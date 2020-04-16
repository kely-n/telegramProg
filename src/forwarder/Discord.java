package forwarder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import telegramProg.DiscordChannelDb;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Discord extends JFrame {
	private DiscordChannelDb db = new DiscordChannelDb();
	private JPanel contentPane;
	private JTextField discord_channelName;
	private JTextField Disscord_channelID;

	public Discord() {
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setTitle("Discord");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 590);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(39, 41, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 63, 450, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Disscord_channelID = new JTextField();
		Disscord_channelID.setBounds(150, 76, 266, 46);
		panel.add(Disscord_channelID);
		Disscord_channelID.setColumns(10);
		
		discord_channelName = new JTextField();
		discord_channelName.setColumns(10);
		discord_channelName.setBounds(150, 219, 266, 46);
		panel.add(discord_channelName);
		
		Button button = new Button("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String channelName = discord_channelName.getText();
				String channelId = Disscord_channelID.getText();
				String empty="";
				String discord_ChannelName = discord_channelName.getText();
				String discord_ChannelID = Disscord_channelID.getText();
				if(!(((channelName == null)|| empty.equals(channelName) ) && ((channelId == null)|| empty.equals(channelId)) )) {
			db.setDiscordChannel(discord_ChannelID, discord_ChannelName, null);
			discord_channelName.setText(null);
			Disscord_channelID.setText(null);
				}else {
					System.out.println("all fields required");
				}
				}
		});
		button.setBackground(new Color(39, 41, 70));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Dialog", Font.BOLD, 15));
		button.setBounds(336, 301, 70, 53);
		panel.add(button);
		
		JLabel lblNewLabel_2 = new JLabel("channel Name");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2.setBounds(12, 89, 121, 18);
		panel.add(lblNewLabel_2);
		
		JLabel lblChannelId = new JLabel("channel Id");
		lblChannelId.setFont(new Font("Dialog", Font.BOLD, 15));
		lblChannelId.setBounds(11, 234, 121, 18);
		panel.add(lblChannelId);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Discord.class.getResource("/forwarder/images/discored-_con.png")));
		lblNewLabel.setBounds(0, -12, 84, 77);
		contentPane.add(lblNewLabel);
		
		Button button_1 = new Button("my  channels");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Discord_channels nc = new Discord_channels();
				nc.setVisible(isForegroundSet());
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Dialog", Font.BOLD, 15));
		button_1.setBounds(186, 487, 180, 38);
		contentPane.add(button_1);
		
		JLabel lblNewLabel_1 = new JLabel("Add Discord Channels");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setBounds(97, 19, 222, 22);
		contentPane.add(lblNewLabel_1);
	}
}

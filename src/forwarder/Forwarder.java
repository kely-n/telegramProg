package forwarder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import telegramProg.TelSender;

import java.awt.Color;
import java.awt.Font;
import java.awt.Button;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;

public class Forwarder extends JFrame {
	private JPanel main_window;
	private JTable maintable;
	static Telegram telWindow = new Telegram();
	static Discord discordwindw = new Discord();
	Setup set_up = new Setup();
	
	/**
	 * Create the frame.
	 */
	
	public Forwarder() {
		setFont(new Font("Dialog", Font.BOLD, 14));
		setBackground(Color.GRAY);
		setTitle("Discord to telegram");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setBounds(100, 100, 1419, 860);
		getHierarchyListeners();
		main_window = new JPanel();
		main_window.setBackground(Color.BLACK);
		main_window.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(main_window);
		main_window.setLayout(null);
		
		
		Table dbtable = new Table();		
		JPanel menu_panel = new JPanel();
		menu_panel.setBackground(Color.BLACK);
		menu_panel.setBounds(2, -15, 320, 810);
		main_window.add(menu_panel);
		menu_panel.setLayout(null);
		
		Button telegram_window = new Button("telegram channels");
		telegram_window.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				telWindow.setVisible(isForegroundSet());
				if(!telWindow.isFocusableWindow()) {
					telWindow.setVisible(false);
				}
			}
		});
		telegram_window.setFont(new Font("Dialog", Font.PLAIN, 14));
		telegram_window.setForeground(Color.WHITE);
		telegram_window.setBackground(new Color(0, 153, 204));
		telegram_window.setBounds(21, 80, 290, 41);
		menu_panel.add(telegram_window);
		
		Button discord_window = new Button("Discord channels");
		discord_window.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				discordwindw.setVisible(true);
				discordwindw.getFocusableWindowState();
			}
		});
		discord_window.setFont(new Font("Dialog", Font.PLAIN, 14));
		discord_window.setForeground(Color.WHITE);
		discord_window.setBackground(new Color(39, 41, 70));
		discord_window.setBounds(21, 140, 290, 41);
		menu_panel.add(discord_window);
		
		Button help = new Button("help");
		help.setFont(new Font("Dialog", Font.BOLD, 14));
		help.setBackground(Color.GRAY);
		help.setBounds(21, 265, 290, 41);
		menu_panel.add(help);
		
		Button options = new Button("options");
		options.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				set_up.setVisible(true);
			}
		});
		options.setFont(new Font("Dialog", Font.BOLD, 14));
		options.setBackground(Color.GRAY);
		options.setBounds(21, 198, 290, 41);
		menu_panel.add(options);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(39, 41, 70));
		panel.setBounds(334, 0, 1079, 69);
		main_window.add(panel);
		
		JLabel lblNewLabel = new JLabel("Body");
		lblNewLabel.setIcon(new ImageIcon(Forwarder.class.getResource("/forwarder/images/discordpic.png")));
		lblNewLabel.setFont(new Font("Dialog", Font.ITALIC, 29));
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel);
		
		
		
		Button sending_to = new Button("select telegram channels");
		sending_to.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!telWindow.telChanelsWindow.isActive()){
					telWindow.telChanelsWindow.setVisible(true);
				}
			}
		});
		sending_to.setForeground(Color.WHITE);
		sending_to.setFont(new Font("Dialog", Font.PLAIN, 14));
		sending_to.setBackground(new Color(0, 153, 204));
		sending_to.setBounds(854, 754, 290, 41);
		main_window.add(sending_to);
		
	
		
		Button forward_to_telegram = new Button("send");
		forward_to_telegram.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelSender telegram = new TelSender();//-----sends message to telegram channel
				try {
					
					telegram.send_to_telegram();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		forward_to_telegram.setForeground(Color.WHITE);
		forward_to_telegram.setFont(new Font("Dialog", Font.BOLD, 15));
		forward_to_telegram.setBackground(new Color(0, 153, 204));
		forward_to_telegram.setBounds(1189, 754, 200, 41);
		main_window.add(forward_to_telegram);
				
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(51, 0, 102), null, null, null));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(344, 81, 1069, 647);
		main_window.add(scrollPane);
		
		
		
		maintable = new JTable(dbtable);
		
		maintable.setRowHeight(25);
		maintable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		maintable.setFont(new Font("Dialog", Font.PLAIN, 18));
		maintable.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		maintable.setColumnSelectionAllowed(false);
		maintable.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		scrollPane.setViewportView(maintable);
	}
}

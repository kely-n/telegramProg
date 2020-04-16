package forwarder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import telegramProg.Read_Write_file;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Setup extends JFrame {

	private JPanel contentPane;
	private JTextField botKey;
	private JLabel lblSetUpTelegram;
	private JLabel label;
	private JTextField Auth_key;
	private Button button;
	Read_Write_file db = new Read_Write_file();
	private JLabel lblPathToFolder;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Setup frame = new Setup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Setup() {
		setTitle("Set up");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 4, 45, 0, 61, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 48, 26, -1, 45, 37, 0, 34, 0, 0, 38, 51, 0, 0, 54, -233, 0, 0, -23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblSetUpTelegram = new JLabel("set up telegram bot key and Authentication code");
		GridBagConstraints gbc_lblSetUpTelegram = new GridBagConstraints();
		gbc_lblSetUpTelegram.gridwidth = 6;
		gbc_lblSetUpTelegram.anchor = GridBagConstraints.EAST;
		gbc_lblSetUpTelegram.insets = new Insets(0, 0, 5, 5);
		gbc_lblSetUpTelegram.gridx = 1;
		gbc_lblSetUpTelegram.gridy = 3;
		contentPane.add(lblSetUpTelegram, gbc_lblSetUpTelegram);
		
		label = new JLabel("discord Auth key");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 6;
		contentPane.add(label, gbc_label);
		
		Auth_key = new JTextField();
		Auth_key.setText(null);
		Auth_key.setColumns(10);
		GridBagConstraints gbc_Auth_key = new GridBagConstraints();
		gbc_Auth_key.gridwidth = 7;
		gbc_Auth_key.insets = new Insets(0, 0, 5, 5);
		gbc_Auth_key.fill = GridBagConstraints.HORIZONTAL;
		gbc_Auth_key.gridx = 3;
		gbc_Auth_key.gridy = 8;
		contentPane.add(Auth_key, gbc_Auth_key);
		
		JLabel lblNewLabel = new JLabel("telegram Bot Key");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 10;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		button = new Button("set ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bot_Key;
				String auth_key;
				String empty = "";
				auth_key = Auth_key.getText();
				bot_Key = botKey.getText();
				if(!((auth_key == null)|| empty.equals(auth_key) && (bot_Key == null)|| empty.equals(bot_Key)) ){
					db.savefile(auth_key, bot_Key);
//----->>		Auth_key.setText(null);botKey.setText(null);
					setVisible(false);
				}else {
					
				}
				
			}
		});
		
		botKey = new JTextField();
		botKey.setText(null);
		GridBagConstraints gbc_botKey = new GridBagConstraints();
		gbc_botKey.gridwidth = 7;
		gbc_botKey.insets = new Insets(0, 0, 5, 5);
		gbc_botKey.fill = GridBagConstraints.HORIZONTAL;
		gbc_botKey.gridx = 3;
		gbc_botKey.gridy = 12;
		contentPane.add(botKey, gbc_botKey);
		botKey.setColumns(10);
		
		
		
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridwidth = 2;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.anchor = GridBagConstraints.NORTH;
		gbc_button.gridx = 8;
		gbc_button.gridy = 17;
		contentPane.add(button, gbc_button);
	}

}

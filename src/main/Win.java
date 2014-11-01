package main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import main.Functions;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Window.Type;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.FlowLayout;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("unused")
public class Win {

	private JFrame frmRismcsh;
	private JTextField txtPortNumber;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win window = new Win();
					window.frmRismcsh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Win() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		int portNumber;
		
		frmRismcsh = new JFrame();
		frmRismcsh.setType(Type.UTILITY);
		frmRismcsh.getContentPane().setForeground(new Color(102, 0, 0));
		frmRismcsh.setMinimumSize(new Dimension(400, 300));
		
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setForeground(new Color(102, 0, 0));
		frmRismcsh.getContentPane().add(splitPane, BorderLayout.NORTH);
		
		JLabel lblQuick = new JLabel("Quick Access:");
		lblQuick.setToolTipText("These are some buttons to help you perform common actions faster.");
		splitPane.setLeftComponent(lblQuick);
		
		JButton btnWebsite = new JButton("Website");
		btnWebsite.setBackground(Color.LIGHT_GRAY);
		btnWebsite.setToolTipText("Open robosane.tk in your default browser.");
		splitPane.setRightComponent(btnWebsite);
		
		JSplitPane splitPaneFeed = new JSplitPane();
		splitPaneFeed.setContinuousLayout(true);
		frmRismcsh.getContentPane().add(splitPaneFeed, BorderLayout.SOUTH);
		
		JLabel label = new JLabel("Latest Article:");
		label.setToolTipText("This is a marquee displaying the latest article from Robosane.");
		splitPaneFeed.setLeftComponent(label);
		
		JLabel lblArticleMarquee = new JLabel("Article Marquee");
		splitPaneFeed.setRightComponent(lblArticleMarquee);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmRismcsh.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JTextPane aboutTextPane = new JTextPane();
		aboutTextPane.setText("Hi! I'm RISM! I'm here to help you do stuff.\n\nAny bugs, problems, or suggestions, please email robobenklein@gmail.com about me.\n\nHere's some information about my abilities:\n\nSERVER STATUS CHECKER:\nEnter in the port of the service you want to check on Robosane, then just hit 'Check.' If you don't know the port of the service you want, just hit the corresponding button and the field will be filled for you!");
		
		JScrollPane aboutScrollPane = new JScrollPane(aboutTextPane);
		aboutScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aboutScrollPane.setViewportBorder(null);
		tabbedPane.addTab("About", null, aboutScrollPane, null);
		tabbedPane.setEnabledAt(0, true);
		
		JPanel serverStatusPanel = new JPanel();
		
		JScrollPane serverStatusScroller = new JScrollPane(serverStatusPanel);
		
		tabbedPane.addTab("Server Status Checker", null, serverStatusScroller, null);
		serverStatusPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		JSplitPane ServerStatusVerticalPane = new JSplitPane();
		ServerStatusVerticalPane.setContinuousLayout(true);
		ServerStatusVerticalPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		serverStatusPanel.add(ServerStatusVerticalPane);
		
		JSplitPane PortChecking = new JSplitPane();
		PortChecking.setResizeWeight(0.5);
		PortChecking.setContinuousLayout(true);
		ServerStatusVerticalPane.setLeftComponent(PortChecking);
		
		JSplitPane splitPane_3 = new JSplitPane();
		PortChecking.setLeftComponent(splitPane_3);
		
		JLabel lblServerPort = new JLabel("Server Port:");
		splitPane_3.setLeftComponent(lblServerPort);
		
		txtPortNumber = new JTextField();
		txtPortNumber.setText("Port Number");
		splitPane_3.setRightComponent(txtPortNumber);
		txtPortNumber.setColumns(10);
		
		JSplitPane splitPane_4 = new JSplitPane();
		PortChecking.setRightComponent(splitPane_4);
		
		final JLabel lblStatusResponse = new JLabel("Server Status");
		splitPane_4.setLeftComponent(lblStatusResponse);
		
		JButton btnStatusCheck = new JButton("Check");
		splitPane_4.setRightComponent(btnStatusCheck);
		
		JPanel PortsList = new JPanel();
		ServerStatusVerticalPane.setRightComponent(PortsList);
		PortsList.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnWebsite_1 = new JButton("Website");
		PortsList.add(btnWebsite_1);
		
		JButton btnWebsite_2 = new JButton("Website ( HTTPS )");
		PortsList.add(btnWebsite_2);
		
		JButton btnMinecraft = new JButton("Minecraft");
		PortsList.add(btnMinecraft);
		
		JButton btnTerraria = new JButton("Terraria");
		PortsList.add(btnTerraria);
		
		JButton btnGarrysModOr = new JButton("Garry's Mod or Team Fortress 2");
		PortsList.add(btnGarrysModOr);
		
		frmRismcsh.setBackground(Color.LIGHT_GRAY);
		frmRismcsh.setIconImage(Toolkit.getDefaultToolkit().getImage(Win.class.getResource("/misc/bulb.gif")));
		frmRismcsh.setForeground(new Color(153, 0, 0));
		frmRismcsh.setFont(new Font("Ubuntu Medium", Font.PLAIN, 14));
		frmRismcsh.setTitle("RISM-CSH");
		frmRismcsh.setBounds(100, 100, 450, 300);
		frmRismcsh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		String s = "Tomorrow, and tomorrow, and tomorrow, "
//		        + "creeps in this petty pace from day to day, "
//		        + "to the last syllable of recorded time; ... "
//		        + "It is a tale told by an idiot, full of "
//		        + "sound and fury signifying nothing.";
//		Marquee mp = new Marquee(s, 32);
//        frmRismcsh.add(mp);
//        frmRismcsh.pack();
//        frmRismcsh.setLocationRelativeTo(null);
//        frmRismcsh.setVisible(true);
//        mp.start();
		
		// ################################################################
		// ACTION LISTENERS
		
		btnWebsite.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				System.out.println("Opening http://robosane.tk...");
				Functions.openWebpage("http://robosane.tk");
			}
		});
		
		btnStatusCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Checking Server Availability...");
				// TODO Server Check take port number then hostAvailabilityCheck(robosane.tk, port)
				// tell that value to lblStatusResponse
				lblStatusResponse.setText("Checking");
				try {
					int portNumber = Integer.parseInt(txtPortNumber.getText());
					System.out.println("Port Number OK");
					if (Functions.hostAvailabilityCheck("robosane.tk", portNumber)) {
						lblStatusResponse.setText("Online");
						System.out.println("Server Online.");
					} else {
						lblStatusResponse.setText("Unavailable");
						System.out.println("Server did not respond on TCP " + portNumber);
					}
				} catch (Exception portParseException) {
					System.err.println("Port Check Failure.");
					lblStatusResponse.setText("Error");
					//portParseException.printStackTrace();
				}
			}
		});
		
	}
}

package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("unused")
public class Win {

	private JFrame frmRismcsh;
	private JTextField txtPortNumber;

	//Launch the application.
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

	// 3... 2... 1... GO!
	public Win() {
		initialize();
	}

	// Big function to establish the application in Swing
	private void initialize() {
		
		int portNumber;
		String serverAddress;
		
		frmRismcsh = new JFrame();
		frmRismcsh.setType(Type.UTILITY);
		frmRismcsh.getContentPane().setForeground(new Color(102, 0, 0));
		frmRismcsh.setMinimumSize(new Dimension(400, 300));
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Set up our Quick Access Bar at the top.
		JSplitPane splitPane = new JSplitPane();
		splitPane.setForeground(new Color(102, 0, 0));
		frmRismcsh.getContentPane().add(splitPane, BorderLayout.NORTH);
		
		JLabel lblQuick = new JLabel("Quick Access:");
		lblQuick.setToolTipText("These are some buttons to help you perform common actions faster.");
		splitPane.setLeftComponent(lblQuick);
		
		JPanel panelQuick = new JPanel();
		splitPane.setRightComponent(panelQuick);
		
		JButton btnWebsite = new JButton("Website");
		btnWebsite.setBackground(Color.LIGHT_GRAY);
		btnWebsite.setToolTipText("Open robosane.tk in your default browser.");
		panelQuick.add(btnWebsite);
		
		JButton btnForums = new JButton("Forums");
		btnForums.setBackground(Color.LIGHT_GRAY);
		btnForums.setToolTipText("Open Robosane's Forums Page.");
		panelQuick.add(btnForums);
		
		/*
		JSplitPane splitPaneFeed = new JSplitPane();
		splitPaneFeed.setContinuousLayout(true);
		frmRismcsh.getContentPane().add(splitPaneFeed, BorderLayout.SOUTH);
		
		// MARQUEE CODE
		// Baaha I can't get this working...
		
		JLabel label = new JLabel("Latest Article:");
		label.setToolTipText("This is a marquee displaying the latest article from Robosane.");
		splitPaneFeed.setLeftComponent(label);
		
		JLabel lblArticleMarquee = new JLabel("Article Marquee");
		splitPaneFeed.setRightComponent(lblArticleMarquee);
		*/
		
		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		frmRismcsh.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		// ABOUT TAB
		JTextPane aboutTextPane = new JTextPane();
		aboutTextPane.setText("Hi! I'm RISM! I'm a program developed by Robosane to help people do common things quickly. I stand for \"Robosane Interactive Systems Manager.\"\n\nAny bugs, problems, or suggestions, please email robobenklein@gmail.com or create an Issue on my Github page!\n\nAbout me:\n\nQuick Access:\nThese are buttons to help you get to the Robosane Website quickly. Just press a button and you'll be there before you can say \"Hippopotomonstrosesquippedaliophobia\"\n\nServer Status Checker:\nEnter in the port of the service you want to check on Robosane, then just hit 'Check.' If you don't know the port of the service you want, just hit the corresponding button and the field will be filled for you!\n\nOptions:\nThis tab lets you configure how you want the program to behave. The only option right now is to enable/disable the use of HTTPS when opening the Robosane website using the Quick Access buttons.\n\nThe Robosane Technology Philosophy:\n Robosane aims to provide software that not only \"just works,\" but is enjoyable for both users and developers. Our programs should never put users, computers, or anything else at risk, and never use coding tactics that make our code unnecessarily hard to understand. Code can be published under any license, however Robosane encourages developers to Open Source their works.");
		
		JScrollPane aboutScrollPane = new JScrollPane(aboutTextPane);
		aboutScrollPane.setViewportBorder(null);
		tabbedPane.addTab("About", null, aboutScrollPane, null);
		tabbedPane.setEnabledAt(0, true);
		
		// SERVER STATUS CHECKER
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
		
		final JTextField txtServerAddress = new JTextField();
		txtServerAddress.setText("robosane.tk");
		splitPane_3.setLeftComponent(txtServerAddress);
		
		txtPortNumber = new JTextField();
		txtPortNumber.setText("Port");
		splitPane_3.setRightComponent(txtPortNumber);
		txtPortNumber.setColumns(10);
		
		JSplitPane splitPane_4 = new JSplitPane();
		PortChecking.setRightComponent(splitPane_4);
		
		final JLabel lblStatusResponse = new JLabel("Server Status");
		splitPane_4.setLeftComponent(lblStatusResponse);
		
		JButton btnStatusCheck = new JButton("Check");
		splitPane_4.setRightComponent(btnStatusCheck);
		
		// AUTOFILL PORT NUMBERS
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
		
		JButton btnGarrysMod = new JButton("Garry's Mod or Team Fortress 2");
		PortsList.add(btnGarrysMod);
		
		// OPTIONS TAB
		JPanel optionsPane = new JPanel();
		optionsPane.setBorder(null);
		tabbedPane.addTab("Options", null, optionsPane, "Set application preferences");
		
		// UseHTTPS Checkbox
		final JCheckBox chkUseHTTPS = new JCheckBox("Use HTTPS?");
		chkUseHTTPS.setHorizontalAlignment(SwingConstants.CENTER);
		optionsPane.add(chkUseHTTPS);
		chkUseHTTPS.setSelected(Functions.getHTTPS());
		
		// Button to download certificate
		JButton getCert = new JButton("Get HTTPS Certificate");
		optionsPane.add(getCert);
		getCert.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Finish setting up our window & display it.
		frmRismcsh.setBackground(Color.LIGHT_GRAY);
		frmRismcsh.setIconImage(Toolkit.getDefaultToolkit().getImage(Win.class.getResource("/bulb.gif")));
		frmRismcsh.setForeground(new Color(153, 0, 0));
		frmRismcsh.setFont(new Font("Ubuntu Medium", Font.PLAIN, 16));
		frmRismcsh.setTitle("RISM-CSH");
		frmRismcsh.setBounds(100, 100, 500, 350);
		frmRismcsh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ################################################################
		// ACTION LISTENERS
		// ################################################################
		
		// Whenever clicked, open the webpage.
		btnWebsite.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				System.out.println("Opening robosane.tk...");
				Functions.openWebpage("robosane.tk");
			}
		});
		
		// When the forums button is clicked, open the page.
		btnForums.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Opening robosane.tk/kunena/index...");
				Functions.openWebpage("robosane.tk/kunena/index");
			}
		});
		
		// Supply Port for webserver @ 80
		btnWebsite_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtPortNumber.setText("80");
			}
		});
		
		// Supply Port for webserver @ 443
		btnWebsite_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtPortNumber.setText("443");
			}
		});
		
		// Supply Port for Minecraft @ 25565
		btnMinecraft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtPortNumber.setText("25565");
			}
		});
		
		// Supply Port for Terraria @ 7777
		btnTerraria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtPortNumber.setText("7777");
			}
		});
		
		// Supply Port for Garry's Mod @ 27015
		btnGarrysMod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtPortNumber.setText("27015");
			}
		});
		
		// Whenever the checkbox is clicked, take it's value and set the preference.
		chkUseHTTPS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Functions.setHTTPS(chkUseHTTPS.isSelected());
			}
		});
		
		getCert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Functions.openWebpage("robosane.tk/13-system/118-install-robosane-ssl-certificate");
			}
		});
		
		btnStatusCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblStatusResponse.setText("");
				System.out.println("Checking Server Availability...");
				lblStatusResponse.setText(" ... ");
				// Draw the label before the server-check function hangs.
				lblStatusResponse.paintImmediately(lblStatusResponse.getVisibleRect());
				try {
					int portNumber = Integer.parseInt(txtPortNumber.getText());
					String serverAddress = txtServerAddress.getText();
					System.out.println("Port Number OK");
					// Woot I like ASCII Characters
					if (Functions.hostAvailabilityCheck(serverAddress, portNumber)) {
						lblStatusResponse.setText(" ✔ ");
						System.out.println("Server Online.");
					} else {
						lblStatusResponse.setText(" ✘ ");
						System.out.println("Server did not respond on TCP " + portNumber);
					}
				} catch (Exception portParseException) {
					System.err.println("Cannot parse port number \"" + txtPortNumber.getText() + "\"");
					lblStatusResponse.setText("Error");
					//portParseException.printStackTrace();
				}
			}
		});
		
		
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//                      UX CODE ONLY BELOW!
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		// Thanks to StackOverflow "eugener"
		txtServerAddress.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        SwingUtilities.invokeLater(new Runnable() {
		            @Override
		            public void run() {
		                txtServerAddress.selectAll();
		            }
		        });
		    }
		});
		
		txtPortNumber.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        SwingUtilities.invokeLater(new Runnable() {
		            @Override
		            public void run() {
		                txtPortNumber.selectAll();
		            }
		        });
		    }
		});
	}
}

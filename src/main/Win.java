package main;

import java.awt.EventQueue;

import javax.swing.JFrame;

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

import main.Functions;

public class Win {

	private JFrame frmRismcsh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frmRismcsh = new JFrame();
		frmRismcsh.getContentPane().setForeground(new Color(102, 0, 0));
		
		JLabel lblLatestArticle = new JLabel("Latest Article:");
		lblLatestArticle.setToolTipText("This is a marquee displaying the latest article from Robosane.");
		frmRismcsh.getContentPane().add(lblLatestArticle, BorderLayout.SOUTH);
		
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
				// TODO Open Website in browser, then switch to that window
				Functions.openWebpage("http://robosane.tk");
			}
		});
		
	}
}

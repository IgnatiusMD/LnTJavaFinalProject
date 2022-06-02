import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Delete extends JFrame implements ActionListener{
	
	// panel
	JPanel header = new JPanel();
	JPanel body = new JPanel();
	
	// header
	JLabel titleLabel = new JLabel("Delete Menu");
	
	// backButton
	JButton backButton = new JButton("Back");
	
	public void setFrame() {
		this.setVisible(true);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("LnT Final Project");
		this.setLocationRelativeTo(null);
	}

	public Delete() {
		setFrame();
		DeleteMenuTitle();
		DeleteMenuBody();
		
		this.add(header, BorderLayout.NORTH);
		this.add(body, BorderLayout.CENTER);
	}
	
	private void DeleteMenuTitle() {
		header.setPreferredSize(new Dimension(100, 50));
		header.setBackground(Color.decode("#CCF7FF"));
		
		titleLabel.setForeground(Color.decode("#104A00"));
		titleLabel.setFont(new Font("Monaco", Font.BOLD, 20));
		
		header.add(titleLabel);
	}
	
	private void DeleteMenuBody() {
		body.setBackground(Color.decode("#CCF7FF"));
		
		body.add(backButton);
		backButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(backButton)) {
			new MainMenu();
			setVisible(false);
		}
	}


}

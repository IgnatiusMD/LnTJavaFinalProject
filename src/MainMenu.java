import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener{
	
	JPanel header, body;
	
	// Header
	JLabel titleLabel;
	
	// Body
	JButton insertMenu, viewMenu, updateMenu, deleteMenu;
	
	
	public void setFrame() {
		this.setVisible(true);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("LnT Final Project");
		this.setLocationRelativeTo(null);
	}
	
	public MainMenu() {
		setFrame();
		
		// Header
		header = new JPanel();
		header.setPreferredSize(new Dimension(100, 50));
		header.setBackground(Color.decode("#CCF7FF"));
		
		titleLabel = new JLabel("LnT Final Project");
		titleLabel.setForeground(Color.decode("#104A00"));
		titleLabel.setFont(new Font("Monaco", Font.BOLD, 20));
		
		header.add(titleLabel);
		
		// Body
		body = new JPanel(new GridLayout(2, 2));
		
//		body.setPreferredSize(new Dimension(100, 50));
		body.setBackground(Color.decode("#CCF7FF"));
		
		insertMenu = new JButton("Insert");
		insertMenu.setForeground(Color.decode("#104A00"));
		insertMenu.setPreferredSize(new Dimension(150, 30));
		insertMenu.addActionListener(this);
		
		viewMenu = new JButton("View");
		viewMenu.setForeground(Color.decode("#104A00"));
		viewMenu.setPreferredSize(new Dimension(150, 30));
		viewMenu.addActionListener(this);
		
		updateMenu = new JButton("Update");
		updateMenu.setForeground(Color.decode("#104A00"));
		updateMenu.setPreferredSize(new Dimension(150, 30));
		updateMenu.addActionListener(this);
		
		deleteMenu = new JButton("Delete");
		deleteMenu.setForeground(Color.decode("#104A00"));
		deleteMenu.setPreferredSize(new Dimension(150, 30));
		deleteMenu.addActionListener(this);
		
		body.add(insertMenu);
		body.add(viewMenu);
		body.add(updateMenu);
		body.add(deleteMenu);
		
		this.add(header, BorderLayout.NORTH);
		this.add(body, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(insertMenu)) {
			new Insert();
			setVisible(false);
		} else if (e.getSource().equals(viewMenu)) {
			new View();
			setVisible(false);
		} else if (e.getSource().equals(updateMenu)) {
			new Update();
			setVisible(false);
		} else if (e.getSource().equals(deleteMenu)) {
			new Delete();
			setVisible(false);
		}
	}
	
}

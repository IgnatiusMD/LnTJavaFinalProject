import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;

public class Insert extends JFrame implements ActionListener{
	
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();
	Connect db = new Connect();
	
	// panel
	JPanel header = new JPanel();
	JPanel body = new JPanel(new GridLayout(4, 2));
	
	// header
	JLabel titleLabel = new JLabel("Insert Menu");
	
	// namaMenu
	JLabel namaMenu = new JLabel("Nama menu: ");
	JTextField namaMenuText = new JTextField();
	
	// hargaMenu
	JLabel hargaMenu = new JLabel("Harga menu: ");
	JTextField hargaMenuText = new JTextField();
	
	// stockMenu
	JLabel stockMenu = new JLabel("Stok menu: ");
	JTextField stockMenuText = new JTextField();
	
	// submitButton
	JButton submitButton = new JButton("Submit");
	
	// backButton
	JButton backButton = new JButton("Back");
	
	public void setFrame() {
		this.setVisible(true);
		this.setSize(800, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("LnT Final Project");
		this.setLocationRelativeTo(null);
	}
	
	public Insert() {
		setFrame();
		InsertMenuTitle();
		InsertMenuBody();
		
		this.add(header, BorderLayout.NORTH);
		this.add(body, BorderLayout.CENTER);
	}
	
	private void InsertMenuTitle() {
		header.setPreferredSize(new Dimension(100, 50));
		header.setBackground(Color.decode("#CCF7FF"));
		
		titleLabel.setForeground(Color.decode("#104A00"));
		titleLabel.setFont(new Font("Monaco", Font.BOLD, 20));
		
		header.add(titleLabel);
	}
	
	private void InsertMenuBody() {
		body.setBackground(Color.decode("#CCF7FF"));
				
		body.add(namaMenu);
		body.add(namaMenuText);
		
		body.add(hargaMenu);
		body.add(hargaMenuText);
		
		body.add(stockMenu);
		body.add(stockMenuText);
		
		body.add(backButton);
		backButton.addActionListener(this);
		body.add(submitButton);
		submitButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(backButton)) {
			new MainMenu();
			setVisible(false);
		} else if (e.getSource().equals(submitButton)) {
			submit();
			namaMenuText.setText(null);
			hargaMenuText.setText(null);
			stockMenuText.setText(null);
			new MainMenu();
			setVisible(false);
		}
	}

	public void submit() {
		String kode = "PD-";
		String nama = namaMenuText.getText();
		String harga = hargaMenuText.getText();
		String stok = stockMenuText.getText();
		
		kode = kode + rand.nextInt(9) + rand.nextInt(9) + rand.nextInt(9);
		
		db.insertData(kode, nama, harga, stok);
		JOptionPane.showMessageDialog(this, "Data baru telah dimasukkan!");
	}

}

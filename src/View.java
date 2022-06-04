import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame implements ActionListener{
	
	Vector<String> columnName = new Vector<>();
	Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	Connect db = new Connect();
	
	// panel
	JPanel header = new JPanel();
	JPanel body = new JPanel(new GridLayout(4, 2));
	
	// header
	JLabel titleLabel = new JLabel("View Menu");
	
	// backButton
	JButton backButton = new JButton("Back");
	
	// table
	DefaultTableModel dtm;
	JTable dataTable;
	JScrollPane jsp;

	public void setFrame() {
		this.setVisible(true);
		this.setSize(800, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("LnT Final Project");
		this.setLocationRelativeTo(null);
	}
	
	public View() {
		setFrame();
		ViewMenuTitle();
		ViewMenuBody();
		getData();
		
		this.add(header, BorderLayout.NORTH);
		this.add(body, BorderLayout.CENTER);
	}

	private void ViewMenuTitle() {
		header.setPreferredSize(new Dimension(100, 50));
		header.setBackground(Color.decode("#CCF7FF"));
		
		titleLabel.setForeground(Color.decode("#104A00"));
		titleLabel.setFont(new Font("Monaco", Font.BOLD, 20));
		
		header.add(titleLabel);
	}
	
	private void ViewMenuBody() {
		body.setBackground(Color.decode("#CCF7FF"));
		
		// Table
		columnName.add("Kode");
		columnName.add("Nama");
		columnName.add("Harga");
		columnName.add("Stok");
		
		dtm = new DefaultTableModel(data, columnName);
		dataTable = new JTable(dtm);
		jsp = new JScrollPane(dataTable);
		
		jsp.setBounds(20,300,400,200);
		
		body.add(jsp);
		body.add(backButton);
		backButton.addActionListener(this);
	}
	
	public void getData() {
		db.rs = db.getData();
		
		try {
			while (db.rs.next()) {
				Vector<Object> newRow = new Vector<>();
				newRow.add(db.rs.getString("kode"));
				newRow.add(db.rs.getString("nama"));
				newRow.add(db.rs.getString("harga"));
				newRow.add(db.rs.getString("stok"));
				
				data.add(newRow);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
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

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

public class Update extends JFrame implements ActionListener{
	
	// panel
	JPanel header = new JPanel();
	JPanel body = new JPanel(new GridLayout(5, 3));
	
	// header
	JLabel titleLabel = new JLabel("Update Menu");
	
	// kodeMenu
	JLabel kodeMenu = new JLabel("Kode yang ingin diubah: ");
	JTextField kodeMenuText = new JTextField();
	
	// namaMenu
	JLabel namaMenu = new JLabel("Nama menu: ");
	JTextField namaMenuText = new JTextField();
	
	// hargaMenu
	JLabel hargaMenu = new JLabel("Harga menu: ");
	JTextField hargaMenuText = new JTextField();
	
	// stockMenu
	JLabel stockMenu = new JLabel("Stok menu: ");
	JTextField stockMenuText = new JTextField();
	
	// Button
	JButton backButton = new JButton("Back");
	JButton updateButton = new JButton ("Update");
	
	// view
	DefaultTableModel dtm;
	JTable dataTable;
	JScrollPane jsp;
	Vector<String> columnName = new Vector<>();
	Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	Connect db = new Connect();

	public void setFrame() {
		this.setVisible(true);
		this.setSize(800, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("LnT Final Project");
		this.setLocationRelativeTo(null);
	}
	
	public Update() {
		setFrame();
		getData();
		UpdateMenuTitle();
		UpdateMenuBody();
		
		this.add(header, BorderLayout.NORTH);
		this.add(body, BorderLayout.CENTER);
	}
	
	private void UpdateMenuTitle() {
		header.setPreferredSize(new Dimension(100, 50));
		header.setBackground(Color.decode("#CCF7FF"));
		
		titleLabel.setForeground(Color.decode("#104A00"));
		titleLabel.setFont(new Font("Monaco", Font.BOLD, 20));
		
		header.add(titleLabel);
	}
	
	private void UpdateMenuBody() {
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
		
		body.add(kodeMenu);
		body.add(kodeMenuText);
		
		body.add(namaMenu);
		body.add(namaMenuText);
		
		body.add(hargaMenu);
		body.add(hargaMenuText);
		
		body.add(stockMenu);
		body.add(stockMenuText);
		
		body.add(backButton);
		body.add(updateButton);
		backButton.addActionListener(this);
		updateButton.addActionListener(this);
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
		} else if (e.getSource().equals(updateButton)) {
			update();
			new MainMenu();
			setVisible(false);
		}
	}
	
	public void update() {
		int index = dataTable.getSelectedRow();
		
		String kode = kodeMenuText.getText();
		String nama = namaMenuText.getText();
		String harga = hargaMenuText.getText();
		String stok = stockMenuText.getText();
		
		JOptionPane.showMessageDialog(this, "Data telah diupdate!");
		
		db.updateData(kode, nama, harga, stok);
		dtm.setValueAt(kode, index, 0);
		dtm.setValueAt(nama, index, 1);
		dtm.setValueAt(harga, index, 2);
		dtm.setValueAt(stok, index, 3);
	}

}

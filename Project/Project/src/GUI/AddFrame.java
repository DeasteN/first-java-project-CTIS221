package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Inheritance.Accessory;
import MainAndSystemClass.ClothingSys;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class AddFrame extends JFrame {
	
	private boolean upd;
	public void setUpdate(boolean upd) {
		this.upd=upd;	
	}
	 
	private JPanel contentPane;
	private JTextField nameTF;
	private JTextField barcodeTF;
	private JTextField suitSizeTF;
	private JTextField priceTF;
	private JTextField tieColorTF;
	private JTextField dressSizeTF;
	private JTextField dressColorTF;
	private JTextField accTF;
	
	 private final ButtonGroup buttonGroup = new ButtonGroup();
	 private JRadioButton MenRB;
	 private JRadioButton womenRB;
	 private JLabel lblNewLabel;
	 private JPanel panel;
	 private JButton clearBTN;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	 public void clearAll() {
			barcodeTF.setText("");
			nameTF.setText("");
			priceTF.setText("");
			dressSizeTF.setText("");
			dressColorTF.setText("");
			accTF.setText("");
			suitSizeTF.setText("");
			tieColorTF.setText("");
		}
	 
	public AddFrame(MainFrame mf) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameTF = new JTextField();
		nameTF.setBounds(69, 231, 86, 20);
		contentPane.add(nameTF);
		nameTF.setColumns(10);
		
		barcodeTF = new JTextField();
		barcodeTF.setBounds(69, 129, 86, 20);
		contentPane.add(barcodeTF);
		barcodeTF.setColumns(10);
		
		suitSizeTF = new JTextField();
		suitSizeTF.setBounds(456, 129, 86, 20);
		contentPane.add(suitSizeTF);
		suitSizeTF.setColumns(10);
		
		priceTF = new JTextField();
		priceTF.setBounds(69, 323, 86, 20);
		contentPane.add(priceTF);
		priceTF.setColumns(10);
		
		tieColorTF = new JTextField();
		tieColorTF.setBounds(456, 231, 86, 20);
		contentPane.add(tieColorTF);
		tieColorTF.setColumns(10);
		
		dressSizeTF = new JTextField();
		dressSizeTF.setBounds(262, 129, 86, 20);
		contentPane.add(dressSizeTF);
		dressSizeTF.setColumns(10);
		
		dressColorTF = new JTextField();
		dressColorTF.setBounds(262, 231, 86, 20);
		contentPane.add(dressColorTF);
		dressColorTF.setColumns(10);
		
		accTF = new JTextField();
		accTF.setBounds(262, 323, 280, 20);
		contentPane.add(accTF);
		accTF.setColumns(10);
		
		JLabel b = new JLabel("Barcode");
		b.setBounds(13, 132, 65, 14);
		contentPane.add(b);
		
		JLabel n = new JLabel("Name");
		n.setBounds(13, 234, 46, 14);
		contentPane.add(n);
		
		JLabel p = new JLabel("Price");
		p.setBounds(13, 326, 46, 14);
		contentPane.add(p);
		
		JLabel ds = new JLabel("Dress Size");
		ds.setBounds(182, 132, 87, 14);
		contentPane.add(ds);
		
		JLabel dc = new JLabel("Dress Color");
		dc.setBounds(182, 234, 87, 14);
		contentPane.add(dc);
		
		JLabel a = new JLabel("Accessories");
		a.setBounds(182, 326, 87, 14);
		contentPane.add(a);
		
		JLabel ss = new JLabel("Suit Size");
		ss.setBounds(381, 132, 65, 14);
		contentPane.add(ss);
		
		JLabel tc = new JLabel("Tie Color");
		tc.setBounds(381, 234, 65, 14);
		contentPane.add(tc);
		
		JLabel msgLabel = new JLabel("");
		msgLabel.setBounds(13, 69, 239, 14);
		contentPane.add(msgLabel);
		
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ClothingSys.getClothing().containsKey(Integer.parseInt(barcodeTF.getText()))) {
					msgLabel.setText("Barcode already exists!");

				}
				else {
					
				
				ArrayList<Accessory> al=null;
				Accessory ac=null;
				String[] accessory =null;
				
				if(MenRB.isSelected()) {
					if(barcodeTF.getText().equals("")||nameTF.getText().equals("")||priceTF.getText().equals("")||suitSizeTF.getText().equals("")||tieColorTF.getText().equals("")) {
						msgLabel.setText("Fill All Fields!");
					}
					else {
						ClothingSys.addClothing("Men", Integer.parseInt(barcodeTF.getText()), nameTF.getText(), Integer.parseInt(priceTF.getText()), suitSizeTF.getText(), tieColorTF.getText(), null, null, null);
						msgLabel.setText("Done!");
					}
				}
				else if(womenRB.isSelected()){
					if(barcodeTF.getText().equals("")||nameTF.getText().equals("")||priceTF.getText().equals("")||dressColorTF.getText().equals("")||dressSizeTF.getText().equals("")||accTF.getText().equals("")) {
						msgLabel.setText("Fill All Fields!");
					}
					else {
						accessory= new String[10];
						accessory = accTF.getText().split(" ");
						al=new ArrayList();
						
						for(int i = 0; i< accessory.length ; i++) {
							ac=new Accessory(accessory[i]);
							al.add(ac);
						}
						ClothingSys.addClothing("Women", Integer.parseInt(barcodeTF.getText()), nameTF.getText(), Integer.parseInt(priceTF.getText()), null, null, dressColorTF.getText(), dressSizeTF.getText(), al);
						msgLabel.setText("Done!");
					}
				}
				}
			}
		});
		addBtn.setBounds(66, 385, 89, 23);
		contentPane.add(addBtn);
		
		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.setVisible(true);
				clearAll();
				dispose();
			}
		});
		closeBtn.setBounds(453, 385, 89, 23);
		contentPane.add(closeBtn);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(262, 6, 260, 95);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Choose Gender:");
		lblNewLabel.setBounds(79, 20, 99, 16);
		panel.add(lblNewLabel);
		
		womenRB = new JRadioButton();
		womenRB.setBounds(6, 48, 86, 23);
		panel.add(womenRB);
		buttonGroup.add(womenRB);
		womenRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					suitSizeTF.setEditable(false);
					tieColorTF.setEditable(false);
					dressSizeTF.setEditable(true);
					dressColorTF.setEditable(true);
					accTF.setEditable(true);
			}
		});
		womenRB.setText("Women");
		
		MenRB = new JRadioButton();
		MenRB.setBounds(196, 48, 110, 23);
		panel.add(MenRB);
		MenRB.setSelected(false);
		buttonGroup.add(MenRB);
		MenRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					suitSizeTF.setEditable(true);
					tieColorTF.setEditable(true);
					dressSizeTF.setEditable(false);
					dressColorTF.setEditable(false);
					accTF.setEditable(false);	
			}
		});
		MenRB.setText("Men");
		
		clearBTN = new JButton("Clear");
		clearBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAll();
			}
		});
		clearBTN.setBounds(250, 382, 117, 29);
		contentPane.add(clearBTN);
		
		
	}
	
		
	}

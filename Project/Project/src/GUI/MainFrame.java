package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainAndSystemClass.ClothingSys;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import Inheritance.Clothing;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	
	AddFrame af = new AddFrame(this);
	private JTextField deleteTF;
	
	public MainFrame() {
		
		setTitle("My Shopping Card");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(404, 13, 262, 335);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Read");
		btnNewButton.setBounds(33, 30, 155, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClothingSys.readToSet();
				textArea.setText("File is Read.");
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBounds(33, 98, 155, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				af.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Display By Name");
		btnNewButton_2.setBounds(216, 30, 155, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ClothingSys.getClothing().isEmpty())
					textArea.setText("Set is empty!");
				else
				textArea.setText(ClothingSys.displayByName());
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Display By Price");
		btnNewButton_3.setBounds(216, 98, 155, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ClothingSys.getClothing().isEmpty())
					textArea.setText("Set is empty!");
				else
				textArea.setText(ClothingSys.displayByPrice());
			}
		});
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Close");
		btnNewButton_4.setBounds(36, 325, 141, 23);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnNewButton_4);
		
		JButton totalBTN = new JButton("Display Total");
		totalBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ClothingSys.getClothing().isEmpty())
					textArea.setText("Set is empty!");
				else
				textArea.setText(ClothingSys.totalPrice());
			}
		});
		totalBTN.setBounds(33, 171, 144, 29);
		contentPane.add(totalBTN);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		panel.setBounds(216, 156, 165, 192);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter barcode: ");
		lblNewLabel.setBounds(17, 31, 94, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("press enter ");
		lblNewLabel_1.setBounds(40, 136, 94, 16);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Search", "Delete"}));
		comboBox.setBounds(17, 97, 130, 27);
		panel.add(comboBox);
		
		JButton btnNewButton_5 = new JButton("DISCOUNT");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ClothingSys.getClothing().isEmpty())
					textArea.setText("Set is empty!");
				else {
					textArea.setText(ClothingSys.discount());
					btnNewButton_5.setEnabled(false);	
				}
				
			}
		});
		btnNewButton_5.setBounds(36, 242, 141, 29);
		contentPane.add(btnNewButton_5);
		
		deleteTF = new JTextField();
		deleteTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(comboBox.getSelectedIndex()==1)//delete
						if(!deleteTF.getText().isEmpty()) {
							if(ClothingSys.deleteItem(Integer.parseInt(deleteTF.getText())))
								textArea.setText("Item deleted");
							else textArea.setText("Item does not exist");
							
						}
						else textArea.setText("Enter Barcode");
					else { //search
						if(!deleteTF.getText().isEmpty()) {
							Clothing c = ClothingSys.search(Integer.parseInt(deleteTF.getText()));
							if(c!=null)
								textArea.setText(c.toString());
							else textArea.setText("Item does not exist");
						}
						else textArea.setText("Enter Barcode");
					}
				}
			}
		});
		deleteTF.setBounds(17, 59, 130, 26);
		panel.add(deleteTF);
		deleteTF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("after entering barcode");
		lblNewLabel_2.setBounds(6, 152, 142, 16);
		panel.add(lblNewLabel_2);
	}
}

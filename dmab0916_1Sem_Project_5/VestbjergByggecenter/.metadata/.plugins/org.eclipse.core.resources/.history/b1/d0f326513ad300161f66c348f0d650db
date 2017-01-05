package ui.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ShowOrdersView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtSg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowOrdersView frame = new ShowOrdersView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShowOrdersView() {
		setTitle("Vis Ordre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 110, 596, 338);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtSg = new JTextField();
		txtSg.setText("S\u00F8g");
		txtSg.setBounds(95, 67, 144, 20);
		contentPane.add(txtSg);
		txtSg.setColumns(10);
		
		JLabel lblOrderView = new JLabel("Ordreoversigt");
		lblOrderView.setBounds(336, 89, 98, 14);
		contentPane.add(lblOrderView);
	}
}

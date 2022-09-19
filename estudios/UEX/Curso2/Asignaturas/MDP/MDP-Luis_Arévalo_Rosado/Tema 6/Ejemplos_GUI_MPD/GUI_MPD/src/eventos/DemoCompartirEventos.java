package eventos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DemoCompartirEventos {

	private JButton btnHola;
	private JButton btnAdios;
	private JPanel contentPane;
	private JFrame f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoCompartirEventos frame = new DemoCompartirEventos();
					frame.f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public DemoCompartirEventos() {
		f= new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		f.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnHola = new JButton("Hola");
		btnHola.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateAction(e);
			}
		});
		panel.add(btnHola);
		
		btnAdios = new JButton("Adios");
		btnAdios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateAction(e);
			}
		});
		panel.add(btnAdios);
	}


	public void updateAction(ActionEvent e) {
		
		Object e1=e.getSource(); 
		if (e1==btnHola){
			JOptionPane.showMessageDialog(null,"Hola");
		} else if (e1==btnAdios){
			JOptionPane.showMessageDialog(null,"Adios");
		}	
	}

}

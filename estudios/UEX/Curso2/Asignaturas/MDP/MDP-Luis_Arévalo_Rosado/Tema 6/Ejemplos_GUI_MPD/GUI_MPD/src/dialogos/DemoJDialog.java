package dialogos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DemoJDialog extends JFrame {

	private JPanel contentPane;
	DemoJDialog2 ventanaLlamada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoJDialog frame = new DemoJDialog();
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
	public DemoJDialog() {
		setTitle("Ejemplo de JDialog");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnLanzaVentanaModal = new JButton("Lanza Ventana Modal");
		btnLanzaVentanaModal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventanaLlamada.setModal(true);
				ventanaLlamada.setVisible(true);
			}
		});
		contentPane.add(btnLanzaVentanaModal);
		ventanaLlamada= new DemoJDialog2();
		
		
	}

}

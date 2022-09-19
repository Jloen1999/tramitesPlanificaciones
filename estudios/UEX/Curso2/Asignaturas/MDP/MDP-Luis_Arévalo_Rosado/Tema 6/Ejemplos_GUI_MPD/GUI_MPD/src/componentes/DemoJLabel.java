package componentes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class DemoJLabel extends JFrame {

	private JPanel contentPane;
	
	private final JLabel label = new JLabel("Prueba de JLabel");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoJLabel frame = new DemoJLabel();
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
	public DemoJLabel() {
		setTitle("Prueba JLabel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 150,200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblPruebaEtiqueta = new JLabel("Prueba Etiqueta");
		contentPane.add(lblPruebaEtiqueta, BorderLayout.NORTH);
		
		JLabel lblEtiqueta = new JLabel("Etiqueta2");
		lblEtiqueta.setFont(new Font("Courier 10 Pitch", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(lblEtiqueta, BorderLayout.SOUTH);
	}

}

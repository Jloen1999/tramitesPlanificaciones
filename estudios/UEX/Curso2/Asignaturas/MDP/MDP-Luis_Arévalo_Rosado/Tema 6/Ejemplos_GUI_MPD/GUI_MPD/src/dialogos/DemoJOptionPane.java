package dialogos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DemoJOptionPane extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoJOptionPane frame = new DemoJOptionPane();
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
	public DemoJOptionPane() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JOptionPane.showMessageDialog(this,
				"Valores errónos", "Error",
				JOptionPane.INFORMATION_MESSAGE);
		
		int resultado = JOptionPane.showConfirmDialog(this, "¿De acuerdo?");
		if (JOptionPane.OK_OPTION == resultado)
			System.out.println("Genial");
		else
			System.out.println("Don't worry");
		
		// Con caja de texto
		String numero= JOptionPane.showInputDialog(
		   this,
		   "Introduce un número",
		   JOptionPane.QUESTION_MESSAGE);  
		        
		System.out.println("Valor"+numero);
	}

}

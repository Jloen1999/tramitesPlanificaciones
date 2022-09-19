package componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DemoJButton extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoJButton frame = new DemoJButton();
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
	public DemoJButton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JButton boton1 = new JButton();
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Saludo", "Hola Luis",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		boton1.setBounds(new Rectangle(107, 50, 102, 41));
		boton1.setBackground(new Color(91, 238, 89));
		boton1.setForeground(Color.red);
		boton1.setToolTipText("Prueba");
		boton1.setFont(new Font("Comic Sans MS",Font.BOLD, 14));
		boton1.setText("Botón de prueba");
		boton1.setMnemonic(KeyEvent.VK_B);
		contentPane.add(boton1);
	}

}

package componentes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Ejemplo de JList
 */
public class DemoJList extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label;
	JList numeroList;
    public DemoJList() {
        super(new BorderLayout());
 
        String[] numeros = { "Uno", "Dos", "Tres", "Cuatro", "Cinco" };
 
        //Create the combo box, select the item at index 4.
        //Indices start at 0, so 4 specifies the five number.
        numeroList= new JList(numeros);
        numeroList.setSelectedIndex(4);        
        
 
        //Lay out the demo.
        add(numeroList, BorderLayout.PAGE_START);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
        label= new JLabel("Valor");
        add(label, BorderLayout.CENTER);
        
        JButton btnActualizarValores = new JButton("Actualizar valores");
        btnActualizarValores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		int[] selectedIx = numeroList.getSelectedIndices();
        		StringBuffer sb= new StringBuffer("Valor:");
        		// Get all the selected items using the indices
        		for (int i=0; i<selectedIx.length; i++) {
        		    sb.append(numeroList.getModel().getElementAt(selectedIx[i]).toString());
        		}
        		label.setText(sb.toString());
        	}
        });
        add(btnActualizarValores, BorderLayout.SOUTH);
    }  
 
 
   
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ComboBoxDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new DemoJList();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}

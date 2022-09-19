package componentes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
/*
 * ComboBoxDemo.java 
 */
public class DemoJComboBox extends JPanel
                          implements ActionListener {
	JLabel label; 
    public DemoJComboBox() {
        super(new BorderLayout());
 
        String[] numeros = { "Uno", "Dos", "Tres", "Cuatro", "Cinco" };
 
        //Create the combo box, select the item at index 4.
        //Indices start at 0, so 4 specifies the five number.
        JComboBox numeroList = new JComboBox(numeros);
        numeroList.setSelectedIndex(4);
        numeroList.addActionListener(this);
        
 
        //Lay out the demo.
        add(numeroList, BorderLayout.PAGE_START);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
        label= new JLabel("Valor");
        add(label, BorderLayout.CENTER);
        label.setText("Valor:"+ (String)numeroList.getSelectedItem());
    }
 
    /** Listens to the combo box. */
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String num = (String)cb.getSelectedItem();
         label.setText("Valor:"+ num);
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
        JComponent newContentPane = new DemoJComboBox();
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
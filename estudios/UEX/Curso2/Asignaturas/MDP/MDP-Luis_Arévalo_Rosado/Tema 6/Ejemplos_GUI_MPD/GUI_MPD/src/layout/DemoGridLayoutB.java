// Demostracion de GridLayout.

package layout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DemoGridLayoutB extends JFrame implements ActionListener
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JButton botones[];
   private final String nombres[] = 
      { "uno", "dos", "tres", "cuatro", "cinco", "seis" };
   private boolean alternar = true;
   private Container contenedor;
   private GridLayout cuadricula1, cuadricula2;

   // configurar GUI
   public DemoGridLayoutB()
   {
      super( "Demostracion de GridLayout" );

      // establecer esquemas
      cuadricula1 = new GridLayout( 2, 3, 10, 10 );
      cuadricula2 = new GridLayout( 3, 2 );

      // obtener panel de contenido y establecer su esquema
      contenedor = getContentPane();
      contenedor.setLayout( cuadricula1 );

      // crear y agregar botones
      botones = new JButton[ nombres.length ];

      for ( int cuenta = 0; cuenta < nombres.length; cuenta++ ) {
         botones[ cuenta ] = new JButton( nombres[ cuenta ] );
         botones[ cuenta ].addActionListener( this );
         botones[ cuenta ].setToolTipText("Cambia el esquema de GridLayout");
         contenedor.add( botones[ cuenta ] );
      }

      setSize( 300, 150 );
      setVisible( true );

   } // fin del constructor de DemoGridLayout

   // manejar eventos de boton, alternando entre los esquemas
   public void actionPerformed( ActionEvent evento )
   { 
      if ( alternar )
         contenedor.setLayout( cuadricula2 );
      else
         contenedor.setLayout( cuadricula1 );

      alternar = !alternar;   // establecer alternar en el valor opuesto
      contenedor.validate();
   }

   public static void main( String args[] )
   {
      DemoGridLayoutB aplicacion = new DemoGridLayoutB();
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   } 

} // fin de la clase DemoGridLayout
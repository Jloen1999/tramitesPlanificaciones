// Demostracion de BorderLayout.

package layout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DemoBorderLayout extends JFrame implements ActionListener
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JButton botones[];
   private final String nombres[] = { "Ocultar norte", "Ocultar sur", 
      "Ocultar este", "Ocultar oeste", "Ocultar centro" };
   private BorderLayout esquema;

   // configurar GUI y el manejo de eventos
   public DemoBorderLayout()
   {
      super( "Demostracion de BorderLayout" );

      esquema = new BorderLayout( 5, 5 ); // espacios libres de 5 pixeles

      // obtener panel de contenido y establecer su esquema
      Container contenedor = getContentPane();
      contenedor.setLayout( esquema );

      // instanciar objetos boton
      botones = new JButton[ nombres.length ];

      for ( int cuenta = 0; cuenta < nombres.length; cuenta++ ) {
         botones[ cuenta ] = new JButton( nombres[ cuenta ] );
         botones[ cuenta ].addActionListener( this );
         botones[ cuenta ].setToolTipText("Borra del contenedor al boton "+nombres[cuenta]);
      }

      // colocar botones en BorderLayout; no importa el orden
      contenedor.add( botones[ 0 ], BorderLayout.NORTH ); 
      contenedor.add( botones[ 1 ], BorderLayout.SOUTH ); 
      contenedor.add( botones[ 2 ], BorderLayout.EAST );  
      contenedor.add( botones[ 3 ], BorderLayout.WEST );  
      contenedor.add( botones[ 4 ], BorderLayout.CENTER ); 

      setSize( 350, 200 );
      setVisible( true );

   } // fin del constructor de DemoBorderLayout

   // manejar eventos de boton
   public void actionPerformed( ActionEvent evento )
   {
      for ( int cuenta = 0; cuenta < botones.length; cuenta++ )

         if ( evento.getSource() == botones[ cuenta ] )
            botones[ cuenta ].setVisible( false );
         else
            botones[ cuenta ].setVisible( true );

      // re-esquematizar el panel de contenido
      esquema.layoutContainer( getContentPane() );
   }

   public static void main( String args[] )
   { 
      DemoBorderLayout aplicacion = new DemoBorderLayout();
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // fin de la clase DemoBorderLayout
// Demostraci�n de BoxLayout.

package layout;

import java.awt.*;
import javax.swing.*;

public class DemoBoxLayout2 extends JFrame {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

// configurar GUI
   public DemoBoxLayout2()
   {
      super( "Demo de BoxLayout" );

      // crear contenedores Box con esquema BoxLayout
      Box horizontal1 = Box.createHorizontalBox();
      Box vertical1 = Box.createVerticalBox();
      Box horizontal2 = Box.createHorizontalBox();
      Box vertical2 = Box.createVerticalBox();

      final int TAMANIO = 3; // n�mero de botones en cada contenedor Box

      // agregar botones al objeto Box horizontal1
      for ( int cuenta = 0; cuenta < TAMANIO; cuenta++ )
         horizontal1.add( new JButton( "Bot�n " + cuenta ) );

      // crear montante y agregar botones al objeto Box vertical1
      for ( int cuenta = 0; cuenta < TAMANIO; cuenta++ ) {
         vertical1.add( Box.createVerticalStrut( 25 ) );
         vertical1.add( new JButton( "Bot�n " + cuenta ) );
      }

      // crear pegamento horizontal y agregar botones al objeto Box horizontal2
      for ( int cuenta = 0; cuenta < TAMANIO; cuenta++ ) {
         horizontal2.add( Box.createHorizontalGlue() );
         horizontal2.add( new JButton( "Bot�n " + cuenta ) );
      }

      // crear �rea r�gida y agregar botones al objeto Box vertical2
      for ( int cuenta = 0; cuenta < TAMANIO; cuenta++ ) {
         vertical2.add( Box.createRigidArea( new Dimension( 12, 8 ) ) );
         vertical2.add( new JButton( "Bot�n " + cuenta ) );
      }

      // crear pegamento vertical y agregar botones al panel
      JPanel panel = new JPanel();
      panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );

      for ( int cuenta = 0; cuenta < TAMANIO; cuenta++ ) {
         panel.add( Box.createGlue() );
         panel.add( new JButton( "Bot�n " + cuenta ) );
      }

      // crear un objeto JTabbedPane
      JTabbedPane fichas = new JTabbedPane( 
         JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT ); 

      // colocar cada contendor en panel con fichas
      fichas.addTab( "Cuadro horizontal", horizontal1 );
      fichas.addTab( "Cuadro vertical con montantes", vertical1 );
      fichas.addTab( "Cuadro horizontal con pegamento", horizontal2 );
      fichas.addTab( "Cuadro vertical con �reas r�gidas", vertical2 );
      fichas.addTab( "Cuadro vertical con pegamento", panel );

      getContentPane().add( fichas );  // colocar panel con fichas en el panel de contenido

      setSize( 400, 220 );
      setVisible( true );

   } // fin del constructor

   public static void main( String args[] )
   {
      DemoBoxLayout2 aplicacion = new DemoBoxLayout2();
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // fin de la clase DemoBoxLayout
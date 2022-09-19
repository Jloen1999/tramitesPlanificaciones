// Seleccionar colores con JColorChooser.
package grafico;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MostrarColores2 extends JFrame
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JButton cambiarColorBoton;
   private Color color = Color.LIGHT_GRAY;
   private Container contenedor;

   // configurar GUI
   public MostrarColores2()
   {
      super( "Uso de JColorChooser" );

      contenedor = getContentPane();
      contenedor.setLayout( new FlowLayout() );

      // configurar cambiarColorBoton y registrar su manejador de eventos
      cambiarColorBoton = new JButton( "Cambiar color" );
      cambiarColorBoton.addActionListener(

         new ActionListener() {  // clase interna an�nima

            // mostrar JColorChooser cuando el usuario haga clic en el bot�n
            public void actionPerformed( ActionEvent evento )
            {
               color = JColorChooser.showDialog( 
                  MostrarColores2.this, "Seleccione un color", color );

               // establecer color predeterminado, si no se devuelve un color 
               if ( color == null )
                  color = Color.LIGHT_GRAY;

               // cambiar color de fondo del panel de contenido
               contenedor.setBackground( color );
            }

         } // fin de la clase interna an�nima

      ); // fin de la llamada a addActionListener
 
      contenedor.add( cambiarColorBoton );

      setSize( 400, 130 );
      setVisible( true );

   } // fin del constructor de MostrarCOlores2

   // ejecutar la aplicaci�n
   public static void main( String args[] )
   {
      MostrarColores2 aplicacion = new MostrarColores2();
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // fin de la clase MostrarColores2
// Demostraci�n de los colores.
package grafico;

import java.awt.*;
import javax.swing.*;

public class MostrarColores extends JFrame {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

// el constructor establece cadena de barra de t�tulo y dimensiones de la ventana
   public MostrarColores()
   {
      super( "Uso de los colores" );

      setSize( 400, 130 );
      setVisible( true );
   }

   // dibujar rect�ngulos y objetos String en distintos colores
   public void paint( Graphics g )
   {
      // llamar al m�todo paint de la superclase
      super.paint( g );

      // establecer nuevo color de dibujo utilizando enteros
      g.setColor( new Color( 255, 0, 0 ) );
      g.fillRect( 25, 25, 100, 20 );
      g.drawString( "RGB actual: " + g.getColor(), 130, 40 );

      // establecer nuevo color de dibujo utilizando valores float
      g.setColor( new Color( 0.0f, 1.0f, 0.0f ) );
      g.fillRect( 25, 50, 100, 20 );
      g.drawString( "RGB actual: " + g.getColor(), 130, 65 );

      // establecer nuevo color de dibujo utilizando objetos Color est�ticos
      g.setColor( Color.BLUE );
      g.fillRect( 25, 75, 100, 20 );
      g.drawString( "RGB actual: " + g.getColor(), 130, 90 );

      // mostrar valores RGB individuales
      Color color = Color.MAGENTA;
      g.setColor( color );
      g.fillRect( 25, 100, 100, 20 );
      g.drawString( "Valores RGB: " + color.getRed() + ", " +
         color.getGreen() + ", " + color.getBlue(), 130, 115 );

   } // fin del m�todo paint

   // ejecutar la aplicaci�n
   public static void main( String args[] )
   {
      MostrarColores aplicacion = new MostrarColores();
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // fin de la clase MostrarColores
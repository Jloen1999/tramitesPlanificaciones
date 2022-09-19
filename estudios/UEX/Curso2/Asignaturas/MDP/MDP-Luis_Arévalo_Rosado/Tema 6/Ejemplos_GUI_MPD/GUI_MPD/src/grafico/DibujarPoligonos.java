// Dibujo de pol�gonos.
package grafico;

import java.awt.*;
import javax.swing.*;

public class DibujarPoligonos extends JFrame {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

// establecer cadena de barra de t�tulo y dimensiones de la ventana
   public DibujarPoligonos()
   {
      super( "Dibujo de pol�gonos" );

      setSize( 275, 230 );
      setVisible( true );
   }

   // dibujar pol�gonos y polil�neas
   public void paint( Graphics g )
   {
      super.paint( g );  // llamar al m�todo paint de la superclase

      int valoresX[] = { 20, 40, 50, 30, 20, 15 };
      int valoresY[] = { 50, 50, 60, 80, 80, 60 };
      Polygon poligono1 = new Polygon( valoresX, valoresY, 6 );

      g.drawPolygon( poligono1 );

      int valoresX2[] = { 70, 90, 100, 80, 70, 65, 60 };
      int valoresY2[] = { 100, 100, 110, 110, 130, 110, 90 };

      g.drawPolyline( valoresX2, valoresY2, 7 );

      int valoresX3[] = { 120, 140, 150, 190 };
      int valoresY3[] = { 40, 70, 80, 60 };

      g.fillPolygon( valoresX3, valoresY3, 4);

      Polygon poligono2 = new Polygon();
      poligono2.addPoint( 165, 135 );
      poligono2.addPoint( 175, 150 );
      poligono2.addPoint( 270, 200 );
      poligono2.addPoint( 200, 220 );
      poligono2.addPoint( 130, 180 );

      g.fillPolygon( poligono2 );

   } // fin del m�todo paint

   // ejecutar la aplicaci�n
   public static void main( String args[] )
   {
      DibujarPoligonos aplicacion = new DibujarPoligonos();
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // fin de la clase DibujarPoligonos
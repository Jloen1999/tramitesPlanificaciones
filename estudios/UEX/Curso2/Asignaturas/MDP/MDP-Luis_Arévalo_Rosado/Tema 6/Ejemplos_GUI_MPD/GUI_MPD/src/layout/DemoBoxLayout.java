package layout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;

public class DemoBoxLayout{
    private JPanel panelSuperior, panelMedio, panelInferior;
    private JLabel etiqueta1, etiqueta2, etiqueta3;
    private JTextField cajaTexto;
    private JPasswordField cajaPass;
    private JButton botonAceptar, botonCancelar;
    private JFrame frame;

    public void construyePanelSuperior(){
        panelSuperior =new JPanel();
        etiqueta2= new JLabel("Usuario");
        cajaTexto = new JTextField(10);
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.X_AXIS));
        panelSuperior.add(etiqueta2);
        panelSuperior.add(cajaTexto);
    }

    public void construyePanelMedio(){
        panelMedio=new JPanel();
        etiqueta3= new JLabel("Password");
        cajaPass = new JPasswordField(10);
        panelMedio.setLayout(new BoxLayout(panelMedio, BoxLayout.X_AXIS));
        panelMedio.add(etiqueta3);
        panelMedio.add(cajaPass);
    }

    public void construyePanelInferior(){
        panelInferior=new JPanel();
        botonAceptar=new JButton("Aceptar");
        botonCancelar=new JButton("Cancelar");
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
        panelInferior.add(botonAceptar);
        panelInferior.add(botonCancelar);
    }

    public void construyeVentana(){
        frame = new JFrame();
        etiqueta1 = new JLabel("Prueba de BoxLayout");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS) );
        frame.add(etiqueta1);
        frame.add(panelSuperior);
        frame.add(panelMedio);
        frame.add(panelInferior);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public DemoBoxLayout(){
        construyePanelSuperior();
        construyePanelMedio();
        construyePanelInferior();
        construyeVentana();
    }

    public static void main (String [] args){
        new DemoBoxLayout();
    }
}
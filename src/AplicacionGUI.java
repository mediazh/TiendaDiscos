import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AplicacionGUI implements ActionListener{
	static String PrefijoEtiqueta = "ventas";
	int numClics=0;
	JLabel Label = new JLabel (PrefijoEtiqueta);
		public Component crearComponentes(){
			JButton boton = new JButton ("Rock'o");
			boton.addActionListener (this);
			Label.setLabelFor(boton);
		     JPanel panel = new JPanel();
			 panel.setLayout(new GridLayout(0,1)); 
			 panel.add(boton);
			 panel.add(Label); 
			 return panel;		
		}
		public void actionPerformed (ActionEvent aevt){
				numClics++;
				Label.setText(PrefijoEtiqueta+"."+numClics); 
		}
         public void crearYmostrarGUI(){
            JFrame ventana= new JFrame ("Mi Aplicacion");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Component contenido = this.crearComponentes();
            Container contenedor = ventana.getContentPane(); 
             contenedor.add(contenido);
			ventana.pack();
			ventana.setVisible(true);
		}
	}	
package grafica;

import java.awt.Color;
import logica.Menu;
import multimedia.Fuente;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuGrafico {

	private JFrame frame;
	private JTextField txtFieldNombre;
	public JButton  btnJugar;
	private Font pixelNum,pixelNombreUsuario,pixelCarteles;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGrafico window = new MenuGrafico();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuGrafico() {
		Fuente fuente= new Fuente();
		this.pixelNum= fuente.generarFuente("Pixel.ttf", 50);
		this.pixelNombreUsuario= fuente.generarFuente("Pixel.ttf", 20);
		this.pixelCarteles= fuente.generarFuente("Pixel.ttf", 16);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setBackground(new Color(169, 169, 169));
		frame.setBounds(new Rectangle(0, 0, 784, 526));
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); //centro la ventana
		JLabel lblNewLabel = new JLabel("2");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(this.pixelNum);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(new Color(218, 165, 32)));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(222, 184, 135));
		lblNewLabel.setBounds(140, 84, 87, 76);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(this.pixelNum);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBorder(new LineBorder(new Color(222, 184, 135)));
		lblNewLabel_1.setBackground(new Color(233, 150, 122));
		
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(260, 84, 87, 76);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("4");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(this.pixelNum);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(new Color(50, 205, 50));
		lblNewLabel_2.setBorder(new LineBorder(new Color(222, 184, 135)));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(380, 84, 87, 76);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("8");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(this.pixelNum);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(0, 191, 255));
		lblNewLabel_3.setBorder(new LineBorder(new Color(222, 184, 135)));
		lblNewLabel_3.setBounds(490, 84, 87, 76);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtFieldNombre = new JTextField();
		txtFieldNombre.setBackground(new Color(255, 140, 0));
		txtFieldNombre.setForeground(new Color(255, 255, 255));
		txtFieldNombre.setFont(this.pixelNombreUsuario);
		txtFieldNombre.setName("");
		txtFieldNombre.setBounds(260, 268, 221, 39);
		frame.getContentPane().add(txtFieldNombre);
		txtFieldNombre.setColumns(10);
		
		JLabel lbl_IngresarNombre = new JLabel("Ingresa tu nombre:");
		lbl_IngresarNombre.setFont(this.pixelCarteles);
		lbl_IngresarNombre.setBorder(new LineBorder(new Color(222, 184, 135)));
		lbl_IngresarNombre.setBounds(260, 239, 221, 26);
		frame.getContentPane().add(lbl_IngresarNombre);
		
		btnJugar = new JButton("Jugar");
			
		btnJugar.setBorderPainted(false);
		btnJugar.setBorder(new LineBorder(new Color(222, 184, 135)));
		btnJugar.setBackground(new Color(255, 140, 0));
		btnJugar.setFont(this.pixelCarteles);
		btnJugar.setBounds(315, 332, 122, 54);
		frame.getContentPane().add(btnJugar);
		
		btnJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(esNombreValido()) {				
					Grafica grafica=new Grafica();
					mostrarVentana(false);		
					grafica.setVisible(true);
				}else {
					System.out.println("El nombre no puede contener numeros o espacios en blanco");
				}
					
			}
		});
	}
	
	private void mostrarVentana(boolean opcion) {
		this.frame.setVisible(opcion);
	}
	
	private boolean esNombreValido() {
		return Menu.validarNombreJugador(this.txtFieldNombre.getText());
	}
		

}

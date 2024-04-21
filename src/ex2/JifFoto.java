package ex2;

import java.awt.EventQueue;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class JifFoto extends JInternalFrame {
	
	private JLabel lblFoto;
	

	public JLabel getLblFoto() {
		return lblFoto;
	}

	public void setLblFoto(JLabel lblFoto) {
		this.lblFoto = lblFoto;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JifFoto frame = new JifFoto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JifFoto() {
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 320, 217);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblFoto = new JLabel("");
		panel.add(lblFoto, BorderLayout.CENTER);
		
	}
	
	public void addImagem(ImageIcon foto)
	{
		lblFoto.setIcon(foto);
	}

}

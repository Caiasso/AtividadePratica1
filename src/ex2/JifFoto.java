package ex2;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
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

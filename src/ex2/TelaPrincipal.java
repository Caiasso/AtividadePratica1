package ex2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TelaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem itemCarregar;
	private JMenuItem itemFechar;
	private JDesktopPane deskTop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuPrincipal = new JMenu("Opções");
		menuBar.add(menuPrincipal);
		
		itemCarregar = new JMenuItem("Carregar Imagem");
		itemCarregar.addActionListener(this);
		menuPrincipal.add(itemCarregar);
		
		itemFechar = new JMenuItem("Fechar Imagens");
		itemFechar.addActionListener(this);
		menuPrincipal.add(itemFechar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		deskTop = new JDesktopPane();
		deskTop.setBounds(0, 0, 714, 539);
		contentPane.add(deskTop);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Carregar Imagem"))
		{
			JFileChooser seletor = new JFileChooser();
			seletor.setDialogTitle("Escolha uma Imagem");
			
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagens (JPG, PNG)", "jpg", "png");
			seletor.setFileFilter(filtro);
			
			int retorno = seletor.showOpenDialog(null);
			
			if(retorno == JFileChooser.APPROVE_OPTION)
			{
				String caminho = seletor.getSelectedFile().getAbsolutePath();
				
				ImageIcon foto = new ImageIcon(caminho);
				
				JifFoto janFoto = new JifFoto();
				janFoto.setVisible(true);
				
				int ultimaBarra = caminho.lastIndexOf('\\');
				String nome = caminho.substring(ultimaBarra + 1);
				janFoto.setTitle(nome);
				
				deskTop.add(janFoto);
				
				janFoto.addImagem(foto);
				
			}
			
			
		}
		
		else
		{
			int resposta = JOptionPane.showConfirmDialog(contentPane, "Deseja fechar todas as imagens?", "Confirmação", JOptionPane.YES_NO_OPTION);
			if(resposta == JOptionPane.YES_OPTION)
			{
				for(JInternalFrame frame : deskTop.getAllFrames())
				{
					frame.dispose();
				}
			}
		}
	}
}

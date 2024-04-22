package ex3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class DialQuest extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JLabel lblPergunta;
	private JRadioButton btnAlt1;
	private JRadioButton btnAlt2;
	private JRadioButton btnAlt3;
	private JRadioButton btnAlt4;
	private JRadioButton btnAlt5;
	private JButton btnAval;
	private JButton btnProx;
	private ButtonGroup grupo;
	private JPanel panel;

	private int numQuest;
	private int numAcertos;

	public int getNumAcertos() {
		return numAcertos;
	}

	public void setNumAcertos(int numAcertos) {
		this.numAcertos = numAcertos;
	}

	public int getNumQuest() {
		return numQuest;
	}

	public void setNumQuest(int numQuest) {
		this.numQuest = numQuest;
	}

	/**
	 * Create the dialog.
	 */
	public DialQuest() {
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(100, 100, 790, 310);
		{
			panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new MigLayout("", "[grow]", "[][10][][5][][5][][5][][5][][10][][20]"));

			lblPergunta = new JLabel("Pergunta Aqui");
			panel.add(lblPergunta, "cell 0 0,alignx left,aligny center");

			btnAlt1 = new JRadioButton("Alt1");
			panel.add(btnAlt1, "cell 0 2,grow");

			btnAlt2 = new JRadioButton("Alt2");
			panel.add(btnAlt2, "cell 0 4,grow");

			btnAlt3 = new JRadioButton("Alt3");
			panel.add(btnAlt3, "cell 0 6,grow");

			btnAlt4 = new JRadioButton("Alt4");
			panel.add(btnAlt4, "cell 0 8,grow");

			btnAlt5 = new JRadioButton("Alt5");
			panel.add(btnAlt5, "cell 0 10,grow");

			btnAval = new JButton("Avaliar Resposta");
			btnAval.addActionListener(this);
			panel.add(btnAval, "flowx,cell 0 12,alignx left,aligny center");

			btnProx = new JButton("Próxima Questão");
			btnProx.addActionListener(this);
			panel.add(btnProx, "cell 0 12,alignx left,aligny center");

			grupo = new ButtonGroup();

			grupo.add(btnAlt1);
			grupo.add(btnAlt2);
			grupo.add(btnAlt3);
			grupo.add(btnAlt4);
			grupo.add(btnAlt4);
			grupo.add(btnAlt5);

			numQuest = 1;
			numAcertos = 0;

			mudaQuestao("1 - O Luciano é firmeza?", "Definitivamente sim", "Não", "Talvez", "Estou indeciso", "Não sei",
					numQuest);

		}

	}

	public int getResposta() {
		int resposta = 0;

		if (btnAlt1.isSelected()) {
			resposta = 1;
		} else if (btnAlt2.isSelected()) {
			resposta = 2;
		} else if (btnAlt3.isSelected()) {
			resposta = 3;
		} else if (btnAlt4.isSelected()) {
			resposta = 4;
		} else if (btnAlt5.isSelected()) {
			resposta = 5;
		}

		return resposta;
	}

	public void mudaBotoes() {
		if (btnAlt1.isEnabled()) {
			btnAlt1.setEnabled(false);
			btnAlt2.setEnabled(false);
			btnAlt3.setEnabled(false);
			btnAlt4.setEnabled(false);
			btnAlt5.setEnabled(false);
			btnAval.setEnabled(false);
		}

		else {
			btnAlt1.setEnabled(true);
			btnAlt2.setEnabled(true);
			btnAlt3.setEnabled(true);
			btnAlt4.setEnabled(true);
			btnAlt5.setEnabled(true);
			btnAval.setEnabled(true);
		}

	}

	public void mudaQuestao(String quest, String alt1, String alt2, String alt3, String alt4, String alt5,
			int numQuest) {
		setTitle("Questão " + Integer.toString(numQuest));

		lblPergunta.setText(quest);
		btnAlt1.setText(alt1);
		btnAlt2.setText(alt2);
		btnAlt3.setText(alt3);
		btnAlt4.setText(alt4);
		btnAlt5.setText(alt5);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Avaliar Resposta") & getResposta() > 0) {
			mudaBotoes();

			switch (numQuest) {
			case 1:
				if (getResposta() == 1) {
					numAcertos++;
					break;
				}
				break;

			case 2:
				if (getResposta() == 3) {
					numAcertos++;
					break;
				}
				break;

			case 3:
				if (getResposta() == 2) {
					numAcertos++;
					break;
				}
				break;

			case 4:
				if (getResposta() == 4) {
					numAcertos++;
					break;
				}
				break;
			}
		}

		else if (e.getActionCommand().equals("Próxima Questão")) {
			if (!btnAlt1.isEnabled()) {
				switch (numQuest) {
				case 1:
					numQuest++;
					mudaBotoes();
					mudaQuestao("2 - Quais os quatro principais conceitos da Programação Orientada a Objetos?",
							"Ordenhar vacas; Andar em corda bamba; Dançar em circos; Pular corda com orangotangos",
							"Escrever lindos poemas; Conversar durante a aula; Ressitar ensinamentos de Mahatma Gandhi; Fazer bolos",
							"Abstração; Encapsulação; Herança; Polimorfismo",
							"Conversar com parentes; Comer bolinho de chuva; Encontrar pessoas queridas; Lembranças da infância",
							"Ir pra cima; Ir pra baixo; Ir pra um lado; Ir pro outro", numQuest);
					break;

				case 2:
					numQuest++;
					mudaBotoes();
					mudaQuestao("3 - Qual dessas é uma linguaquem de programação?", "Ben & Jerry's Cookies n' Cream",
							"Python", "Carlo Bauducco, criador da Bauducco", "Ranking das melhores pantufas da Escócia",
							"Arapaima Gigas - nome ciêntífico do peixe Pirarucu", numQuest);
					break;

				case 3:
					numQuest++;
					mudaBotoes();
					mudaQuestao("4 - Quais são as chances do filme Motoqueiro Fantasma ser real?", "Altas, altíssimas",
							"Altas, mas não são maiores que as chances do Nemo do filme Procurando Nemo ser real",
							"Considerando a estação atual (outono), são altas", "Praticamente impossível",
							"É REAL, EU JÁ VI O MOTOQUEIRO FANTASMA VOANDO POR AÍ PEGANDO FOGO E TUDO!!!!!!", numQuest);
					break;

				case 4:
					int resposta = JOptionPane.showConfirmDialog(panel,
							"Você acertou " + Integer.toString(numAcertos) + " questões", "Seus Resultados",
							JOptionPane.DEFAULT_OPTION, 1);

					if (resposta == JOptionPane.OK_OPTION) {
						dispose();
					}

				}

			}
		}
	}

}

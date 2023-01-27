package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import controleur.Controle;
import modele.Carre;
import modele.Forme;
import modele.Rond;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
public class FrmForme extends JFrame {

	private JPanel contentPane;
	private JLabel lbl2;
	private JLabel lbl1;
	private JTextField txtCote;
	private JTextField txtRayon;
	private Controle controle;
	JLabel perimetreCarre;
	JLabel surfaceCarre;
	JLabel perimetreCercle;
	JLabel surfaceCercle;
	//Important pour créer une liste dans java.
	private DefaultListModel contenuListForme = new DefaultListModel();
	private JList lstForme;
	
	/**
	 * Click sur le bouton calcul carrré
	 */
	public void cmdCalculCarre() {
		controle.demandeFrmFormeValeurs("carre", Float.parseFloat(txtCote.getText()));
	}

	/**
	 * Click sur le bouton calcul rond
	 */
	public void cmdCalculRond() {
		controle.demandeFrmFormeValeurs("rond", Float.parseFloat(txtRayon.getText()));
	}
	
	/**
	 * Click sur le bouton Del
	 */
	public void cmdDel() {
		int[] lesIndices = lstForme.getSelectedIndices();
		for(int k=lesIndices.length-1;k>=0;k--) {
			controle.demandeFrmFormeDel(lesIndices[k]);
		}
	}
	
	/**
	 * mise à jour du contenu de la liste des formes.
	 * @param lesFormes
	 */
	public void majLstFormes(ArrayList<Forme> lesFormes) {
		//vider la liste
		contenuListForme.clear();
		for(Forme uneForme : lesFormes) {
			String ligne;
			//instanceof pour avoir l'instance de l'objet uneForme.
			if(uneForme instanceof Carre) {
				ligne ="Carré : côté = "+ ((Carre)uneForme).getCote();
			}
			else {
				ligne ="Cercle : rayon = "+((Rond)uneForme).getRayon();
			}
			ligne += "  périmètre = "+ uneForme.perimetre()+ "  surface = "+ uneForme.surface();
			//Ajout dans la liste
			contenuListForme.addElement(ligne);
		}
	}
	
	/**
	 * Affichage du périmètre et de la surface du carré.
	 * @param perimetre
	 * @param surface
	 */
	public void affichageResultatCarre(float perimetre, float surface) {
		perimetreCarre.setText(perimetre + " cm" );
		surfaceCarre.setText(surface + " cm2");
	}
	
	/**
	 * Affichage du périmètre et de la surface du cercle.
	 * @param perimetre
	 * @param surface
	 */
	public void affichageResultatCercle(float perimetre, float surface) {
		perimetreCercle.setText(perimetre + " cm" );
		surfaceCercle.setText(surface + " cm2");
	}
	
	/**
	 * Create the frame.
	 */
	public FrmForme(Controle controle) {
		this.controle = controle;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -50, 444, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImgCarr = new JLabel("ImgCarre");
		lblImgCarr.setBounds(15, 37, 99, 99);
		lblImgCarr.setIcon(new ImageIcon(FrmForme.class.getResource("/media/Carre.png")));
		contentPane.add(lblImgCarr);
		
		JLabel lblImgCercle = new JLabel("ImgCercle");
		lblImgCercle.setBounds(15, 151, 99, 99);
		lblImgCercle.setIcon(new ImageIcon(FrmForme.class.getResource("/media/Cercle.png")));
		contentPane.add(lblImgCercle);
		
		JLabel lbl1;
		lbl1 = new JLabel("Côté = ");
		lbl1.setBounds(124, 55, 37, 14);
		contentPane.add(lbl1);
		
		JLabel lbl2;
		lbl2 = new JLabel("Périmètre = ");
		lbl2.setBounds(124, 79, 86, 14);
		contentPane.add(lbl2);
		
		JLabel lbl3;
		lbl3 = new JLabel("Surface = ");
		lbl3.setBounds(124, 104, 71, 14);
		contentPane.add(lbl3);
		
		JLabel lbl1_1 = new JLabel("Rayon = ");
		lbl1_1.setBounds(124, 165, 63, 14);
		contentPane.add(lbl1_1);
		
		JLabel lbl2_1 = new JLabel("Périmètre = ");
		lbl2_1.setBounds(124, 190, 86, 14);
		contentPane.add(lbl2_1);
		
		JLabel lbl3_1 = new JLabel("Surface = ");
		lbl3_1.setBounds(124, 215, 71, 14);
		contentPane.add(lbl3_1);
		
		txtCote = new JTextField("0");
		txtCote.setBounds(208, 51, 86, 20);
		txtCote.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(txtCote);
		txtCote.setColumns(10);
		
		txtRayon = new JTextField("0");
		txtRayon.setBounds(208, 162, 86, 20);
		txtRayon.setHorizontalAlignment(SwingConstants.RIGHT);
		txtRayon.setColumns(10);
		contentPane.add(txtRayon);
		
		perimetreCarre = new JLabel("0 cm");
		perimetreCarre.setBounds(205, 79, 92, 14);
		perimetreCarre.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(perimetreCarre);
		
		surfaceCarre = new JLabel("0 cm 2");
		surfaceCarre.setBounds(205, 104, 92, 14);
		surfaceCarre.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(surfaceCarre);
		
		perimetreCercle = new JLabel("0 cm");
		perimetreCercle.setBounds(205, 190, 92, 14);
		perimetreCercle.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(perimetreCercle);
		
		surfaceCercle = new JLabel("0 cm2");
		surfaceCercle.setBounds(205, 215, 92, 14);
		surfaceCercle.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(surfaceCercle);
		
		JButton btnCalculCarre = new JButton("Calcul");
		btnCalculCarre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdCalculCarre();
			}
		});
		btnCalculCarre.setBounds(327, 51, 89, 23);
		contentPane.add(btnCalculCarre);
		
		JButton btnCalculCercle = new JButton("Calcul");
		btnCalculCercle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdCalculRond();
			}
		});
		btnCalculCercle.setBounds(327, 161, 89, 23);
		contentPane.add(btnCalculCercle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 261, 401, 87);
		contentPane.add(scrollPane);
		
		lstForme = new JList(contenuListForme);
		scrollPane.setViewportView(lstForme);
		
		JButton btnDelete = new JButton("Del");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdDel() ;
			}
		});
		btnDelete.setBounds(327, 354, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblTitre = new JLabel("Calcul du périmètre et de la surface");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitre.setBounds(107, 12, 261, 20);
		contentPane.add(lblTitre);
	}
}

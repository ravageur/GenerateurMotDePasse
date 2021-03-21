package fr.ravageur.generateurmotdepasse;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.NumberFormatter;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class Affichage
{
    private static JFrame fenetre;

    /**
     * Cette méthode permet de créer la page d'application
     */
    public static void creerAffichage()
    {
        fenetre = new JFrame();
        fenetre.setTitle("Générateur de mot de passe aléatoire");
        initialiserContenu();
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.pack();
        fenetre.setVisible(true);
    }

    /**
     * Cette méthode permet d'initialiser le contenu de la page d'application
     */
    private static void initialiserContenu()
    {
        JTextArea motDePasse = new JTextArea(1, 50);
        motDePasse.setEditable(false);
        motDePasse.setLineWrap(true);


        NumberFormat nf = NumberFormat.getIntegerInstance();
        nf.setGroupingUsed(false);
        NumberFormatter numberFormatter = new NumberFormatter(nf);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setMaximum(Integer.MAX_VALUE);
        numberFormatter.setAllowsInvalid(false);

        JFormattedTextField champ1 = new JFormattedTextField(numberFormatter);
        Dimension preference = new Dimension();
        preference.width = 200;
        preference.height = 25;
        champ1.setPreferredSize(preference);

        JButton bouton = new JButton("Générer");
        bouton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String motDePasseGenerer = Generateur.genererMotDePasse(Integer.parseInt(champ1.getText()));
                    motDePasse.setRows(motDePasseGenerer.length() / 50);
                    motDePasse.setText(motDePasseGenerer);
                }
                catch(NumberFormatException exception)
                {
                    //System.out.println("[ERROR]: WHY YOU GIVE ME A LETTER ?! WHY ?! YOU WANT ME TO CRASH ?!");
                }
            }
        });

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(motDePasse);
        panel.add(champ1);
        panel.add(bouton);

        fenetre.add(panel);
    }
}

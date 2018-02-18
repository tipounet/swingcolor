package info.phpjungle.baptiste.swingcolor.panel;

import javax.swing.*;
import java.awt.*;

/**
 * Panneau de droite, affiche la couleur et son code hexa.
 */
public class RightPanel extends JPanel {
    private JLabel colorRGB;

    public RightPanel() {
        // Centrer le label, c'est ce que fait par défaut un GridBagLayout sans contrainte ...
        setLayout(new GridBagLayout());
        colorRGB = new JLabel();
        add(colorRGB);
        setBorder(BorderFactory.createLineBorder(Color.black));

    }

    /**
     * Affichage du code hexa RGB ("web") de la couleur et changement du fond du panneau avec la couleur
     *
     * @param color
     */
    public void setColor(Color color) {
        assert color != null;
        // Les couleurs sont des entiers on met sans en hexa et on "pad" a gauche quand on a pas 2 caractères
        final String red = String.format("%2s", Integer.toHexString(color.getRed())).replace(' ', '0');
        final String green = String.format("%2s", Integer.toHexString(color.getGreen())).replace(' ', '0');
        final String blue = String.format("%2s", Integer.toHexString(color.getBlue())).replace(' ', '0');
        final String s = "#" + red + green + blue;
        colorRGB.setText(s.toUpperCase());
        setBackground(color);
    }
}

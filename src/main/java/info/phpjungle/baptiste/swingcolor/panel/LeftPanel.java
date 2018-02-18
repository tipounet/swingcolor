package info.phpjungle.baptiste.swingcolor.panel;

import info.phpjungle.baptiste.swingcolor.pojo.CallBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Panneau de gauche, affiche la grille de couleurs
 */
public class LeftPanel extends JPanel {

    /**
     * Liste des couleurs à afficher
     */
    private static final Color[] colors = {Color.BLACK,
            Color.BLUE,
            Color.CYAN,
            Color.DARK_GRAY,
            Color.GRAY,
            Color.GREEN,
            Color.LIGHT_GRAY,
            Color.MAGENTA,
            Color.ORANGE,
            Color.PINK,
            Color.RED,
            Color.WHITE
    };
    private final transient CallBack callBack;

    public LeftPanel(CallBack callBack) {
        this.callBack = callBack;

        final GridLayout layoutManager = new GridLayout(4, 3);
        layoutManager.setHgap(4);
        layoutManager.setVgap(4);
        setLayout(layoutManager);

        int with = (this.getWidth() / 3) - 8;
        int height = (this.getHeight() / 4) - 12;

        for (Color color : colors) {
            JPanel p = new JPanel();
            p.setSize(with, height);
            p.setBackground(color);
            p.setBorder(BorderFactory.createLineBorder(Color.black));

            addListener(p);

            add(p);
        }
    }

    private void addListener(final JPanel p) {
        assert p != null;

        p.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent mouseEvent) {
                callBack.perform(p.getBackground());
            }

            public void mousePressed(MouseEvent mouseEvent) {
// pas besoin
            }

            public void mouseReleased(MouseEvent mouseEvent) {
// pas besoin
            }

            public void mouseEntered(MouseEvent mouseEvent) {
// pas besoin
            }

            public void mouseExited(MouseEvent mouseEvent) {
// pas besoin
            }
        });
    }
}

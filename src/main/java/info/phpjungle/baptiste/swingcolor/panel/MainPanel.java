package info.phpjungle.baptiste.swingcolor.panel;

import info.phpjungle.baptiste.swingcolor.pojo.CallBack;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Le panneau central qui contient tout
 */
public class MainPanel extends JFrame {
    private static final int GUTTER_WIDTH = 10;
    private static final int HEIGHT = 200;
    private static final int WIDTH = 300;
    private JPanel content;

    public MainPanel() {
        this.setTitle("Palette de couleur");
        this.setSize(WIDTH + GUTTER_WIDTH, HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // centrer la fenêtre ...
        this.setLocationRelativeTo(null);

        initContent();
        this.setContentPane(content);
    }

    private void initContent() {
        content = new JPanel();
        final GridLayout layout = new GridLayout();
        layout.setHgap(GUTTER_WIDTH);
        content.setLayout(layout);

        // Composition de bordure pour créer un padding
        final EmptyBorder emptyBorder = new EmptyBorder(5, 5, 5, 5);
        content.setBorder(BorderFactory.createCompoundBorder(content.getBorder(), emptyBorder));

        final RightPanel right = new RightPanel();
        right.setSize(WIDTH / 2, HEIGHT);
        CallBack c = new CallBack() {
            public void perform(Color color) {
                right.setColor(color);
            }
        };
        final LeftPanel left = new LeftPanel(c);
        left.setSize(WIDTH / 2, HEIGHT);
        content.add("West", left);
        content.add("East", right);

        right.setColor(Color.WHITE);

    }
}

package program;

import program.core.GamePanel;
import program.core.GameWindow;

import java.awt.*;

public class Program {
    public static void main(String[] args ) {
        GameWindow window = new GameWindow();
        GamePanel panel = new GamePanel();

        panel.setPreferredSize(new Dimension(Settings.GAME_WIDTH, Settings.GAME_HEIGHT));
        window.add(panel);
        window.pack();
        window.setVisible(true);

        panel.gameLoop();
    }
}

package program.menu;

import program.Settings;
import program.core.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackgroundMenu extends GameObject {

    public BackgroundMenu() {
        GameObject.playerLayers.add(this);
        this.position.set(Settings.BACKGROUND_WIDTH, 0);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int) this.position.x, (int) this.position.y,
                Settings.GAME_WIDTH - Settings.BACKGROUND_WIDTH, Settings.GAME_HEIGHT);
        g.setColor(Color.GREEN);
        g.setFont(Settings.BIG_SIZE);
        g.drawString(GameObject.score + "", 750, 150);
    }
}

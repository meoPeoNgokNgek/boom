package program.menu;

import program.Settings;
import program.core.GameObject;
import program.player.Player;
import program.renderer.SingleImageRenderer;
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
        g.drawImage(SpriteUtils.loadImage("assests/image/map/backgound/background_Info.png"),
                (int) this.position.x,
                (int) this.position.y,
                null);
        g.setColor(Color.white);
        g.setFont(Settings.BIG_SIZE);
        g.drawString("Score : "+GameObject.score + "", 730, 150);

        if (Player.hp == 3) {
            g.drawImage(SpriteUtils.loadImage("assests/image/map/backgound/heart_1.png"),
                    730,
                    300,
                    null);
            g.drawImage(SpriteUtils.loadImage("assests/image/map/backgound/heart_1.png"),
                    770,
                    300,
                    null);
            g.drawImage(SpriteUtils.loadImage("assests/image/map/backgound/heart_1.png"),
                    810,
                    300,
                    null);
        }

        if (Player.hp == 2) {
            g.drawImage(SpriteUtils.loadImage("assests/image/map/backgound/heart_1.png"),
                    730,
                    300,
                    null);
            g.drawImage(SpriteUtils.loadImage("assests/image/map/backgound/heart_1.png"),
                    770,
                    300,
                    null);
        }

        if (Player.hp == 1) {
            g.drawImage(SpriteUtils.loadImage("assests/image/map/backgound/heart_1.png"),
                    730,
                    300,
                    null);
        }
    }
}

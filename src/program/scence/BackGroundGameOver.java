package program.scence;

import program.Settings;
import program.core.GameObject;
import program.core.GameWindow;
import program.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackGroundGameOver extends GameObject {
    public BackGroundGameOver() {
        GameObject.playerLayers.add(this);
        BufferedImage image = SpriteUtils.loadImage("assests/image/background/background_Menu.png");
        this.renderer = new SingleImageRenderer(image);
        this.anchor.set(0, 0);
        this.position.set(0, 0);
    }

    @Override
    public void run() {
        if(GameWindow.isFirePress) {
            SceneManager.signNewScene(new SceneWelcome());
        }
    }
}

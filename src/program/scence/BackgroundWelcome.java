package program.scence;

import program.core.GameObject;
import program.core.GameWindow;
import program.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BackgroundWelcome extends GameObject {
    public BackgroundWelcome() {
        GameObject.backgroundLayers.add(this);
        BufferedImage image = SpriteUtils.loadImage("assests/image/background/background_Menu.png");
        this.renderer = new SingleImageRenderer(image);
        this.anchor.set(0, 0);
        this.position.set(0, 0);
    }

    @Override
    public void run() {
        if(GameWindow.isAnyKeyPress) {
            SceneManager.signNewScene(new SceneStage());
        }
    }
}

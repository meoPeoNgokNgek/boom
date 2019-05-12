package program.renderer;

import program.core.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SingleImageRenderer extends Renderer {
    BufferedImage image;

    public SingleImageRenderer(BufferedImage image) {
        this.image = image;
    }

    public SingleImageRenderer(String filePath) {
        this.image = SpriteUtils.loadImage(filePath);
    }

    @Override
    public void render(Graphics g, GameObject master) {
        g.drawImage(
                image,
                (int) (master.position.x - master.anchor.x * image.getWidth()),
                (int) (master.position.y - master.anchor.y * image.getHeight()),
                null
        );
        if(master.hitBox != null) {
            this.drawHitBox(g, master);
        }
    }

    private void drawHitBox(Graphics g, GameObject master) {
        g.setColor(Color.CYAN);
        g.drawRect(
                (int) master.hitBox.left(),
                (int) master.hitBox.top(),
                master.hitBox.width,
                master.hitBox.height
        );
    }
}

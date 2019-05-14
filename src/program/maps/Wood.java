package program.maps;

import program.core.GameObject;
import program.physics.BoxCollider;
import program.renderer.SingleImageRenderer;

import java.awt.*;

public class Wood extends GameObject {
    public Wood() {
        GameObject.mapLayers.add(this);
        hp = 1;
        anchor.set(0, 0);
        hitBox = new BoxCollider(this, 43, 43);
        renderer = new SingleImageRenderer("assests/image/map/box/wood.png");
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
//        SingleImageRenderer.drawHitBox(g, this);
    }
}

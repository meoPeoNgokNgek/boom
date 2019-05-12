package program.maps;

import program.core.GameObject;
import program.physics.BoxCollider;
import program.renderer.SingleImageRenderer;

public class Shadow extends GameObject {
    public Shadow() {
        GameObject.shadowLayers.add(this);
        hp = 1;
        anchor.set(0, 0);
        hitBox = new BoxCollider(this, 0, 0);
        renderer = new SingleImageRenderer("assests/image/map/box/shawdow1.png");
    }

}

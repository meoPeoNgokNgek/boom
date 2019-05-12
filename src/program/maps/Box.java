package program.maps;

import program.core.GameObject;
import program.physics.BoxCollider;
import program.renderer.SingleImageRenderer;

public class Box extends GameObject {

    public Box() {
        hp = 1;
        anchor.set(0, 0);
        hitBox = new BoxCollider(this, 45, 45);
        renderer = new SingleImageRenderer("assests/image/map/box/box1.png");
    }
}

package program.maps;

import program.core.GameObject;
import program.physics.BoxCollider;
import program.renderer.SingleImageRenderer;

public class ItemShoes extends GameObject {
    public ItemShoes() {
        renderer = new SingleImageRenderer("assests/image/map/item/item_shoe.png");
        hitBox = new BoxCollider(this, 45,45);
        anchor.set(0,0);
    }
}

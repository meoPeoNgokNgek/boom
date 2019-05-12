package program;

import program.core.GameObject;
import program.renderer.SingleImageRenderer;

public class Background extends GameObject {
    public Background() {
        GameObject.backgroundLayers.add(this);
        anchor.set(0, 0);
        position.set(0, 0);
        renderer = new SingleImageRenderer("assests/image/background/0.png");
    }
}

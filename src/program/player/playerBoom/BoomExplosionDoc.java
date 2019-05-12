package program.player.playerBoom;

import program.Settings;
import program.physics.BoxCollider;
import program.renderer.SingleImageRenderer;

import java.awt.*;

public class BoomExplosionDoc extends BoomExplosion {
    public BoomExplosionDoc() {
        if(Settings.BOOM_SIZE_MODE == 1) {
            r3 = new SingleImageRenderer("assests/image/playerBoom/bombbang_up_1.png");
            r4 = new SingleImageRenderer("assests/image/playerBoom/bombbang_down_1.png");
            hitBox = new BoxCollider(this, 45, 90);

        }

        if(Settings.BOOM_SIZE_MODE == 2) {
            r3 = new SingleImageRenderer("assests/image/playerBoom/bombbang_up_2.png");
            r4 = new SingleImageRenderer("assests/image/playerBoom/bombbang_down_2.png");
            hitBox = new BoxCollider(this, 45, 135);
        }
    }


    //TODO: render r1, r2 .... ra null

    @Override
    public void render(Graphics g) {
        if(r3 != null && r4 != null) {
            if(MODE == 1) {
                this.anchor.set(0, 0.5);//up right down left
                r3.render(g, this);
                this.anchor.set(0, 0);
                r4.render(g, this);
            }

            if(MODE == 2) {
                this.anchor.set(0.5, 1);//up right down left
                r3.render(g, this);
                this.anchor.set(0.5, 0);
                r4.render(g, this);
            }
        }
        this.anchor.set(0.5, 0.5);
    }
}

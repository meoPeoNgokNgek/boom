package program.player.playerBoom;

import program.Settings;
import program.physics.BoxCollider;
import program.renderer.Renderer;
import program.renderer.SingleImageRenderer;

import java.awt.*;

public class BoomExplosionDoc extends BoomExplosion {
    public BoomExplosionDoc() {
        if(Settings.BOOM_SIZE_MODE == 1) {
            r3 = new SingleImageRenderer("assests/image/playerBoom/bombbang_up_1.png");
            r4 = new SingleImageRenderer("assests/image/playerBoom/bombbang_down_1.png");
            hitBox = new BoxCollider(this, 43, 90 - 4);

        }

        if(Settings.BOOM_SIZE_MODE == 2) {
            r3 = new SingleImageRenderer("assests/image/playerBoom/bombbang_up_2.png");
            r4 = new SingleImageRenderer("assests/image/playerBoom/bombbang_down_2.png");
            hitBox = new BoxCollider(this, 45 - 2, 135 - 4);
        }
    }

    public void setMode(int mode) {
        if(mode == 1) {
            r3 = r3Mode1;
            r4 = r4Mode1;
            hitBox = new BoxCollider(this, 22, 135 - 24);
        } else {
            r3 = r3Mode2;
            r4 = r4Mode2;
            hitBox = new BoxCollider(this, 22, 225 - 24);
        }
    }

    //TODO: render r1, r2 .... ra null

    @Override
    public void render(Graphics g) {
        if(r3 != null && r4 != null) {
            this.anchor.set(0, 0.5);//up right down left
            r3.render(g, this);
            this.anchor.set(0, 0);
            r4.render(g, this);
        }
        this.anchor.set(-0.5, 0.4);
//        SingleImageRenderer.drawHitBox(g, this);
    }
}

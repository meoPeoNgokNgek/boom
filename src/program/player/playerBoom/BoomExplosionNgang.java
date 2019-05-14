package program.player.playerBoom;

import program.Settings;
import program.core.GameObject;
import program.enemy.Enemy;
import program.maps.Box;
import program.physics.BoxCollider;
import program.renderer.Renderer;
import program.renderer.SingleImageRenderer;

import java.awt.*;

public class BoomExplosionNgang extends BoomExplosion {

    public BoomExplosionNgang() {
        if(Settings.BOOM_SIZE_MODE == 1) {
            r1 = new SingleImageRenderer("assests/image/playerBoom/bombbang_right_1.png");
            r2 = new SingleImageRenderer("assests/image/playerBoom/bombbang_left_1.png");
            hitBox = new BoxCollider(this, 90, 45);

        }

        if(Settings.BOOM_SIZE_MODE == 2) {
            r1 = new SingleImageRenderer("assests/image/playerBoom/bombbang_right_2.png");
            r2 = new SingleImageRenderer("assests/image/playerBoom/bombbang_left_2.png");
            hitBox = new BoxCollider(this, 135, 45);
        }
    }

    public void setMode(int mode) {

        if(mode == 1) {
            r1 = r1Mode1;
            r2 = r2Mode1;
            hitBox = new BoxCollider(this, 135 - 36, 35);
        } else {
            r1 = r1Mode2;
            r2 = r2Mode2;
            hitBox = new BoxCollider(this, 225 - 36, 35);
        }
    }

    //TODO: render r1, r2 .... ra null

    @Override
    public void render(Graphics g) {
        if(r1 != null && r2 != null) {
            this.anchor.set(Settings.BOOM_SIZE_MODE == 1 ? 0.5 : 0.75, 0);//up right down left
            r1.render(g, this);
            this.anchor.set(0, 0);
            r2.render(g, this);

//            if(MODE == 2) {
//                this.anchor.set(0, 0.5);//up right down left
//                r1.render(g, this);
//                this.anchor.set(1, 0.5);
//                r2.render(g, this);
//            }
        }
        this.anchor.set(Settings.BOOM_SIZE_MODE == 1 ? 0.2 : 0.4, 0);
//        SingleImageRenderer.drawHitBox(g, this);
    }
}

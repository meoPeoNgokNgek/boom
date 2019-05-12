package program.player.playerBoom;

import program.Settings;
import program.core.GameObject;
import program.physics.BoxCollider;
import program.renderer.SingleImageRenderer;


public class PlayerBoom extends GameObject {

    public PlayerBoom() {
        GameObject.playerLayers.add(this);
        hitBox = new BoxCollider(this, 45,45);
        timer = 0;
        renderer = new SingleImageRenderer("assests/image/playerBoom/0.png");
    }

    @Override
    public void run() {
        timer();
    }

    public void timer() {
        this.timer++;
        if(this.timer > 100) {
            if(Settings.BOOM_SIZE_MODE == 2) {
                BoomExplosionNgang boomNgang = GameObject.recycle(BoomExplosionNgang.class);
                BoomExplosionDoc boomDoc = GameObject.recycle(BoomExplosionDoc.class);
                boomNgang.position.set(this.position);
                boomDoc.position.set(this.position);
            }

            if(Settings.BOOM_SIZE_MODE == 1) {
                BoomExplosionNgang boomNgang = new BoomExplosionNgang();
                BoomExplosionDoc boomDoc =  new BoomExplosionDoc();
                boomNgang.position.set(this.position);
                boomDoc.position.set(this.position);
            }
            this.deactive();
            this.timer = 0;
        }
    }

}

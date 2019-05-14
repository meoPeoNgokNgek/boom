package program.player.playerBoom;

import program.Settings;
import program.core.GameObject;
import program.physics.BoxCollider;
import program.physics.Vector2D;
import program.renderer.SingleImageRenderer;


public class PlayerBoom extends GameObject {

    public PlayerBoom() {
        GameObject.playerLayers.add(this);
        hitBox = new BoxCollider(this, 45,45);
        timer = 0;
        renderer = new SingleImageRenderer("assests/image/playerBoom/0.png");
        anchor.set(0.5,0.2);
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
                Vector2D boomExplosionPosition = this.position.clone();
                boomExplosionPosition.substract(22, 5);
                boomDoc.setMode(2);
                boomNgang.setMode(2);
                boomNgang.position.set(boomExplosionPosition);
                boomDoc.position.set(boomExplosionPosition);
            }

            if(Settings.BOOM_SIZE_MODE == 1) {
                BoomExplosionNgang boomNgang = new BoomExplosionNgang();
                BoomExplosionDoc boomDoc =  new BoomExplosionDoc();
                Vector2D boomExplosionPosition = this.position.clone();
                boomExplosionPosition.substract(22, 5);
                boomDoc.setMode(1);
                boomNgang.setMode(1);
                boomNgang.position.set(boomExplosionPosition);
                boomDoc.position.set(boomExplosionPosition);
            }
            this.deactive();
            this.timer = 0;
        }
    }

}

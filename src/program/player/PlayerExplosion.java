package program.player;

import program.Settings;
import program.core.GameObject;
import program.renderer.Renderer;
import program.renderer.SingleImageRenderer;

import java.awt.*;

public class PlayerExplosion extends GameObject {
    Renderer r;
    public static int MODE = Settings.PLAYER_MODE;

    /** mode == 1 sac nuoc
     * mode == 2 death
     */
    public PlayerExplosion() {
        GameObject.playerLayers.add(this);
        if(MODE == 1) {
            r = new SingleImageRenderer("assests/image/player/ghost.png");
        }

        if(MODE == 2) {
            r = new SingleImageRenderer("assests/image/player/bomber_dead.png");
        }
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void render(Graphics g) {
        r.render(g, this);
    }
}

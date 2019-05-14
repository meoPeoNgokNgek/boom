package program.enemy;

import program.Settings;
import program.core.GameObject;
import program.physics.BoxCollider;
import program.physics.Vector2D;
import program.player.Player;
import program.player.playerBoom.PlayerBoom;
import program.renderer.SingleImageRenderer;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public class Enemy extends GameObject {
    public int hp;
    Clip explosionSound;

    public Enemy() {
        GameObject.enemyLayers.add(this);
        renderer = new SingleImageRenderer("assests/image/enemy/monster_left.png");
        hitBox = new BoxCollider(this, 30,30);
        hp = 1;
        anchor.set(0.5, 0.34);
        velocity.set(Settings.ENEMY_SPEED, 0);
        this.explosionSound = AudioUtils.loadSound("assests/music/sfx/enemy-explosion.wav");

    }

    @Override
    public void run() {
        super.run();
        this.killPlayer();
        this.intelligent();
        this.renderDirection();
    }

    public void killPlayer() {
        Player player = GameObject.findIntersects(Player.class, this.hitBox);
        if(player != null) {
            player.takeDamage(1);
        }
    }

    @Override
    public void deactive() {
        super.deactive();
        GameObject.score++;
        AudioUtils.replay(this.explosionSound);
    }

    public void intelligent() {
        if(this.outBoundRight() && this.onGoingRight()) {
            this.reverseVelocityX();
        }
        if(this.outBoundLeft() && this.onGoingLeft()) {
            this.reverseVelocityX();
        }

        PlayerBoom playerBoom = GameObject.findIntersects(PlayerBoom.class, this.hitBox);
        if (playerBoom != null) {
            this.reverseVelocityX();
        }
    }

    public void renderDirection() {
        if(onGoingRight()) {
            renderer = new SingleImageRenderer("assests/image/enemy/monster_right.png");
        }

        if(onGoingLeft()) {
            renderer = new SingleImageRenderer("assests/image/enemy/monster_left.png");
        }

        if(onGoingDown()) {
            renderer = new SingleImageRenderer("assests/image/enemy/monster_down.png");
        }

        if(onGoingUp()) {
            renderer = new SingleImageRenderer("assests/image/enemy/monster_up.png");
        }
    }

    private boolean outBoundRight() {
        return this.position.x >= Settings.BACKGROUND_WIDTH
                - this.anchor.x * Settings.PLAYER_WIDTH;
    }

    private boolean outBoundLeft() {
        return this.position.x <= this.anchor.x * Settings.PLAYER_WIDTH;
    }

    private boolean onGoingRight() {
        return this.velocity.x > 0;
    }

    private boolean onGoingLeft() {
        return this.velocity.x < 0;
    }

    private boolean onGoingUp() {
        return this.velocity.y < 0;
    }

    private boolean onGoingDown() {
        return this.velocity.y > 0;
    }

    private void reverseVelocityX() {
        this.velocity.setX(-this.velocity.x);
    }

}

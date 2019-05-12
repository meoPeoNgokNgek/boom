package program.player.playerBoom;

import program.Settings;
import program.core.GameObject;
import program.enemy.Enemy;
import program.maps.Box;
import program.maps.Wood;
import program.physics.BoxCollider;
import program.player.Player;
import program.player.PlayerExplosion;
import program.renderer.Renderer;
import program.renderer.SingleImageRenderer;

import java.awt.*;

public class BoomExplosion extends GameObject {
    public int damage;
    Renderer r1;
    Renderer r2;
    Renderer r3;
    Renderer r4;
    public static int MODE = Settings.BOOM_SIZE_MODE;

    public BoomExplosion() {
        GameObject.playerLayers.add(this);
        damage = 1;
    }


    //TODO: render r1, r2 .... ra null

    @Override
    public void run() {
        this.killThis();
        this.killSomeThing();
    }

    int count = 0;
    public void killThis() {
        count++;
        if(count > 20) {
            this.deactive();
            count = 0;
        }
    }

    public void killSomeThing() {
        this.killWood();
        this.killEnemy();
//        this.killPlayer();
    }

    public void killEnemy() {
        Enemy enemy = GameObject.findIntersects(Enemy.class, this.hitBox);
        if(enemy != null) {
            enemy.takeDamage(this.damage);
        }
    }

    public void killWood() {
        Wood wood = GameObject.findIntersects(Wood.class, this.hitBox);
        if(wood != null) {
            wood.takeDamage(this.damage);
        }
    }

    public void killPlayer() {
        Player player = GameObject.findIntersects(Player.class, this.hitBox);
        if(player != null) {
            PlayerExplosion playerExplosion = GameObject.recycle(PlayerExplosion.class);
            PlayerExplosion.MODE = 2;
            playerExplosion.position.set(player.position);
            frameCount();
            if(true) {
                playerExplosion.deactive();
            }
        }
    }

    public int frameCount() {
        int count = 0;
        count++;

        return count;
    }
}
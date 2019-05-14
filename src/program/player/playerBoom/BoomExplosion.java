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
    static Renderer r1Mode1 =new SingleImageRenderer("assests/image/playerBoom/bombbang_left_1.png");
    static Renderer r2Mode1 =new SingleImageRenderer("assests/image/playerBoom/bombbang_right_1.png");
    static Renderer r3Mode1 =new SingleImageRenderer("assests/image/playerBoom/bombbang_up_1.png");
    static Renderer r4Mode1 =new SingleImageRenderer("assests/image/playerBoom/bombbang_down_1.png");
    static Renderer r1Mode2 =new SingleImageRenderer("assests/image/playerBoom/bombbang_left_2.png");
    static Renderer r2Mode2 =new SingleImageRenderer("assests/image/playerBoom/bombbang_right_2.png");
    static Renderer r3Mode2 =new SingleImageRenderer("assests/image/playerBoom/bombbang_up_2.png");
    static Renderer r4Mode2 =new SingleImageRenderer("assests/image/playerBoom/bombbang_down_2.png");

    public int damage;
    Renderer r1;
    Renderer r2;
    Renderer r3;
    Renderer r4;

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
        this.killPlayer();
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

    int count1 = 0;
    public void killPlayer() {
        Player player = GameObject.findIntersects(Player.class, this.hitBox);
        if(player != null) {
            player.takeDamage(1);
        }
    }

//    public int frameCount() {
//        int count = 0;
//        count++;
//
//        return count;
//    }
}
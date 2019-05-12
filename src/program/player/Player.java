package program.player;

import program.Settings;
import program.core.GameObject;
import program.core.GameWindow;
import program.maps.Box;
import program.maps.ItemBoomSize;
import program.maps.ItemShoes;
import program.maps.Wood;
import program.physics.BoxCollider;
import program.player.playerBoom.BoomExplosion;
import program.player.playerBoom.PlayerBoom;
import program.renderer.SingleImageRenderer;
import program.scence.SceneGameOver;
import program.scence.SceneManager;
import tklibs.Mathx;

public class Player extends GameObject {

    public Player() {
        hp = 10;
        GameObject.playerLayers.add(this);
        hitBox = new BoxCollider(this, 20, 20);
        renderer = new SingleImageRenderer("assests/image/player/0.png");
        position.set(Settings.PLAYER_START_X, Settings.PLAYER_START_Y+10);
    }

    public void run() {
        super.run();
        this.move();
        this.fire();
        this.limitPosition();
        this.eatItem();
        System.out.println(hp);
    }

    int count = 0;
    public void fire() {
        count++;

        if(GameWindow.isFirePress && count > Settings.PLAYER_FIRE_DELAY) {
            PlayerBoom boom = new PlayerBoom();
            boom.position.set(this.position);
            count = 0;
        }
    }

    public void move() {
        double playerSpeed = Settings.PLAYER_SPEED;
        double vx = 0;
        double vy = 0;

        if(GameWindow.isUpPress) {
            renderer = new SingleImageRenderer("assests/image/player/3.png");
            vy -= playerSpeed;
        }
        if(GameWindow.isRightPress) {
            renderer = new SingleImageRenderer("assests/image/player/2.png");
            vx += playerSpeed;
        }
        if(GameWindow.isDownPress) {
            renderer = new SingleImageRenderer("assests/image/player/0.png");
            vy += playerSpeed;
        }
        if(GameWindow.isLeftPress) {
            renderer = new SingleImageRenderer("assests/image/player/1.png");
            vx -= playerSpeed;
        }

        if(vx != 0 && vy != 0) {
            double v = playerSpeed / Math.sqrt(2);
            vx = Math.signum(vx) * v;
            vy = Math.signum(vy) * v;
        }

        Box box = GameObject.findIntersects(Box.class, this.hitBox.shift(vx,vy));
        if (box != null) {
            vx = 0;
            vy = 0;
        }

        Wood wood = GameObject.findIntersects(Wood.class, this.hitBox.shift(vx,vy));
        if (wood != null) {
            vx = 0;
            vy = 0;
        }

//        PlayerBoom boom = GameObject.findIntersects(PlayerBoom.class, this.hitBox.shift(vx, vy));
//        if(boom != null) {
//            vx = 0;
//            vy = 0;
//        }
        velocity.set(vx, vy);
    }

    public void limitPosition() {
        position.setX(Mathx.clamp(position.x, 0.5 * Settings.PLAYER_WIDTH, Settings.BACKGROUND_WIDTH - 0.5 * Settings.PLAYER_WIDTH));
        position.setY(Mathx.clamp(position.y, 0.5 * Settings.PLAYER_HEIGHT, Settings.GAME_HEIGHT - 0.5 * Settings.PLAYER_HEIGHT));
    }

    @Override
    public void deactive() {
        super.deactive();
//        PlayerExplosion playerExplosion = new PlayerExplosion();
//        playerExplosion.position.set(this.position);

        SceneManager.signNewScene(new SceneGameOver());
    }


    public void eatItem() {
        this.getShoes();
        this.getBoomSize();
        System.out.println(Settings.BOOM_SIZE_MODE);
    }

    private void getShoes() {
        ItemShoes itemShoes = GameObject.findIntersects(ItemShoes.class, this.hitBox);

        if (itemShoes != null) {
            itemShoes.deactive();
            Settings.PLAYER_SPEED += 1;
        }
    }

    private void getBoomSize() {
        ItemBoomSize itemBoomSize = GameObject.findIntersects(ItemBoomSize.class, this.hitBox);

        if(itemBoomSize != null) {
            itemBoomSize.deactive();
            Settings.BOOM_SIZE_MODE = 2;
        }
    }
}

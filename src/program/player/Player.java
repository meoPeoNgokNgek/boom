package program.player;

import program.Settings;
import program.core.GameObject;
import program.core.GameWindow;
import program.enemy.Enemy;
import program.maps.Box;
import program.maps.ItemBoomSize;
import program.maps.ItemShoes;
import program.maps.Wood;
import program.physics.BoxCollider;
import program.physics.Vector2D;
import program.player.playerBoom.BoomExplosion;
import program.player.playerBoom.BoomExplosionDoc;
import program.player.playerBoom.BoomExplosionNgang;
import program.player.playerBoom.PlayerBoom;
import program.renderer.SingleImageRenderer;
import program.scence.SceneGameOver;
import program.scence.SceneManager;
import tklibs.Mathx;

public class Player extends GameObject {
    public static int hp;


    public Player() {
        GameObject.playerLayers.add(this);
        hitBox = new BoxCollider(this.position, 40, 40, new Vector2D(0.5,0.1));
        renderer = new SingleImageRenderer("assests/image/player/0.png");
        position.set(Settings.PLAYER_START_X, Settings.PLAYER_START_Y+5);
        hp = 3;
    }

    public void run() {
        super.run();
        this.move();
        this.fire();
        this.limitPosition();
        this.eatItem();
//        this.dead();
//        System.out.println(hp);
    }



    int count = 0;
    public void fire() {
        count++;

        if(GameWindow.isFirePress && count > Settings.PLAYER_FIRE_DELAY) {
            PlayerBoom boom = new PlayerBoom();
            System.out.println(this.position.x / 45 + " " + this.position.y / 45);
            boom.position.set((int)(this.position.x / 45) * 45 + 22
                    ,(int)(this.position.y / 45) * 45 + 8);
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

        if (hp > 0) {
            this.reset();
//            playerExplosion.deactive();
        }
        if (hp == 0) SceneManager.signNewScene(new SceneGameOver());
    }

    @Override
    public void reset() {
        super.reset();
        this.position.set(Settings.PLAYER_START_X, Settings.PLAYER_START_Y+5);
        hp -= 1;
    }

    public void eatItem() {
        this.getShoes();
        this.getBoomSize();
//        System.out.println(Settings.BOOM_SIZE_MODE);
    }

    private void getShoes() {
        ItemShoes itemShoes = GameObject.findIntersects(ItemShoes.class, this.hitBox);

        if (itemShoes != null) {
            itemShoes.deactive();
            Settings.PLAYER_SPEED += 2;
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

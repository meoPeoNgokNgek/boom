package program.core;

import program.physics.BoxCollider;
import program.physics.Vector2D;
import program.renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;


public class GameObject {
    public Vector2D position;
    public Vector2D velocity;
    public Renderer renderer;
    public boolean active;
    public Vector2D anchor;
    public static int hp;
    public BoxCollider hitBox;
    public int timer;

    public static ArrayList<GameObject> objects = new ArrayList<>();
    public static ArrayList<GameObject> playerLayers = new ArrayList<>();
    public static ArrayList<GameObject> mapLayers = new ArrayList<>();
    public static ArrayList<GameObject> enemyLayers = new ArrayList<>();
    public static ArrayList<GameObject> backgroundLayers = new ArrayList<>();
    public static ArrayList<GameObject> shadowLayers = new ArrayList<>();
    public static int score = 0;

    public GameObject() {
        objects.add(this);
        position = new Vector2D();
        velocity = new Vector2D();
        active = true;
        anchor = new Vector2D(0.5, 0.5);
    }

    public static <E extends GameObject> E recycle(Class<E> cls) {
        E object = findDeactive(cls);
        if(object != null) {
            object.reset();
            return object;
        }
        try {
            object = cls.getConstructor().newInstance();
            return object;
        } catch(Exception ex) {
            return null;
        }
    }

    public static <E extends GameObject> E findDeactive(Class<E> cls) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(!object.active
                    && object.getClass().isAssignableFrom(cls)) {
                return (E)object;
            }
        }
        return null;
    }

    public static <E extends GameObject> E findIntersects(Class<E> cls, BoxCollider hitBox) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(object.active
                    && object.getClass().isAssignableFrom(cls)
                    && object.hitBox != null
                    && object.hitBox.intersects(hitBox)) {
                return (E) object;
            }
        }
        return null;
    }

    public void render(Graphics g) {
        if(renderer != null) {
            renderer.render(g, this);
        }
    }

    public void run() {
        position.add(velocity);
        System.out.println(objects.size());
    }

    public void deactive() {
        active = false;
    }

    public void reset() {
        active = true;
    }

    ////////////////////////////////////
    public void takeDamage(int damage) {
        hp -= damage;
        if(hp <= 0) {
            hp = 0;
            this.deactive();
        }
    }

    public static void clearAll() {
        objects.clear();
        mapLayers.clear();
        playerLayers.clear();
        enemyLayers.clear();
        backgroundLayers.clear();
        shadowLayers.clear();
        score = 0;
    }
}

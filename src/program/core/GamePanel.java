package program.core;

import program.Background;
import program.enemy.Enemy;
import program.enemy.EnemySummoner;
import program.maps.Map;
import program.menu.BackgroundMenu;
import program.player.Player;
import program.scence.SceneManager;
import program.scence.SceneWelcome;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Background background;
    Player player;
    Enemy enemy;
    EnemySummoner summoner;
    BackgroundMenu backgroundMenu;

    public GamePanel() {
//        GameObject.recycle(Background.class);
//        GameObject.recycle(Player.class);
//        GameObject.recycle(Enemy.class);
//        GameObject.recycle(EnemySummoner.class);
//        addMap();
        SceneManager.signNewScene((new SceneWelcome()));
    }

        private void addMap () {
            Map map = Map.load("assests/map/map.json");
            map.generate();
        }


        @Override
        public void paint (Graphics g){
            try{
                for (int i = 0; i < GameObject.backgroundLayers.size(); i++) {
                    GameObject object = GameObject.backgroundLayers.get(i);
                    if (object != null && object.active) {
                        object.render(g);
                    }
                }

                for (int i = 0; i < GameObject.mapLayers.size(); i++) {
                    GameObject object = GameObject.mapLayers.get(i);
                    if (object != null && object.active) {
                        object.render(g);
                    }
                }

                for (int i = 0; i < GameObject.enemyLayers.size(); i++) {
                    GameObject object = GameObject.enemyLayers.get(i);
                    if (object != null && object.active) {
                        object.render(g);
                    }
                }

                for (int i = 0; i < GameObject.playerLayers.size(); i++) {
                    GameObject object = GameObject.playerLayers.get(i);
                    if (object.active) {
                        object.render(g);
                    }
                }

                for (int i = 0; i < GameObject.shadowLayers.size(); i++) {
                    GameObject object = GameObject.shadowLayers.get(i);
                    if (object != null && object.active) {
                        object.render(g);
                    }
                }
            } catch(Exception ex) {

            }
        }

        public void runAll () {
            for (int i = 0; i < GameObject.objects.size(); i++) {
                GameObject object = GameObject.objects.get(i);
                if (object.active) {
                    object.run();
                }
            }
        }

        public void gameLoop () {
            long lastTime = 0;
            while (true) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastTime >= 1000 / 60) {
                    this.repaint();
                    this.runAll();
                    lastTime = currentTime;
                }
            }
        }


}

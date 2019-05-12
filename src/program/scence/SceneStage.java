package program.scence;

import program.Background;
import program.core.GameObject;
import program.enemy.Enemy;
import program.enemy.EnemySummoner;
import program.maps.Map;
import program.menu.BackgroundMenu;
import program.player.Player;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public class SceneStage extends Scene {
    Clip music;
    @Override
    public void init() {
        GameObject.recycle(Background.class);
        GameObject.recycle(Player.class);
        GameObject.recycle(Enemy.class);
        GameObject.recycle(EnemySummoner.class);
        GameObject.recycle(BackgroundMenu.class);
        addMap();
        this.music = AudioUtils.loadSound("assests/music/sfx/ok.wav");
        AudioUtils.replay(this.music);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
    private void addMap() {
        Map map = Map.load("assests/map/map.json");
        map.generate();
    }
}


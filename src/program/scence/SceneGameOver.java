package program.scence;

import program.core.GameObject;

public class SceneGameOver extends Scene {
    @Override
    public void init() {
        GameObject.recycle(BackGroundGameOver.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}

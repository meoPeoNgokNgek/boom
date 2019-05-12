package program.scence;

import program.core.GameObject;

public class SceneWelcome extends Scene {
    @Override
    public void init() {
        GameObject.recycle(BackgroundWelcome.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}

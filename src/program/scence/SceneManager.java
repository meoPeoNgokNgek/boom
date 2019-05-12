package program.scence;

public class SceneManager {
    /**
     * thuoc tinh luu lai scene hien tai dang chay trong game
     */
    public static Scene currentScene;

    /**
     * ham dung de dua 1 scene moi vao game
     * 2 nhiem vu chinh: init scene moi va clear scene cu
     * @param newScene: scene moi can dua vao game
     */

    public static void signNewScene(Scene newScene) {
        if(currentScene != null) {
            currentScene.clear();
        }

        newScene.init();
        currentScene = newScene;
    }
}

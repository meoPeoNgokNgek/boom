package program.enemy;

import program.core.GameObject;

public class EnemySummoner extends GameObject {
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;
    Enemy enemy4;
    Enemy enemy5;
    Enemy enemy6;

    int count = 0;
    public EnemySummoner() {
//        enemy1 = GameObject.recycle(Enemy.class);
        enemy1 = new Enemy();
        enemy1.position.set(700, 0);

        enemy2 = new Enemy();
        enemy2.position.set(0, 90);

        enemy3 = new Enemy();
        enemy3.position.set(700, 180);

        enemy4 = new Enemy();
        enemy4.position.set(0, 270);

        enemy5 = new Enemy();
        enemy5.position.set(700, 360);

        enemy6 = new Enemy();
        enemy6.position.set(0, 450);
    }

    @Override
    public void run() {
        if(enemy6.active == false) {
            count++;
            if(count > 1000) {
                Enemy enemy6 = GameObject.recycle(Enemy.class);
                enemy6.position.set(0, 450);
            }

        }

        if(enemy5.active == false) {
            count++;
            if(count > 1000) {
                Enemy enemy5 = GameObject.recycle(Enemy.class);
                enemy5.position.set(0, 450);
            }

        }
        if(enemy5.active == false) {
            count++;
            if(count > 1000) {
                Enemy enemy5 = GameObject.recycle(Enemy.class);
                enemy5.position.set(0, 450);
            }

        }
        if(enemy4.active == false) {
            count++;
            if(count > 1000) {
                Enemy enemy4 = GameObject.recycle(Enemy.class);
                enemy4.position.set(0, 450);
            }

        }
        if(enemy3.active == false) {
            count++;
            if(count > 1000) {
                Enemy enemy3 = GameObject.recycle(Enemy.class);
                enemy3.position.set(0, 450);
            }

        }
        if(enemy2.active == false) {
            count++;
            if(count > 1000) {
                Enemy enemy2 = GameObject.recycle(Enemy.class);
                enemy2.position.set(0, 450);
            }

        }if(enemy1.active == false) {
            count++;
            if(count > 1000) {
                Enemy enemy1 = GameObject.recycle(Enemy.class);
                enemy1.position.set(0, 450);
            }

        }

    }
}

package program.physics;

import program.core.GameObject;
import program.player.Player;

public class BoxCollider extends Rectangle {
    Vector2D anchor;

    public BoxCollider(GameObject object, int width, int height) {
        super(object.position, width, height);
        this.anchor = object.anchor;
    }

    public BoxCollider(Vector2D position, int width, int height, Vector2D anchor) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.anchor = anchor;
    }

    public void setAnchor(double x, double y) {
        this.anchor.set(x, y);
    }

    @Override
    public double top() {
        return this.position.y - this.anchor.y * this.height;
    }

    @Override
    public double left() {
        return this.position.x - this.anchor.x * this.width;
    }

    public BoxCollider shift(double vx, double vy) {
        Vector2D newp = this.position.clone();
        newp.add(vx, vy);
        BoxCollider boxCollider = new BoxCollider(newp, this.width, this.height, this.anchor);
        return boxCollider;
    }
}

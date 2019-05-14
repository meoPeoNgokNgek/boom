package program.physics;

public class Vector2D {
    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
        this(0, 0);
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void add(Vector2D other) {
        this.add(other.x, other.y);
    }

    public void substract(double x, double y) {
        this.x -= x;
        this.y -= y;
    }

    public void substract(Vector2D other) {
        this.substract(other.x, other.y);
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void interger(double x) {
        this.x *= x;
        this.y *= x;
    }
    public  void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void set(Vector2D other) {
        this.set(other.x, other.y);
    }

    public Vector2D clone() {
        return new Vector2D(this.x,this.y);
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

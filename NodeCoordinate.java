public class NodeCoordinate {
    private int x;
    private int y;

    NodeCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(NodeCoordinate other) {
        if (other == null) return false;
        return other.getX() == this.getX() && other.getY() == this.getY();
    }
    public String toString() {
        return "NodeCoordinate x: " + x + ", y: " + y;
    }
}

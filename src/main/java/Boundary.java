public class Boundary {

    private final int x;
    private final int y;

    public Boundary(int boundaryX, int boundaryY) {
        this.x = boundaryX;
        this.y = boundaryY;
    }

    public int getBoundaryX() {
        return x;
    }

    public int getBoundaryY() {
        return y;
    }

    public boolean isInside(Point point) {
        return isBetween(point.getX(), 0, x) &&
                isBetween(point.getY(), 0, y);
    }

    private boolean isBetween(int number, int leftBoundary, int rightBoundary) {
        return leftBoundary <= number && number <= rightBoundary;
    }

}

public class Position {
    private Integer positionX;
    private Integer positionY;

    public Position(Integer positionX, Integer positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void move(Vector vector) {
        positionX = positionX + vector.getX() < 0 ? 0 : positionX + vector.getX();
        positionY = positionY + vector.getY() < 0 ? 0 : positionY + vector.getY();
    }

    @Override
    public String toString() {
        return String.format("%s %s", positionX, positionY);
    }
}
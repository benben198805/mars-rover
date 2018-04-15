public class Position {
    private Integer positionX;
    private Integer positionY;

    public Position(Integer positionX, Integer positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void move(int x, int y) {
        positionX = positionX + x < 0 ? 0 : positionX + x;
        positionY = positionY + y < 0 ? 0 : positionY + y;
    }

    @Override
    public String toString() {
        return String.format("%s %s", positionX, positionY);
    }
}
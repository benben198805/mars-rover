public enum Direction {
    N(0), E(1), S(2), W(3);

    private int index;

    Direction(int index) {
        this.index = index;
    }

    public Direction left() {
        return values()[this.index == 0 ? values().length - 1 : index - 1];
    }

    public Direction right() {
        return values()[this.index == values().length - 1 ? 0 : index + 1];
    }
}
public enum Direction {
    N {
        @Override
        public Point delta() {
            return new Point(0, 1);
        }
    }, E {
        @Override
        public Point delta() {
            return new Point(1, 0);
        }
    }, S {
        @Override
        public Point delta() {
            return new Point(0, -1);
        }
    }, W {
        @Override
        public Point delta() {
            return new Point(-1, 0);
        }
    };

    public Direction turnLeft() {
        int index = this.ordinal();
        return index == 0 ? this.values()[3] : this.values()[index - 1];
    }

    public Direction turnRight() {
        int index = this.ordinal();
        return index == this.values().length - 1 ? this.values()[0] : this.values()[index + 1];
    }

    public abstract Point delta();
}

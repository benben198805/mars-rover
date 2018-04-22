public class MarsRover {

    private int x;
    private int y;
    private String direction;

    public MarsRover(int x, int y, String direction) {

        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void execute(String command) {
        if (command.equals("R")) {
            this.direction = "E";
        } else {
            this.direction = "S";
        }
    }

    public String getLocationAndDirection() {
        return String.format("%s %s %s", x, y, direction);
    }
}
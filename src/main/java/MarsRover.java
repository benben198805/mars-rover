public class MarsRover {

    private String direction;

    public MarsRover(String initLocationAndDirection) {

    }

    public void exec(String command) {
        if (command.equals("L")) {
            this.direction = "W";
        } else {
            this.direction = "E";
        }
    }

    public String getLocationAndDirection() {
        return "0 0 " + this.direction;
    }
}
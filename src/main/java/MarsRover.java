public class MarsRover {

    private String direction;

    public MarsRover(String initLocationAndDirection) {
        final String[] inputs = initLocationAndDirection.split(" ");
        this.direction = inputs[2];
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
public class MarsRover {

    private String direction;
    private Integer positionY;

    public MarsRover(String initLocation, String initDirection) {
        final String[] inputs = initLocation.split(" ");
        this.positionY = Integer.valueOf(inputs[1]);
        this.direction = initDirection;
    }

    public void exec(String command) {
        if (command.equals("L")) {
            this.direction = "W";
        } else if (command.equals("R")) {
            this.direction = "E";
        } else {
            this.positionY = this.positionY + 1;
        }
    }

    public String getLocationAndDirection() {
        return "0 " + this.positionY + " " + this.direction;
    }
}
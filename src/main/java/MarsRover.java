public class MarsRover {

    private String direction;
    private Integer positionY;

    public MarsRover(String initLocationAndDirection) {
        final String[] inputs = initLocationAndDirection.split(" ");
        this.positionY = Integer.valueOf(inputs[1]);
        this.direction = inputs[2];
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
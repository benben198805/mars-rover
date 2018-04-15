public class MarsRover {

    private Integer positionX;
    private Integer positionY;
    private String direction;

    public MarsRover(String initLocation, String initDirection) {
        final String[] inputs = initLocation.split(" ");
        this.positionX = Integer.valueOf(inputs[0]);
        this.positionY = Integer.valueOf(inputs[1]);
        this.direction = initDirection;
    }

    public void exec(String command) {
        if (command.equals("L")) {
            this.direction = "W";
        } else if (command.equals("R")) {
            this.direction = "E";
        } else {
            if (this.direction.equals("N") || this.direction.equals("S")) {
                this.positionY = this.positionY + 1;
            } else {
                this.positionX = this.positionX + 1;
            }

        }
    }

    public String getLocationAndDirection() {
        return this.positionX + " " + this.positionY + " " + this.direction;
    }
}
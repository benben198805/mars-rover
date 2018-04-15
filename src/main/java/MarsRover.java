public class MarsRover {

    private Integer locationX;
    private Integer locationY;
    private String direction;

    public MarsRover(String initLocation) {
        final String[] inputs = initLocation.split(" ");
        this.locationX = Integer.valueOf(inputs[0]);
        this.locationY = Integer.valueOf(inputs[1]);
        this.direction = inputs[2];
    }

    public void exec(String command) {
        if (command.equals("M")) {
            this.locationY = this.locationY + 1;
        } else {
            if (command.equals("L")) {
                this.direction = "E";
            } else {
                this.direction = "W";
            }
        }
    }

    public String currentLocation() {
        return this.locationX + " " + this.locationY + " " + this.direction;
    }
}
public class MarsRover {

    private String location;
    private String direction;

    public MarsRover(String initLocation) {
        final String[] inputs = initLocation.split(" ");
        this.location = inputs[0] + " " + inputs[1];
        this.direction = inputs[2];
    }

    public void exec(String command) {
        if (command.equals("M")) {
            this.location = "0 1";
        } else {
            if (command.equals("L")) {
                this.direction = "E";
            } else {
                this.direction = "W";
            }
        }
    }

    public String currentLocation() {
        return this.location + " " + this.direction;
    }
}
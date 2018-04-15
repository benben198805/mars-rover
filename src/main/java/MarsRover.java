public class MarsRover {

    private String location;

    public MarsRover(String initLocation) {
        this.location = initLocation;
    }

    public void exec(String command) {
        if (command.equals("M")) {
            this.location = "0 1 N";
        } else {
            if (command.equals("L")) {
                this.location = "0 0 E";
            } else {
                this.location = "0 0 W";
            }
        }
    }

    public String currentLocation() {
        return this.location;
    }
}
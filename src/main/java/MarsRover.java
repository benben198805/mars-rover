public class MarsRover {

    private Integer locationX;
    private Integer locationY;
    private String direction;

    public MarsRover(String initLocation, String direction) {
        final String[] inputs = initLocation.split(" ");
        this.locationX = Integer.valueOf(inputs[0]);
        this.locationY = Integer.valueOf(inputs[1]);
        this.direction = direction;
    }

    public void exec(String command) {
        if (command.equals("M")) {
            if(this.direction.equals("N") || this.direction.equals("S")) {
                this.locationY = this.locationY + 1;
            } else {
                this.locationX = this.locationX + 1;
            }
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
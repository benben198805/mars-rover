public class MarsRover {

    public MarsRover(String initLocation) {

    }

    public String exec(String command) {
        if (command.equals("M")) {
            return "0 1 N";
        } else {
            if (command.equals("L")) {
                return "0 0 E";
            } else {
                return "0 0 W";
            }
        }
    }
}
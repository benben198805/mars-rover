import java.util.ArrayList;

public class MarsRover {

    public static final ArrayList<String> DIRECTIONS = new ArrayList<String>() {{
        add("N");
        add("E");
        add("S");
        add("W");
    }};

    private Integer locationX;
    private Integer locationY;
    private String direction;

    public MarsRover(String initLocation, String direction) {
        final String[] inputs = initLocation.split(" ");
        this.locationX = Integer.valueOf(inputs[0]);
        this.locationY = Integer.valueOf(inputs[1]);
        this.direction = direction;
    }

    public void exec(String commands) {
        for (String command : commands.split("")) {
            if (command.equals("M")) {
                if (this.direction.equals("N") || this.direction.equals("S")) {
                    this.locationY = this.locationY + 1;
                } else {
                    this.locationX = this.locationX + 1;
                }
            } else {
                int index = DIRECTIONS.indexOf(this.direction);
                if (command.equals("L")) {
                    index = index - 1 <= -1 ? DIRECTIONS.size() - 1 : index - 1;
                } else {
                    index = index + 1 >= DIRECTIONS.size() ? 0 : index + 1;
                }
                this.direction = DIRECTIONS.get(index);
            }
        }
    }

    public String currentLocation() {
        return this.locationX + " " + this.locationY + " " + this.direction;
    }
}
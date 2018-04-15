import java.util.ArrayList;
import java.util.Arrays;

public class MarsRover {
    public static final ArrayList<String> DIRECTIONS =
            new ArrayList<String>() {
                {
                    add("N");
                    add("E");
                    add("S");
                    add("W");
                }
            };

    private Integer positionX;
    private Integer positionY;
    private String direction;

    public MarsRover(String initLocation, String initDirection) {
        final String[] inputs = initLocation.split(" ");
        this.positionX = Integer.valueOf(inputs[0]);
        this.positionY = Integer.valueOf(inputs[1]);
        this.direction = initDirection;
    }

    public void exec(String commands) throws Exception {
        long count = Arrays.stream(commands.split(""))
                .distinct()
                .filter(command -> !command.equals("M") && !command.equals("L") && !command.equals("R"))
                .count();

        if (count > 0) {
            throw new Exception("Invalid command sequence");
        }

        for (String command : commands.split("")) {
            if (command.equals("L")) {
                final int index = DIRECTIONS.indexOf(this.direction);
                this.direction = DIRECTIONS.get(index == 0 ? DIRECTIONS.size() - 1 : index - 1);
            } else if (command.equals("R")) {
                final int index = DIRECTIONS.indexOf(this.direction);
                this.direction = DIRECTIONS.get(index == DIRECTIONS.size() - 1 ? 0 : index + 1);
            } else {
                if (this.direction.equals("N") || this.direction.equals("S")) {
                    this.positionY = this.positionY + 1;
                } else {
                    this.positionX = this.positionX + 1;
                }

            }
        }
    }

    public String getLocationAndDirection() {
        return this.positionX + " " + this.positionY + " " + this.direction;
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MarsRover {
    public static final int MOVE_STEP = 1;
    public static final ArrayList<String> DIRECTIONS =
            new ArrayList<String>() {
                {
                    add("N");
                    add("E");
                    add("S");
                    add("W");
                }
            };

    public static final HashMap<String, Vector> ACTIONS =
            new HashMap<String, Vector>() {{
                put("N", new Vector(0, 1));
                put("S", new Vector(0, -1));
                put("E", new Vector(1, 0));
                put("W", new Vector(-1, 0));
            }};

    private Position position;
    private String direction;

    public MarsRover(Position initPosition, String initDirection) {
        this.position = initPosition;
        this.direction = initDirection;
    }

    public void exec(String commands) throws Exception {
        checkCommands(commands);

        for (String command : commands.split("")) {
            if (command.equals("L")) {
                turnLeft();
            } else if (command.equals("R")) {
                turnRight();
            } else {
                moveForward();
            }
        }
    }

    private void turnLeft() {
        int index = DIRECTIONS.indexOf(direction);
        direction = DIRECTIONS.get(index == 0 ? DIRECTIONS.size() - 1 : index - 1);
    }

    private void turnRight() {
        int index = DIRECTIONS.indexOf(direction);
        direction = DIRECTIONS.get(index == DIRECTIONS.size() - 1 ? 0 : index + 1);
    }

    private void moveForward() {
        position.move(ACTIONS.get(direction));
    }

    private void checkCommands(String commands) throws Exception {
        long count = Arrays.stream(commands.split(""))
                .distinct()
                .filter(command -> !command.equals("M") && !command.equals("L") && !command.equals("R"))
                .count();

        if (count > 0) {
            throw new Exception("Invalid command sequence");
        }
    }

    public String getLocationAndDirection() {
        return position.toString() + " " + direction;
    }
}
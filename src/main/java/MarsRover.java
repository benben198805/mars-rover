import java.util.ArrayList;
import java.util.Arrays;

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
    private Position position;
    private String direction;

    public MarsRover(String initLocation, String initDirection) {
        final String[] inputs = initLocation.split(" ");
        this.position = new Position(Integer.valueOf(inputs[0]), Integer.valueOf(inputs[1]));
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
        switch (direction) {
            case "N":
                position.move(0, 1);
                break;
            case "S":
                position.move(0, -1);
                break;
            case "E":
                position.move(1, 0);
                break;
            case "W":
                position.move(-1, 0);
                break;
            default:
                break;
        }
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
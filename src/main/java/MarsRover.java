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
                positionY += 1;
                break;
            case "S":
                positionY = positionY == 0 ? 0 : positionY - 1;
                break;
            case "E":
                positionX += 1;
                break;
            case "W":
                positionX = positionX == 0 ? 0 : positionX - 1;
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
        return positionX + " " + positionY + " " + direction;
    }
}
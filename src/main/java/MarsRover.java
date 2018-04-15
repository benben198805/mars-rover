import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Consumer;

public class MarsRover {
    public static final int MOVE_STEP = 1;
    public static final ArrayList<Direction> DIRECTIONS =
            new ArrayList<Direction>() {
                {
                    add(Direction.N);
                    add(Direction.E);
                    add(Direction.S);
                    add(Direction.W);
                }
            };

    public static final HashMap<Direction, Vector> ACTIONS =
            new HashMap<Direction, Vector>() {{
                put(Direction.N, new Vector(0, 1));
                put(Direction.S, new Vector(0, -1));
                put(Direction.E, new Vector(1, 0));
                put(Direction.W, new Vector(-1, 0));
            }};

    public static final HashMap<String, Consumer<MarsRover>> COMMAND_ACTIONS =
            new HashMap<String, Consumer<MarsRover>>() {{
                put("L", marsRover -> marsRover.turnLeft());
                put("R", marsRover -> marsRover.turnRight());
                put("M", marsRover -> marsRover.moveForward());
            }};

    private Position position;
    private Direction direction;

    public MarsRover(Position initPosition, String initDirection) {
        this.position = initPosition;
        this.direction = Direction.valueOf(initDirection);
    }

    public void exec(String commands) throws Exception {
        checkCommands(commands);

        for (String command : commands.split("")) {
            COMMAND_ACTIONS.get(command).accept(this);
        }
    }

    private void turnLeft() {
        direction = this.direction.left();
    }

    private void turnRight() {
        direction = this.direction.right();
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
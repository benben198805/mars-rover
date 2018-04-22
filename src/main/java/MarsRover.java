import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static java.lang.Integer.MAX_VALUE;

public class MarsRover {

    private Boundary boundary = new Boundary(MAX_VALUE, MAX_VALUE);
    private Point point;
    private Direction direction;

    private Map<String, Consumer<MarsRover>> commandActions = new HashMap<>();

    public MarsRover(int x, int y, String direction) {
        this.point = new Point(x, y);
        this.direction = Direction.valueOf(direction);
        commandActions.put("R", MarsRover::turnRight);
        commandActions.put("L", MarsRover::turnLeft);
        commandActions.put("M", MarsRover::move);
    }

    public MarsRover(int x, int y, String direction, int boundaryX, int boundaryY) {
        this(x, y, direction);
        this.boundary = new Boundary(boundaryX, boundaryY);
    }

    public void execute(String command) {
        for (String currentCommand : command.split("")) {
            commandActions.get(currentCommand).accept(this);
        }
    }

    private void move() {
        Point locationAfterMovement = this.point.plus(this.direction.delta());
        if (boundary.isInside(locationAfterMovement)) {
            this.point = locationAfterMovement;
        }
    }


    private void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    private void turnRight() {
        this.direction = this.direction.turnRight();
    }

    public String getLocationAndDirection() {
        return String.format("%s %s %s", this.point.getX(), this.point.getY(), direction);
    }
}
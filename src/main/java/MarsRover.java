import java.util.ArrayList;
import java.util.List;

public class MarsRover {

    List<String> DIRECTIONS = new ArrayList<String>() {{
        add("N");
        add("E");
        add("S");
        add("W");
    }};

    private int x;
    private int y;
    private String direction;
    private int boundaryX = Integer.MAX_VALUE;
    private int boundaryY = Integer.MAX_VALUE;

    public MarsRover(int x, int y, String direction) {

        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public MarsRover(int x, int y, String direction, int boundaryX, int boundaryY) {
        this(x, y, direction);
        this.boundaryX = boundaryX;
        this.boundaryY = boundaryY;
    }

    public void execute(String command) {
        int index = DIRECTIONS.indexOf(direction);
        switch (command) {
            case "R":
                this.direction = index == DIRECTIONS.size() - 1 ? DIRECTIONS.get(0) : DIRECTIONS.get(index + 1);
                break;
            case "L":
                this.direction = index == 0 ? DIRECTIONS.get(3) : DIRECTIONS.get(index - 1);
                break;
            case "M":
                int tempX = this.x;
                int tempY = this.y;
                switch (direction) {
                    case "N":
                        tempY += 1;
                        if (0 <= tempY && tempY <= boundaryY) this.y = tempY;
                        break;
                    case "E":
                        tempX += 1;
                        if (0 <= tempX && tempX <= boundaryX) this.x = tempX;
                        break;
                    case "S":
                        tempY -= 1;
                        if (0 <= tempY && tempY <= boundaryY) this.y = tempY;
                        break;
                    case "W":
                        tempX -= 1;
                        if (0 <= tempX && tempX <= boundaryX) this.x = tempX;
                        break;
                }
                break;
        }
    }

    public String getLocationAndDirection() {
        return String.format("%s %s %s", x, y, direction);
    }
}
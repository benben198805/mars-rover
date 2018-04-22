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

    public MarsRover(int x, int y, String direction) {

        this.x = x;
        this.y = y;
        this.direction = direction;
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
                this.y += 1;
                break;
        }
    }

    public String getLocationAndDirection() {
        return String.format("%s %s %s", x, y, direction);
    }
}
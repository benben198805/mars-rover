import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MarsRoverTest {

    @Test
    public void should_return_00E_when_receive_a_right_command() throws Exception {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        marsRover.execute("R");

        assertThat(marsRover.getLocationAndDirection(), is("0 0 E"));
    }

    @Test
    public void should_return_00S_when_receive_a_left_command() {
        MarsRover marsRover = new MarsRover(0, 0, "W");

        marsRover.execute("L");

        assertThat(marsRover.getLocationAndDirection(), is("0 0 S"));
    }
}

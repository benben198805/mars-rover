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

    @Test
    public void should_return_01N_when_receive_a_move_command() {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        marsRover.execute("M");

        assertThat(marsRover.getLocationAndDirection(), is("0 1 N"));
    }

    @Test
    public void should_return_01W_when_receive_a_move_command() {
        MarsRover marsRover = new MarsRover(1, 0, "W");

        marsRover.execute("M");

        assertThat(marsRover.getLocationAndDirection(), is("0 0 W"));
    }

    @Test
    public void should_return_00W_when_receive_a_move_command() {
        MarsRover marsRover = new MarsRover(0, 0, "W", 5, 5);

        marsRover.execute("M");

        assertThat(marsRover.getLocationAndDirection(), is("0 0 W"));
    }

    @Test
    public void should_return_55N_when_receive_a_move_command() {
        MarsRover marsRover = new MarsRover(5, 5, "N", 5, 5);

        marsRover.execute("M");

        assertThat(marsRover.getLocationAndDirection(), is("5 5 N"));
    }

    @Test
    public void should_return_11E_when_receive_multiple_commands() {
        MarsRover marsRover = new MarsRover(5, 5, "N", 5, 5);

        marsRover.execute("RMRMRM");

        assertThat(marsRover.getLocationAndDirection(), is("4 4 W"));
    }

    @Test
    public void should_return_10E_when_receive_another_multiple_commands() {
        MarsRover marsRover = new MarsRover(0, 0, "N", 5, 5);

        marsRover.execute("LMLMLM");

        assertThat(marsRover.getLocationAndDirection(), is("1 0 E"));
    }
}

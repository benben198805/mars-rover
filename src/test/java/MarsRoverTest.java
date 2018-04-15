import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MarsRoverTest {
    private MarsRover marsRover;
    @Before
    public void setup(){
        this.marsRover = new MarsRover("0 0", "N");
    }

    @Test
    public void should_return_01N_when_move_forward() throws Exception {
        marsRover.exec("M");
        assertThat(marsRover.currentLocation(), is("0 1 N"));
    }

    @Test
    public void should_return_00W_when_turn_left() throws Exception {
        marsRover.exec("L");
        assertThat(marsRover.currentLocation(), is("0 0 W"));
    }

    @Test
    public void should_return_00E_when_turn_right() throws Exception {
        marsRover.exec("R");
        assertThat(marsRover.currentLocation(), is("0 0 E"));
    }

    @Test
    public void should_return_02N_when_move_forward() throws Exception {
        marsRover = new MarsRover("0 1", "N");
        marsRover.exec("M");
        assertThat(marsRover.currentLocation(), is("0 2 N"));
    }

    @Test
    public void should_return_11W_when_move_forward() throws Exception {
        marsRover = new MarsRover("0 1", "W");
        marsRover.exec("M");
        assertThat(marsRover.currentLocation(), is("1 1 W"));
    }

    @Test
    public void should_return_00N_when_turn_left() throws Exception {
        marsRover = new MarsRover("0 0", "E");
        marsRover.exec("L");
        assertThat(marsRover.currentLocation(), is("0 0 N"));
    }

    @Test
    public void should_return_10W_when_forward_and_turn_left() throws Exception {
        marsRover.exec("LM");
        assertThat(marsRover.currentLocation(), is("1 0 W"));
    }

    @Test
    public void should_return_10W_when_receive_multiple_commands() throws Exception {
        marsRover = new MarsRover("0 0", "S");
        marsRover.exec("LMLMRM");
        assertThat(marsRover.currentLocation(), is("2 1 E"));
    }
}

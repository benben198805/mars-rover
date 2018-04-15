import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MarsRoverTest {
    private MarsRover marsRover;
    @Before
    public void setup(){
        this.marsRover = new MarsRover("0 0 N");
    }

    @Test
    public void should_return_01N_when_move_forward() throws Exception {
        marsRover.exec("M");
        assertThat(marsRover.currentLocation(), is("0 1 N"));
    }

    @Test
    public void should_return_00W_when_turn_right() throws Exception {
        marsRover.exec("R");
        assertThat(marsRover.currentLocation(), is("0 0 W"));
    }

    @Test
    public void should_return_00E_when_turn_right() throws Exception {
        marsRover.exec("L");
        assertThat(marsRover.currentLocation(), is("0 0 E"));
    }

    @Test
    public void should_return_02N_when_move_forward() throws Exception {
        marsRover = new MarsRover("0 1 N");
        marsRover.exec("M");
        assertThat(marsRover.currentLocation(), is("0 2 N"));
    }
}

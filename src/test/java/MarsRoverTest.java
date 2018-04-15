import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class MarsRoverTest {

    private MarsRover marsRover;

    @Before
    public void setup(){
        marsRover = new MarsRover("0 0", "N");
    }

    @Test
    public void should_return_00E_when_receive_R_command() throws Exception {
        marsRover.exec("R");

        Assert.assertThat(marsRover.getLocationAndDirection(), is("0 0 E"));
    }

    @Test
    public void should_return_00W_when_receive_L_command() throws Exception {
        marsRover.exec("L");

        Assert.assertThat(marsRover.getLocationAndDirection(), is("0 0 W"));
    }

    @Test
    public void should_return_00S_when_init_different_direction() throws Exception {
        marsRover = new MarsRover("0 0", "S");

        Assert.assertThat(marsRover.getLocationAndDirection(), is("0 0 S"));
    }

    @Test
    public void should_return_01N_when_receive_M_command() throws Exception {
        marsRover.exec("M");

        Assert.assertThat(marsRover.getLocationAndDirection(), is("0 1 N"));
    }
}

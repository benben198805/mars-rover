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

    @Test
    public void should_return_21E_when_receive_M_command() throws Exception {
        marsRover = new MarsRover("1 1", "E");

        marsRover.exec("M");

        Assert.assertThat(marsRover.getLocationAndDirection(), is("2 1 E"));
    }

    @Test
    public void should_return_00N_when_receive_L_command() throws Exception {
        marsRover = new MarsRover("0 0", "E");

        marsRover.exec("L");

        Assert.assertThat(marsRover.getLocationAndDirection(), is("0 0 N"));
    }

    @Test
    public void should_return_11E_when_receive_multiple_commands() throws Exception {
        marsRover.exec("MRM");

        Assert.assertThat(marsRover.getLocationAndDirection(), is("1 1 E"));
    }

    @Test
    public void should_return_00W_when_receive_multiple_commands() throws Exception {
        marsRover = new MarsRover("1 1", "E");
        marsRover.exec("RMRM");

        Assert.assertThat(marsRover.getLocationAndDirection(), is("0 0 W"));
    }

    @Test
    public void should_return_11S_when_receive_multiple_commands() throws Exception {
        marsRover.exec("MRMLML");

        Assert.assertThat(marsRover.getLocationAndDirection(), is("1 2 W"));
    }

    @Test(expected = Exception.class)
    public void should_return_exception_when_receive_not_available_commands() throws Exception {
        marsRover.exec("YY");
    }
}

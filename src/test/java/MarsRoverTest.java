import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class MarsRoverTest {

    @Test
    public void should_return_00E_when_receive_R_command() throws Exception {
        MarsRover marsRover = new MarsRover("0 0 N");

        marsRover.exec("R");

        Assert.assertThat(marsRover.getLocationAndDirection(), is("0 0 E"));
    }
}

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MarsRoverTest {

    @Test
    public void should_return_01N_when_move_forward() throws Exception {
        final MarsRover marsRover = new MarsRover("0 0 N");
        assertThat(marsRover.exec("M"), is("0 1 N"));
    }
}

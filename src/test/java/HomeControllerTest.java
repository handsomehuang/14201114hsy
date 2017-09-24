
import com.nchu.controller.HomeController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class HomeControllerTest {


    @Test
    public void testHome() {
        HomeController controller = new HomeController();
        assertEquals("index", controller.home());
    }
}

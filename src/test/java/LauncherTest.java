import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LauncherTest {
    @Test
    void firstTest(){
        Launcher launcher = new Launcher();
        assertEquals(launcher.switchStatement(2),2 );
    }

}
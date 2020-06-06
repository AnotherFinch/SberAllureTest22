package stepDefs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import steps.BaseSteps;

public class Hooks {

        @Before
        public void setUp() throws Exception {
            BaseSteps.setUp();
        }

        @After
        public void tearDown() throws Exception {
            BaseSteps.tearDown();
        }
    }


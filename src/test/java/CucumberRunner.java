import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"stepDefs"},
        features = {"src/test/resources/"},
        tags = {"@check"}
)

public class CucumberRunner {
}

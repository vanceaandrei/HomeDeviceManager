package runner;

/**
 * Created by andrei.vancea on 11/7/2016.
 */

import functional.LoginUserTestCases;
import functional.RegisterUserTestCases;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RegisterUserTestCases.class,
        LoginUserTestCases.class,
})
public class FunctionalTestSuite {
}

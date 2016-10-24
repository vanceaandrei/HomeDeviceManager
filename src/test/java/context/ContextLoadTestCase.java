package context;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by andrei.vancea on 10/6/2016.
 */

public class ContextLoadTestCase {

    @Test
    public void testContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:**/Hello-servlet.xml");
        System.out.println(context.getBeanDefinitionCount());
        Assert.assertNotNull(context);
    }
}

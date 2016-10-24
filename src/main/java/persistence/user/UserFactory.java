package persistence.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import persistence.user.api.IUserRepository;
import persistence.user.api.exceptions.BeanLoadException;

/**
 * Created by andrei.vancea on 9/26/2016.
 */
public class UserFactory {

    private static final Logger mLog = LoggerFactory.getLogger(UserFactory.class);
    /**
     * Application tree context.
     */
    private static ApplicationContext CTX;
    /**
     * Name of system property used to specify WidePipe API configuration file
     * location.
     */
    public static final String PROP_USER_CONFIG_FILE = "USER_API_CONFIG_FILE";
    /**
     * Default location of the WidePipe API configuration file.
     */
    public static final String USER_CONFIG_FILE_DEFAULT = "user/user_api.xml";

    /**
     * bill repository object
     */
    private static final String USER_REPOSITORY_BEAN = "userRepository";

    /**
     * Private Constructor.
     */
    private UserFactory() {
    }

    /**
     * Load the application context from the XML configuration files specified.
     *
     * @param sName String[] Array of configuration files to load as part of this
     *              application context
     * @throws BeanLoadException Thrown when unable to load the XML file.
     */
    private static synchronized void loadAppContext(final String[] sName) {
        if (CTX == null) {
            if (mLog.isDebugEnabled()) {
                mLog.debug("loadAppContext: reading app context from classpath for - " + sName);
            }

            CTX = new ClassPathXmlApplicationContext(sName);

            if (CTX == null) {
                throw new BeanLoadException("null application context for - " + sName);
            }
        }
    }

    /**
     * Factory method to get the application context for bean instantiation.
     *
     * @return ApplicationContext for use in bean instantiation.
     * @throws BeanLoadException Thrown when unable to load the XML file.
     */
    private static ApplicationContext getContext() {
        if (CTX == null) {

            final String sConfigFile = System.getProperty(PROP_USER_CONFIG_FILE, USER_CONFIG_FILE_DEFAULT);

            if (mLog.isDebugEnabled()) {
                mLog.debug("getContext: Loading application context from files: {}", sConfigFile);
            }

            final String[] sConfigFiles = new String[]{sConfigFile};
            loadAppContext(sConfigFiles);
        }
        return CTX;
    }

    /**
     * Factory method to create a bean given its name.
     *
     * @param cName String bean name.
     * @return Object Instantiated bean. Caller needs to cast to appropriate
     * type.
     */
    private static Object getBean(final String cName) {
        return getContext().getBean(cName);
    }

    /**
     * Get a IWidePipeRepository object.
     *
     * @return IWidePipeRepository object
     */
    public static IUserRepository getUserRepository() {
        return (IUserRepository) getBean(USER_REPOSITORY_BEAN);
    }

}

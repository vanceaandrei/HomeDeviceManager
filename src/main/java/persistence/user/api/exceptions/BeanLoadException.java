package persistence.user.api.exceptions;

/**
 * Created by andrei.vancea on 9/26/2016.
 */
public class BeanLoadException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * instance of BeanLoadException.
     */
    public BeanLoadException() {
        super();
    }

    /**
     * instance of BeanLoadException.
     *
     * @param sInValue
     *            String
     */
    public BeanLoadException(final String sInValue) {
        super(sInValue);
    }
}
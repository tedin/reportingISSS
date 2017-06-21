package ba.isss.restservices.exceptions;

public class RestServiceException extends RuntimeException {

	private static final long serialVersionUID = 484121119131858896L;

	public RestServiceException(String message) {
		this(message, null);
	}

	public RestServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
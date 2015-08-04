package exceptions;

public class InsufficientFuelException extends ShipException {

	private static final long serialVersionUID = 2892289193517112807L;

	public InsufficientFuelException(String msg) {
		super(msg);
	}

}

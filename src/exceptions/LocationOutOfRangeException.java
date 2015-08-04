package exceptions;

public class LocationOutOfRangeException extends ShipException {

	private static final long serialVersionUID = -191457900784412770L;

	public LocationOutOfRangeException(String msg) {
		super(msg);
	}

}

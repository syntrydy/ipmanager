package org.gasmyr.ipmanager.exception;

public class DatabaseConnectionErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2277704114347668400L;

	@Override
	public String getMessage() {
		return "Unable to connect to the database.";
	}

}

/**
 * Gabriel Gheorghian
 * 0737019
 */
package cs516.gabrielGheorghian.exceptions;

/**
 * @author 0737019
 *
 */
public class BadNextValueException extends Exception {

	public BadNextValueException() {
	}

	public BadNextValueException(String message) {
		super(message);
	}

	public BadNextValueException(Throwable cause) {
		super(cause);
	}

	public BadNextValueException(String message, Throwable cause) {
		super(message, cause);
	}

}
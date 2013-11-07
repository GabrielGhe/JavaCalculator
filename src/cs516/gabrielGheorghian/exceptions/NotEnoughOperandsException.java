/**
 * Gabriel Gheorghian
 * 0737019
 */
package cs516.gabrielGheorghian.exceptions;

/**
 * @author 0737019
 *
 */
public class NotEnoughOperandsException extends Exception {

	public NotEnoughOperandsException() {
	}

	public NotEnoughOperandsException(String message) {
		super(message);
	}

	public NotEnoughOperandsException(Throwable cause) {
		super(cause);
	}

	public NotEnoughOperandsException(String message, Throwable cause) {
		super(message, cause);
	}

}
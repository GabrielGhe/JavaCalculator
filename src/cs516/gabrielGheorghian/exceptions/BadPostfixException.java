/**
 * Gabriel Gheorghian
 * 0737019
 */
package cs516.gabrielGheorghian.exceptions;

/**
 * @author 0737019
 *
 */
public class BadPostfixException extends Exception {

	public BadPostfixException() {
	}

	public BadPostfixException(String message) {
		super(message);
	}

	public BadPostfixException(Throwable cause) {
		super(cause);
	}

	public BadPostfixException(String message, Throwable cause) {
		super(message, cause);
	}

}
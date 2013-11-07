/**
 * Gabriel Gheorghian
 * 0737019
 */
package cs516.gabrielGheorghian.exceptions;

/**
 * @author 0737019
 *
 */
public class DAIllegalArgumentException extends Exception {

	public DAIllegalArgumentException() {
	}

	public DAIllegalArgumentException(String message) {
		super(message);
	}

	public DAIllegalArgumentException(Throwable cause) {
		super(cause);
	}

	public DAIllegalArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

}
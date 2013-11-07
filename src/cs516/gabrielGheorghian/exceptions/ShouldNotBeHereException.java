/**
 * Gabriel Gheorghian
 * 0737019
 */
package cs516.gabrielGheorghian.exceptions;

/**
 * @author 0737019
 *
 */
public class ShouldNotBeHereException extends Exception {

	public ShouldNotBeHereException() {
	}

	public ShouldNotBeHereException(String message) {
		super(message);
	}

	public ShouldNotBeHereException(Throwable cause) {
		super(cause);
	}

	public ShouldNotBeHereException(String message, Throwable cause) {
		super(message, cause);
	}

}
/**
 * Gabriel Gheorghian
 * 0737019
 */
package cs516.gabrielGheorghian.exceptions;

/**
 * @author 0737019
 *
 */
public class UnmatchingParenthesisException extends Exception {

	public UnmatchingParenthesisException() {
	}

	public UnmatchingParenthesisException(String message) {
		super(message);
	}

	public UnmatchingParenthesisException(Throwable cause) {
		super(cause);
	}

	public UnmatchingParenthesisException(String message, Throwable cause) {
		super(message, cause);
	}

}
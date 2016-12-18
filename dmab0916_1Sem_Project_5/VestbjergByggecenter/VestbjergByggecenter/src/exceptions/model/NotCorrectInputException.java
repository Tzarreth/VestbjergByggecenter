package exceptions.model;

@SuppressWarnings("serial")
public class NotCorrectInputException extends Exception {
	public NotCorrectInputException(String message) {
		System.out.println(message);
	}
}

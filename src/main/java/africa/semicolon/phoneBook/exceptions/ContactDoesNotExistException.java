package africa.semicolon.phoneBook.exceptions;

public class ContactDoesNotExistException extends AddContactFailureException {
    public ContactDoesNotExistException(String message) {
        super(message);
    }
}

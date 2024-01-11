package effectivemobile.taskmanagementsystem.exeptions;

public class UserEmailNotFoundExeption extends RuntimeException {
    public UserEmailNotFoundExeption(String message) {
        super(message);
    }
}

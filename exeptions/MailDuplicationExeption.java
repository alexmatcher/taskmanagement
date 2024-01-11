package effectivemobile.taskmanagementsystem.exeptions;

public class MailDuplicationExeption extends RuntimeException {
    public MailDuplicationExeption(String message) {
        super(message);
    }
}

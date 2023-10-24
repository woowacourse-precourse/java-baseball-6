package baseball.validation;

public class ExitValidation {
    private ExitValidation() { }

    public static void checkValidExit(int choice) {
        if(choice != 1 && choice != 2) {
            throw new IllegalArgumentException("1과 2만 입력해주세요.");
        }
    }
}

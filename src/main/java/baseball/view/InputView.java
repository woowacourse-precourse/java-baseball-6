package baseball.view;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }
    public String inputNumber(){
            return readLine();
    }
    public String restartInputNumber(){
            String restartNumber = readLine();
            if (!restartNumber.equals("1") && !restartNumber.equals("2")) {
                throw new IllegalArgumentException("올바른 입력이 아닙니다.");
            }
            return restartNumber;
    }
}

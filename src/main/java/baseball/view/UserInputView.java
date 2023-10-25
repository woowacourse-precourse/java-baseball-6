package baseball.view;
import camp.nextstep.edu.missionutils.Console;
public class UserInputView {
    private final static String START = "숫자를 입력해주세요 :";
    private final static String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static String startMessage() {
        System.out.print(START);
        return Console.readLine();
    }
    public static String reStartMessage() {
        System.out.println(RESTART);
        return Console.readLine();
    }
}

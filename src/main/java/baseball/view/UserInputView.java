package baseball.view;
import camp.nextstep.edu.missionutils.Console;
public class UserInputView {

    private final static String start = "숫자를 입력해주세요 :";
    private final static String reStart = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String startMessage() {
        System.out.print(start);
        return Console.readLine();
    }

    public static String reStartMessage() {
        System.out.println(reStart);
        return Console.readLine();
    }

}

package baseball;

import static baseball.InputValidator.gameInputValidator;
import static baseball.InputValidator.restartInputValidator;
import static baseball.Utils.stringToInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private List<Integer> userNum;

    UserInput() {
        this.userNum = new ArrayList<>();
    }

    public List<Integer> getUserNum() {
        return List.copyOf(userNum);
    }

    public void promptUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String string = Console.readLine();
        gameInputValidator(string);
        userNum = stringToInt(string);
    }

    public int promptUserForRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String s = Console.readLine();
        restartInputValidator(s);
        List<Integer> userAnswer = new ArrayList<>(stringToInt(s));
        return userAnswer.get(0);
    }

}

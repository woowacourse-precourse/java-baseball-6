package baseball.GameController;

import baseball.Judge.Judge;
import baseball.User.User;
import java.util.ArrayList;

public class GameController {
    void startView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    void inputView() {
        System.out.println("숫자를 입력해 주세요 : ");
    }

    void checkInput(User user, String input) {
        if (!user.checkthreeNum(input)) {

            throw new IllegalArgumentException("3자리 숫자여야 합니다.");
        }
        if (!user.checkRange(input)) {
            throw new IllegalArgumentException("1~9사이 숫자여야 합니다.");
        }
        if (!user.checkdifferentNum(input)) {
            throw new IllegalArgumentException("서로다른 숫자여야 합니다.");
        }

    }

    int judgeResult(Judge judge, String input, ArrayList<Integer> answer) {

        judge.setAnswer(answer);
        judge.setInput(input);

        int strike = judge.judgeStrike();
        int ball = judge.judgeBall();

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return 0;
        } else if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 3;
        } else {
            String result = new String(strike + "스트라이크 " + ball + "볼");
            System.out.println(result);
            return strike;

        }


    }


}

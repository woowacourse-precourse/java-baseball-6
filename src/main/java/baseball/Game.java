package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    public void play() {

        List<Integer> answerNumbers = Util.getRandomNumber(3);

        while(true) {
            List<Integer> userNumbers = askUserNumbers();

            Score score = Score.getScore(answerNumbers, userNumbers);

            printScore(score);

            if(score.getStrike() == 3) {
                break;
            }
        }
    }

    public List<Integer> askUserNumbers() {

        System.out.print("숫자를 입력해주세요 : ");
        String userString = Console.readLine();

        Util.validateUserString(userString);

        List<Integer> userNumbers = Util.stringToIntegerList(userString);

        return userNumbers;
    }

    public void printScore(Score score) {

        int strike = score.getStrike();
        int ball = score.getBall();

        if(strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if(strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return;
        }

        if(strike > 0) {
            System.out.println(strike + "스트라이크");
            return;
        }

        if(ball > 0) {
            System.out.println(ball + "볼 ");
            return;
        }

        System.out.println("낫싱");
    }
}

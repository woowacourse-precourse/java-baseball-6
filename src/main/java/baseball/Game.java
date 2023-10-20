package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    public void play() {

        List<Integer> answerNumbers = Util.getRandomNumber();
        System.out.println(answerNumbers.toString());

        while(true) {
            List<Integer> userNumbers = getUserNumbers();

            Score score = Util.getScore(answerNumbers, userNumbers);

            printScore(score);

            if(score.getStrike() == 3) {
                break;
            }
        }
    }

    public List<Integer> getUserNumbers() {

        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        List<Integer> userNumbers = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            userNumbers.add(userInput.charAt(i) - '0');
        }

        Util.validateUserNumbers(userNumbers);

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

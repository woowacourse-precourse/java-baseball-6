package baseball.console.game.numberbaseball;

import baseball.console.game.numberbaseball.domain.computer.Computer;
import baseball.console.game.numberbaseball.domain.user.UserPrediction;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGame {
    UserPrediction userPrediction;
    Computer computer;

    boolean isCorrect;

    public NumberBaseballGame() {
        computer = new Computer();
        isCorrect = false;
    }

    public void start() {
        computer.generate();
        while (!isCorrect) {
            userPrediction = userPredict();
            isCorrect = matchTest(userPrediction.getUserNumbers(), computer.getNumbers());
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private UserPrediction userPredict() {
        printGameMessage("숫자를 입력해주세요: ");
        return new UserPrediction(Console.readLine());
    }



    private boolean matchTest(List<Integer> userNumbers, List<Integer> targetNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (targetNumbers.get(i) == userNumbers.get(i))
                strike++;
            else {
                for (int j = 0; j < 3; j++) {
                    if (j != i && targetNumbers.get(i) == userNumbers.get(j)){
                        ball++;
                    }
                }
            }
        }

        if (ball==0 && strike==0) System.out.println("낫싱");
        else {
            String result = "";
            if (ball != 0) result += ball + "볼 ";
            if (strike != 0) result += strike + "스트라이크";
            System.out.println(result);
        }

        return strike == 3;
    }
    private void printGameMessage(String message) {
        System.out.println(message);
    }
}

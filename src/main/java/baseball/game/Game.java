package baseball.game;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.util.Utility;
import java.util.List;

public class Game {
    private List<Integer> computer = null;
    private int strike = 0;
    private int ball = 0;

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        this.computer = Utility.assignComputerRandomNumber();
        System.out.println("computer : " + this.computer);

        String restartOrExitNumber = "1";
        while (restartOrExitNumber.equals("1")) {

            while (this.strike != 3) {
                System.out.print("숫자를 입력해주세요: ");
                List<Integer> predictNumbers = Utility.input();
                checkPredictNumber(predictNumbers);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작려면 1, 종료하려면 2를 입력하세요");
            restartOrExitNumber = readLine();
        }
    }

    private void checkPredictNumber(List<Integer> predictNumbers) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < computer.size(); i++) {
            Integer computerNumber = computer.get(i);
            Integer predictNumber = predictNumbers.get(i);

            if (computerNumber.equals(predictNumber)) {
                strike++;
            } else {
                if (predictNumbers.contains(computerNumber)) {
                    ball++;
                }
            }
        }

        this.strike = strike;
        this.ball = ball;
    }

}

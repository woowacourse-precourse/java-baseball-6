package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameStart {
    public static void start() {
        List<Integer> computer = SelectRandom.getRandomNum();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();
            if (!CorrectNum.isNumber(input)) {
                throw new IllegalArgumentException("입력된 값이 숫자가 아닙니다.");
            }
            if (!CorrectNum.isThreeSize(input)) {
                throw new IllegalArgumentException("입력된 값이 3자리 보다 큽니다.");
            }
            if (CorrectNum.isContainZero(input)) {
                throw new IllegalArgumentException("입력된 값에 0이 포함되어 있습니다.");
            }
            if(CorrectNum.isContainNum(input)){
                throw new IllegalArgumentException("입력된 값에 중복되는 숫자가 있습니다.");
            }

            int ball = JudgeBallStrike.judge(computer, input) / 10;
            int strike = JudgeBallStrike.judge(computer, input) % 10;

            if (JudgeBallStrike.judge(computer, input) == 0) {
                System.out.println("낫싱");
            }

            if (ball == 0 && strike != 0) {
                System.out.println(strike + "스트라이크");
            }

            if (ball != 0 && strike == 0) {
                System.out.println(ball + "볼");
            }

            if (ball > 0 && strike > 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}

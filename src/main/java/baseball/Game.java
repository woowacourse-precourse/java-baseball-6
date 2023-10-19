package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.Const.NUMBER_LENGTH;
import static baseball.Validator.validateInput;

public class Game {

    private static final Game instance = new Game();
    private final User user;

    private Game() {
        this.user = new User();
    }

    public static Game getInstance() {
        return instance;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {

            List<Integer> answer = Randoms.pickUniqueNumbersInRange(1, 9, NUMBER_LENGTH);

            while (true) {
                System.out.print("숫자를 입력해주세요: ");
                user.pickNumber();

                Result result = new Result(0, 0);
                match(answer, user.getNumbers(), result);

                if (result.isEnd()) break;
            }

            if (!isGameContinued()) break;
        }
    }

    private void match(List<Integer> answer, List<Integer> userPick, Result result) {

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            boolean isExist = answer.contains(userPick.get(i));
            boolean isRightOrder = (Objects.equals(answer.get(i), userPick.get(i)));

            if (isExist) {
                if (isRightOrder) result.addStrike();
                else result.addBall();
            }
        }

        result.printResult();
    }

    private boolean isGameContinued() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

        int command = Integer.parseInt(Console.readLine());
        Validator.validateCommand(command);

        return command == 1;
    }

    public static class Result {
        private int ball;
        private int strike;

        public Result(int ball, int strike) {
            this.ball = ball;
            this.strike = strike;
        }

        public int getBall() {
            return ball;
        }

        public int getStrike() {
            return strike;
        }

        public void addBall() {
            ball++;
        }

        public void addStrike() {
            strike++;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (getBall() == 0 && getStrike() == 0) {
                sb.append("낫싱");
            } else {
                if (getBall() != 0) {
                    sb.append(getBall()).append("볼 ");
                }
                if (getStrike() != 0) {
                    sb.append(getStrike()).append("스트라이크");
                }
            }

            return sb.toString();
        }

        public void printResult() {
            System.out.println(this);


            if (getStrike() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }

        public boolean isEnd() {
            return getStrike() == 3;
        }
    }
}

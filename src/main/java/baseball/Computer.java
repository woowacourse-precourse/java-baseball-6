package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private final User user;
    private List<Integer> computerNumber;
    private int strike;
    private int ball;

    public Computer() {
        user = new User();
    }

    public void baseBallGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        setComputerNumber();

        compareNumber();

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        checkRestart();
    }

    private void setComputerNumber() {
        computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    private int compareNumber() {
        strike = 0;
        ball = 0;
        List<Integer> userNumber = user.getUserNumber();

        for (int i = 0; i < 3; i++) {
            int userI = userNumber.get(i);
            int computerI = computerNumber.get(i);

            if (userI == computerI) {
                strike++;
            } else if (computerNumber.contains(userI)) {
                ball++;
            }
        }

        printBallStrike();

        return (strike == 3 ? 0 : compareNumber());
    }

    private void printBallStrike() {
        StringBuilder sb = new StringBuilder();

        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike > 0) {
            sb.append(strike).append("스트라이크 ");
        }
        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }
        System.out.println(sb);
    }

    private void checkRestart() {
        boolean restart = user.checkRestart();
        if (restart) {
            baseBallGame();
        }
    }
}

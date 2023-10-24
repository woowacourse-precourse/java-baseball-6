package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final String RESTART = "1";
    private static final String EXIT = "2";

    public static void main(String[] args) {

        while (true) {
            List<Integer> computer = getComputerNumber();

            while (true) {
                List<Integer> player = getPlayerNumber();

                BallCount ballCount = BallCount.create(computer, player);

                if (ballCount.getBallCountType() == BallCountType.STRIKEOUT) {
                    ballCount.printStrikeOut();
                    break;
                }
                switch (ballCount.getBallCountType()) {
                    case NOTHING -> ballCount.printNothing();
                    case BALL_AND_STRIKE -> ballCount.printBallAndStrike();
                    case ONLY_BALL -> ballCount.printOnlyBall();
                    case ONLY_STRIKE -> ballCount.printOnlyStrike();
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String fin = Console.readLine();

            if (fin.equals(RESTART)) {
            } else if (fin.equals(EXIT)) {
                break;
            } else {
                throw new IllegalArgumentException();
            }

        }
    }

    /**
     * 중복되지 않는 3개의 임의의 수 반환
     */
    private static List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    /**
     * 사용자의 예측 숫자 입력
     */
    private static List<Integer> getPlayerNumber() {
        List<Integer> player = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        final char[] playerInput = Console.readLine().toCharArray();

        if (playerInput.length != 3) {
            throw new IllegalArgumentException();
        }

        for (int c : playerInput) {
            int i = c - 48;
            if (player.contains(i)) {
                throw new IllegalArgumentException();
            }
            player.add(i);
        }

        return player;
    }
}

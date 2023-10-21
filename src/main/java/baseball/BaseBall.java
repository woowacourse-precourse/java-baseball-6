package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {

    private static final String ONLY_STRIKE = "%d스트라이크";
    private static final String ONLY_BALL = "%d볼";
    private static final String BALL_AND_STRIKE = "%d볼 %d스트라이크";
    private static final String DONE = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NONE = "낫싱";

    private final int length;
    private List<Integer> computer;
    private boolean isOver;

    public BaseBall(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("입력 길이는 양수이어야 합니다.");
        }
        this.length = length;
        this.computer = RandomNumber.generate(length);
        this.isOver = false;
    }

    public void newGame() {
        computer = RandomNumber.generate(length);
        isOver = false;
    }

    public void doGame(List<Integer> player) {
        validateInput(player);
        int ball = getBallCount(player);
        int strikes = getStrikeCount(player);
        printResult(ball, strikes);
        if (strikes == length) {
            finishGame();
        }
    }

    private void printResult(int balls, int strikes) {
        if (balls > 0 && strikes > 0) {
            System.out.println(String.format(BALL_AND_STRIKE, balls, strikes));
        } else if (balls > 0) {
            System.out.println(String.format(ONLY_BALL, balls));
        } else if (strikes > 0) {
            System.out.println(String.format(ONLY_STRIKE, strikes));
        } else {
            System.out.println(String.format(NONE, strikes));
        }
    }

    public void finishGame() {
        System.out.println(String.format(DONE, length));
        isOver = true;
    }

    public boolean isOver() {
        return isOver;
    }

    private int getBallCount(List<Integer> player) {
        int balls = 0;
        for (int i = 0; i < player.size(); i++) {
            final int playerNumber = player.get(i);
            int computerNumberIndex = computer.indexOf(playerNumber);
            if (computerNumberIndex > 0 && computerNumberIndex != i) {
                balls++;
            }
        }
        return balls;
    }

    private int getStrikeCount(List<Integer> player) {
        int strikes = 0;
        for (int i = 0; i < player.size(); i++) {
            final int playerNumber = player.get(i);
            int computerNumberIndex = computer.indexOf(playerNumber);
            if (computerNumberIndex == i) {
                strikes++;
            }
        }
        return strikes;
    }

    private void validateInput(List<Integer> player) {
        if (player == null) {
            throw new IllegalArgumentException("올바르지 않은 입력값입니다.");
        } else if (player.isEmpty()) {
            throw new IllegalArgumentException("입력값은 빈 배열일 수 없습니다.");
        } else if (player.size() != length) {
            throw new IllegalArgumentException(String.format("입력 길이는 %d 이어야 합니다.", length));
        }
    }
}

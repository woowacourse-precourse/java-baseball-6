package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private static final String STARTING_STRING = "숫자 야구 게임을 시작합니다.";
    private static final String RESTARING_STRING = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String ENDING_STRING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼 ";
    private static final String NOTHING = "낫싱";
    private static final String RESTART = "1";
    private static final String END = "2";
    private static final int SIZE = 3;
    private static final int RANDOM_START = 1;
    private static final int RANDOM_END = 9;
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> player = new ArrayList<>();
    private boolean correctFlag = false;
    User user = new User();

    public void gameStart() {
        System.out.println(STARTING_STRING);
        computer = randomNumber();
        while (!correctFlag) {
            player = user.getNumber();
            sendMessage(computer, player);
        }
    }

    private List<Integer> randomNumber() {
        Set<Integer> computer = new HashSet<>();
        while (computer.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_START, RANDOM_END);
            computer.add(randomNumber);
        }
        return new ArrayList<>(computer);
    }

    private void reset() {
        System.out.println(RESTARING_STRING);
        String input = Console.readLine();

        if (input.equals(RESTART)) {
            gameStart();
        } else if (input.equals(END)) {
            correctFlag = true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> calculateScore(List<Integer> computer, List<Integer> player) {
        int strikes = 0;
        int balls = 0;

        for (int idx = 0; idx < computer.size(); idx++) {
            if (computer.get(idx).equals(player.get(idx))) {
                strikes++;
            } else if (computer.contains(player.get(idx))) {
                balls++;
            }
        }
        return Arrays.asList(strikes, balls);
    }

    private void displayScore(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println(NOTHING);
            return;
        }

        StringBuilder scoreMessage = new StringBuilder();

        if (balls > 0) {
            scoreMessage.append(balls).append(BALL);
        }

        if (strikes > 0) {
            scoreMessage.append(strikes).append(STRIKE);
        }

        System.out.println(scoreMessage.toString().trim());
    }

    private void sendMessage(List<Integer> computer, List<Integer> player) {
        List<Integer> score = calculateScore(computer, player);
        int strikes = score.get(0);
        int balls = score.get(1);
        displayScore(strikes, balls);

        if (strikes == SIZE) {
            System.out.println(ENDING_STRING);
            reset();
        }
    }
}

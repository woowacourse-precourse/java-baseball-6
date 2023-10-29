package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> player = new ArrayList<>();
    private boolean correctFlag = false;
    User user = new User();

    public void gameStart() {
        System.out.println(GameConstant.STARTING_STRING.getStringValue());
        computer = randomNumber();
        while (!correctFlag) {
            player = user.getNumber();
            sendMessage(computer, player);
        }
    }

    private List<Integer> randomNumber() {
        Set<Integer> computer = new HashSet<>();
        while (computer.size() < GameConstant.SIZE.getIntValue()) {
            int randomNumber = Randoms.pickNumberInRange(
                    GameConstant.RANDOM_START.getIntValue(), GameConstant.RANDOM_END.getIntValue()
            );
            computer.add(randomNumber);
        }
        return new ArrayList<>(computer);
    }

    private void reset() {
        System.out.println(GameConstant.RESTARING_STRING.getStringValue());
        String input = Console.readLine();

        if (input.equals(GameConstant.RESTART.getStringValue())) {
            gameStart();
        } else if (input.equals(GameConstant.END.getStringValue())) {
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
            System.out.println(GameConstant.NOTHING.getStringValue());
            return;
        }

        StringBuilder scoreMessage = new StringBuilder();

        if (balls > 0) {
            scoreMessage.append(balls).append(GameConstant.BALL.getStringValue());
        }

        if (strikes > 0) {
            scoreMessage.append(strikes).append(GameConstant.STRIKE.getStringValue());
        }

        System.out.println(scoreMessage.toString().trim());
    }

    private void sendMessage(List<Integer> computer, List<Integer> player) {
        List<Integer> score = calculateScore(computer, player);
        int strikes = score.get(0);
        int balls = score.get(1);
        displayScore(strikes, balls);

        if (strikes == GameConstant.SIZE.getIntValue()) {
            System.out.println(GameConstant.ENDING_STRING.getStringValue());
            reset();
        }
    }
}

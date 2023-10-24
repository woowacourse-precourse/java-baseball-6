package baseball;

import static baseball.Constant.END_RANGE;
import static baseball.Constant.INPUT_MESSAGE;
import static baseball.Constant.NUMBER_COUNT;
import static baseball.Constant.START_RANGE;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> computer = new ArrayList<>();

    public Game() {
        while (computer.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!isContainedNumber(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public void play() {
        String inputString;
        boolean is3Strike = false;
        do {
            System.out.print(INPUT_MESSAGE);
            inputString = Console.readLine().replace(" ", ""); // 공백 실수 허용
            Player player = new Player(inputString);
            is3Strike = checkResult(player.getDuplicatePlayerList());
        } while (!is3Strike);
    }

    private boolean isContainedNumber(int randomNumber) {
        for (Integer x : computer) {
            if (x == randomNumber) {
                return true;
            }
        }
        return false;
    }

    private boolean checkResult(List<Integer> playerList) {
        int strike = getStrike(playerList);
        int ball = getBall(playerList) - strike;

        Result result = new Result(strike, ball);
        System.out.println(result.getHintString());
        return result.is3Strike();
    }

    private int getStrike(List<Integer> playerList) {
        int strike = 0;

        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).equals(computer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int getBall(List<Integer> playerList) {
        int ball = 0;

        for (Integer p : playerList) {
            if (computer.contains(p)) {
                ball++;
            }
        }
        return ball;
    }
}
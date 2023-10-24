package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    OutPutView outPutView = new OutPutView();
    GameException gameException = new GameException();
    InputView inputView = new InputView(gameException);
    StrikeBallCount strikeBallCount = new StrikeBallCount();
    Player player = new Player();
    List<Integer> computer = new ArrayList<>();

    public void playBaseBallGameLoop() {
        int strike = 0;
        while (strike < 3) {
            playBaseBallGame();
            printStrikeBallCount();
            strike = strikeBallCount.getStrike();
        }
    }

    public void playBaseBallGame() {
        player.resetPlayerNumberStore();
        strikeBallCount.settingStrikeBallCount();
        player.settingPlayerNumber(inputPlayerNumber());
        computerNumberComparePlayerInputNumber(player, computer);
    }

    public int[] inputPlayerNumber() {
        outPutView.printRequestInputNumberMessage();
        return toIntArray(inputView.inputPlayerNumber());
    }

    public void settingComputerRandomNumbers() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public void computerNumberComparePlayerInputNumber(Player player, List<Integer> computer) {
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(player.getPlayerNumberAt(i))) {
                strikeBallCount.plusStrikeCount();
                continue;
            }
            if (computer.contains(player.getPlayerNumberAt(i))) {
                strikeBallCount.plusBallCount();
            }
        }
    }

    public int getStrikeCount() {
        return strikeBallCount.getStrike();
    }

    public int getBallCount() {
        return strikeBallCount.getBall();
    }

    public int getComputerRandomNumberSize() {
        return computer.size();
    }

    public void clearComputerRandomNumber() {
        computer.clear();
    }

    public void printStrikeBallCount() {
        outPutView.printStrikeBallCountMessage(getStrikeCount(), getBallCount());
    }

    public int[] toIntArray(String inputPlayerNumber) {
        int[] playerNumbers = new int[inputPlayerNumber.length()];
        for (int i = 0; i < inputPlayerNumber.length(); i++) {
            char storeNumber = inputPlayerNumber.charAt(i);
            gameException.playerNumberDuplicateException(playerNumbers, storeNumber);
            playerNumbers[i] = toInt(storeNumber);
        }
        return playerNumbers;
    }

    static int toInt(char storeNumber) {
        return storeNumber - '0';
    }
}

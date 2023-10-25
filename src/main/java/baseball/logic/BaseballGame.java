package baseball.logic;

import baseball.domain.Player;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> computerNumbers;
    private int strikeCount;
    private int ballCount;
    private int total;
    private Player player;
    public static String RESTART = "1";
    public static String EXIT = "2";
    public static int GAME_OVER_STRIKE = 3;
    public static int NUMBERS_LENGTH = 3;
    public static int NUMBERS_RANGE_START = 1;
    public static int NUMBERS_RANGE_END = 9;
    public static int COUNT_INIT_NUMBER = 0;



    public BaseballGame() {
        this.computerNumbers = new ArrayList<>();
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public String play() {
        OutputView.printGameIntroduction();
        ExtractComputerRandomNumber();

        player = new Player();
        String playerAnswer;
        while (true) {
            player.guessNumbers();
            giveScore(player.getNumbers());
            printScores();
            if (isGameOver()) {
                OutputView.printGameOver();
                playerAnswer = player.replayOrExit();
                if (playerAnswer.equals(RESTART)) {
                    return RESTART;
                } else if (playerAnswer.equals(EXIT)) {
                    return EXIT;
                } else {
                    // 예외 출력
                }
            }
        }
    }

    private List<Integer> ExtractComputerRandomNumber() {
        while (computerNumbers.size() < NUMBERS_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(NUMBERS_RANGE_START, NUMBERS_RANGE_END);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        System.out.println(String.valueOf(computerNumbers));
        return computerNumbers;
    }

    private void giveScore(List<Integer> playerNumbers) {
        resetCount();
        total = howMany(playerNumbers);
        strikeCount = countStrike(playerNumbers);
        ballCount = total - strikeCount;
    }
    public int howMany(List<Integer> playerNumbers) {
        int result = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (computerNumbers.contains(playerNumbers.get(i))) {
                result += 1;
            }
        }
        return result;
    }

    public int countStrike(List<Integer> playerNumbers){
        int strike = 0;
        for(int i = 0; i < playerNumbers.size(); i++){
            if(computerNumbers.get(i) == playerNumbers.get(i)){
                strike += 1;
            }
        }
        return strike;
    }

    private void resetCount() {
        this.strikeCount = COUNT_INIT_NUMBER;
        this.ballCount = COUNT_INIT_NUMBER;
    }
    private void printScores() {
        OutputView.printScores(total, ballCount, strikeCount);
    }
    private boolean isGameOver() {
        if (strikeCount == GAME_OVER_STRIKE) {
            return true;
        }else {
            return false;
        }
    }
}

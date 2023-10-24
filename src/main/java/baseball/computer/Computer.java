package baseball.computer;

import baseball.player.Guess;
import baseball.player.Player;

public class Computer {
    private static final boolean ROUND_ONGOING = true;
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ANSWER_RESULT = "3스트라이크";
    private static final String ROUND_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_TO_CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final Player player = new Player();
    private Answer answer;

    public void startGame() {
        System.out.println(GAME_START_MESSAGE);
        boolean continueGame = true;
        while (continueGame) {
            startRound();
            System.out.println(ASK_TO_CONTINUE_MESSAGE);
            continueGame = player.makeRestartFlag().toBoolean();
        }
    }

    private void startRound() {
        boolean roundOngoing = ROUND_ONGOING;
        generateAnswer();
        while (roundOngoing) {
            System.out.print(INPUT_NUMBER_MESSAGE);
            Guess playerGuess = player.makeGuess();
            String resultString = generateResultString(playerGuess);
            System.out.println(resultString);
            roundOngoing = isRoundOngoing(resultString);
        }
        System.out.println(ROUND_OVER_MESSAGE);
    }

    private void generateAnswer() {
        answer = new Answer();
    }

    private String generateResultString(Guess guess) {
        return new Result(guess, answer).toString();
    }

    private boolean isRoundOngoing(String resultString) {
        return !resultString.equals(ANSWER_RESULT);
    }
}

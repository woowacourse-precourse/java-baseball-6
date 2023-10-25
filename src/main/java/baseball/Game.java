package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    final String REPLAY_CHOICE_YES = "1";
    final String REPLAY_CHOICE_NO = "2";


    public Game() {

    }

    public void playGame() {
        System.out.println(MessageUtil.MSG_START_GAME);
        boolean isReplay = true;
        while (isReplay) {
            List<Integer> answer = GameLogic.createComputerAnswer();
            boolean isCorrect = false;
            while (!isCorrect) {
                System.out.println(MessageUtil.MSG_INPUT_NUMBER);
                List<Integer> guess = GameLogic.createUserGuess(Console.readLine().trim());
                GuessResult guessResult = GameLogic.checkGuess(answer, guess);
                System.out.println(guessResult.toString());
                if (GameLogic.isSuccessGuess(guessResult)) {
                    isCorrect = true;
                    System.out.println(MessageUtil.MSG_GUESS_SUCCESSFUL);
                }
            }
            System.out.println(MessageUtil.MSG_INPUT_REPLAY);
            String replayChoice = Console.readLine().trim();
            if (replayChoice.equals(REPLAY_CHOICE_YES)) {
                isReplay = true;
            } else if (replayChoice.equals(REPLAY_CHOICE_NO)) {
                isReplay = false;
            } else {
                throw new IllegalArgumentException("1 또는 2 를 입력해주세요.");
            }
        }
        System.out.println(MessageUtil.MSG_END_GAME);
    }
}

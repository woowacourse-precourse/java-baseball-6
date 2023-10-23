package baseball.game;

import baseball.type.MainSpeaker;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private boolean isReady;
    private String theAnswer;
    private boolean isAnswer;

    public void start() {
        System.out.println(MainSpeaker.GAME_START.getMainCall());
        isReady = true;
        while (isReady) {
            GameInitializer gameInitializer = new GameInitializer();
            theAnswer = gameInitializer.makeAnswer();
            System.out.println("answer: " + theAnswer);    // 테스트용

            isAnswer = false;
            while (!isAnswer) {
                play();
            }
        }
    }

    private void play() {
        System.out.println(MainSpeaker.GUESS_NUMBER.getMainCall());
        String guessNum = Console.readLine();
        GameException.validateInput(guessNum);
        Counter counter = new Counter();
        int resultCount = counter.strikeBallCount(guessNum, theAnswer);
        playAgain(resultCount);
    }

    private void playAgain(int resultCount) {
        if (resultCount == 3) {
            isAnswer = true;
            System.out.println(MainSpeaker.CORRECT_ANSWER.getMainCall());
            System.out.println(MainSpeaker.ONE_MORE_GAME.getMainCall());
            int playOrStop = Integer.parseInt(Console.readLine());
            if (playOrStop == 1) {
                isReady = true;
            } else if (playOrStop == 2) {
                isReady = false;
            }
        }
    }
}

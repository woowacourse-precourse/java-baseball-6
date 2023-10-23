package baseball.game;

import baseball.domain.Answer;
import baseball.type.MainSpeaker;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private boolean isReady;
    private String theAnswer;
    Answer answer = new Answer();

    public void start() {
        System.out.println(MainSpeaker.GAME_START.getMainCall());
        isReady = true;
        while (isReady) {
            theAnswer = makeAnswer();
            System.out.println("answer: " + theAnswer);    // 테스트용

            answer.setCorrect(false);
            while (!answer.isCorrect()) {
                play();
            }
        }
    }

    private String makeAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer.toString().replaceAll("[^0-9]", "");
    }

    private void play() {
        System.out.print(MainSpeaker.GUESS_NUMBER.getMainCall());
        String guessNum = Console.readLine();
        GameException.validateInput(guessNum);
        Counter counter = new Counter();
        int resultCount = counter.strikeBallCount(guessNum, theAnswer);
        playAgain(resultCount);
    }

    private void playAgain(int resultCount) {
        if (resultCount == 3) {
            answer.setCorrect(true);
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

package baseball.game;

import baseball.type.MainSpeaker;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public void welcome() {
        System.out.println(MainSpeaker.GAME_START.getMainCall());
    }

    public void play() {
        List<Integer> theAnswer = makeAnswer();
        System.out.println("answer: " + theAnswer);    // 테스트용

        do {
            this.guessNumber();
        } while (!this.isAnswer(theAnswer));
    }

    private boolean isAnswer(List<Integer> answer) {
        String guessNum = Console.readLine();
        GameException.validateInput(guessNum);

        Counter counter = new Counter();
        int resultCount = counter.countStrikeBall(guessNum, answer);
        if (resultCount == 3) {
            System.out.println(MainSpeaker.CORRECT_ANSWER.getMainCall());
            System.out.println(MainSpeaker.ONE_MORE_GAME.getMainCall());
            return true;
        }
        return false;
    }

    private void guessNumber() {
        System.out.print(MainSpeaker.GUESS_NUMBER.getMainCall());
    }

    public boolean isAgain(String input) {
        return input.equals("1");
    }

    private List<Integer> makeAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}

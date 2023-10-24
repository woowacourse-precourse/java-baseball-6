package baseball.game;

import baseball.domain.Answer;
import baseball.domain.User;
import baseball.type.MainSpeaker;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public void welcome(User user) {
        System.out.println(MainSpeaker.GAME_START.getMainCall());
        user.setReady(true);
    }
    public void goodBye(User user) {
        System.out.println(MainSpeaker.GAME_END.getMainCall());
        user.setReady(false);
    }

    public void play(User user) {
        List<Integer> theAnswer = makeAnswer();
        System.out.println("answer: " + theAnswer);    // 테스트용
        Answer answer = new Answer();
        while (!answer.isCorrect()) {
            check(user, theAnswer, answer);
        }
    }

    public void check(User user, List<Integer> theAnswer, Answer answer) {
        System.out.print(MainSpeaker.GUESS_NUMBER.getMainCall());
        String guessNum = Console.readLine();
        GameException.validateInput(guessNum);
        Counter counter = new Counter();
        int resultCount = counter.strikeBallCount(guessNum, theAnswer);
        if (resultCount == 3) {
            answer.setCorrect(true);
            System.out.println(MainSpeaker.CORRECT_ANSWER.getMainCall());
            System.out.println(MainSpeaker.ONE_MORE_GAME.getMainCall());
            String input = Console.readLine();
            if (input.equals("1")) {
                user.setReady(true);
            } else {
                goodBye(user);
            }
        }
    }

    public List<Integer> makeAnswer() {
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

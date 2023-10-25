package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
public class Game {
    private List<Integer> answer;

    public Game() {
        answer = new ArrayList<>();
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        setRandomAnswer();
        boolean retry = true;
        while (retry) {
            System.out.println("숫자를 입력해주세요 : ");
            InputNumber input = new InputNumber(Console.readLine());
            input.makeResult(answer);
            input.displayResult();
            retry = isRunning(input);
        }
    }

    private void setRandomAnswer() {
        answer.clear();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    private boolean isRunning(InputNumber input) {
        if (!input.getCorrect())
            return true;
        boolean retry = askRetry();
        if (retry)
            setRandomAnswer();
        return retry;
    }

    private boolean askRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (!input.equals("1") && !input.equals("2"))
            throw new IllegalArgumentException("Invalid input");
        return input.equals("1");
    }
}

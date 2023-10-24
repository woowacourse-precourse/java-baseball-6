package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private final int inputSize;
    private List<Integer> answer;

    public Player(int inputSize) {
        this.inputSize = inputSize;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void infer() {
        String input = Console.readLine();
        Validator.validateAnswer(input, inputSize);

        answer = new ArrayList<>(inputSize);
        for (char ch : input.toCharArray()) {
            answer.add((ch - '0'));
        }
    }

    public boolean playNextRound() {
        String nextRound = Console.readLine();
        Validator.validateNextRound(nextRound);

        return nextRound.equals("1");
    }
}

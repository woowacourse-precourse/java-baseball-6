package baseball.phase.impl;

import baseball.evaluation.result.EvalResult;
import baseball.game.BaseballGame;
import baseball.phase.Phase;
import baseball.phase.PhaseID;
import java.util.ArrayList;
import java.util.List;

public class GuessPhase implements Phase {
    private BaseballGame baseballGame;

    public GuessPhase() {
    }

    @Override
    public void display() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void validateInput(String input) {
        boolean[] visited = new boolean[10];
        int inputLength = input.length();

        for (int i = 0; i < inputLength; i++) {
            char ch = input.charAt(i);
            if ('1' <= ch && ch <= '9') {
                if (visited[ch - '0']) {
                    throw new IllegalArgumentException();
                }
                visited[ch - '0'] = true;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public PhaseID action(String input) {
        List<Integer> guess = extractGuess(input);
        EvalResult result = this.baseballGame.getEvaluator().evaluate(guess);
        result.printResult();
        if (result.isClear()) {
            return PhaseID.MENU;
        }
        return PhaseID.GUESS;
    }

    @Override
    public void setGame(BaseballGame game) {
        this.baseballGame = game;
    }

    private List<Integer> extractGuess(String input) {
        List<Integer> result = new ArrayList<>();
        int inputLength = input.length();

        for (int i = 0; i < inputLength; i++) {
            char ch = input.charAt(i);
            result.add(ch - '0');
        }
        return result;
    }
}

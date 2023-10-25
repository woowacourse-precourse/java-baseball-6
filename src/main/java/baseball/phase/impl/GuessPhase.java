package baseball.phase.impl;

import baseball.evaluation.result.EvalResult;
import baseball.game.BaseballGame;
import baseball.phase.Phase;
import baseball.phase.PhaseID;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GuessPhase implements Phase {
    private BaseballGame baseballGame;
    private boolean isFinished;

    public GuessPhase() {
        isFinished = false;
    }

    @Override
    public PhaseID nextPhase() {
        return null;
    }

    @Override
    public void play() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> guess = extractGuess(input);
        EvalResult result = this.baseballGame.getEvaluator().evaluate(guess);
        result.printResult();
    }

    @Override
    public void setGame(BaseballGame game) {
        this.baseballGame = game;
    }

    private List<Integer> extractGuess(String input) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[10];
        input = input.trim();
        int inputLength = input.length();

        for (int i = 0; i < inputLength; i++) {
            char ch = input.charAt(i);
            if ('1' <= ch && ch <= '9') {
                if (visited[ch - '0']) {
                    throw new IllegalArgumentException();
                }
                result.add(ch - '0');
                visited[ch - '0'] = true;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return result;
    }
}

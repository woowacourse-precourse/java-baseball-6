package baseball.controller;

import baseball.domain.Judgement;
import baseball.domain.Result;
import baseball.io.Input;
import baseball.io.Output;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameController {
    Input input = new Input();
    Judgement judge = new Judgement();
    Output output = new Output();

    public void playGame() {
        System.out.println("야구 게임을 시작합니다.");

        boolean run = true;

        while (run) {
            List<Integer> opponent = createOpponent();
            System.out.println(opponent);
            guessTilSuccess(opponent);
            run = restart();
        }

        System.out.println("게임 종료");
    }

    private List<Integer> createOpponent() {
        Set<Integer> opponent = new HashSet<Integer>();

        while (opponent.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            opponent.add(randomNumber);
        }
        return setIntoList(opponent);
    }

    private void guessTilSuccess(List<Integer> opponent) {
        System.out.print("숫자를 입력해주세요 : ");

        Result resultData = judge.judgement(opponent, getInput(3));
        //Recursive
        if (output.printResult(resultData)) {
            guessTilSuccess(opponent);
        }
    }

    private boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return getInput(1).get(0) == 1;
    }

    private List<Integer> getInput(int inputType) {
        return input.playerInput(inputType);
    }

    private List<Integer> setIntoList(Set<Integer> target) {
        return target.stream().toList();
    }
}

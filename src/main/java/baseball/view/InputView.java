package baseball.view;

import baseball.validation.InvalidExitException;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class InputView {
    InvalidExitException invalidExitException = new InvalidExitException();

    public void printStartGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void printAskInputNumber() {

    }
    public void printAskGameEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public List<Integer> inputNumber() {
        try {
            System.out.println("숫자를 입력해주세요 : ");
            String picks = Console.readLine();

            return Arrays.stream(picks.split(""))
                    .map(Integer::parseInt)
                    .collect(toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }


//        return picksToArray;
    }

    public String askGameEnd() {
        String gameRestart = Console.readLine();
//        invalidExitException.checkValidChoice(gameRestart);
        return gameRestart;
    }
}

package baseball.controller;

import baseball.domain.Numbers;
import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBallGame {

    private static final String CONTINUE_GAME_SIG = "1";
    private static final String END_GAME_SIG = "2";
    private final InputView view = new InputView();


    public void run() {
        view.printStart();

        boolean continueGame = Boolean.TRUE;

        while (continueGame) {
            Computer computer = Computer.create();

            startGame(computer);

            view.printFinish();

            continueGame = isContinueGame(readLine());
        }
    }

    private void startGame(Computer computer) {
        while (true) {
            view.printNumberInput();
            Numbers inputNumbers = Numbers.create(enterNumberList());

            Result result = computer.calculateResult(inputNumbers);
            view.printResult(result);

            if (result.isFinish()) {
                break;
            }
        }
    }

    private List<Integer> enterNumberList() {
        String input = readLine();
        validateIsNumber(input);

        return Arrays.stream(input.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

    }

    private void validateIsNumber(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }
    }

    private boolean isContinueGame(String continueGameInput) {
        if (continueGameInput.equals(CONTINUE_GAME_SIG)) {
            return true;
        }
        if (continueGameInput.equals(END_GAME_SIG)) {
            return false;
        }

        throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
    }

}

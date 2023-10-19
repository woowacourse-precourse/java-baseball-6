package baseball.controller;

import baseball.domain.Numbers;
import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.view.Output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBallGame {

    private static final String CONTINUE_GAME_SIG = "1";
    private static final String END_GAME_SIG = "2";


    public void run() {
        Output.printStart();

        boolean continueGame = Boolean.TRUE;

        while (continueGame) {
            Computer computer = Computer.create();

            startGame(computer);

            Output.printFinish();

            continueGame = isContinueGame(readLine());
        }
    }

    private void startGame(Computer computer) {
        while (true) {
            Output.printNumberInput();
            Numbers inputNumbers = Numbers.create(enterNumberList());

            Result result = computer.calculateResult(inputNumbers);
            Output.printResult(result);

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

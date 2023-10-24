package game;

import camp.nextstep.edu.missionutils.Console;
import service.Result;

import java.util.List;

import static baseball.Application.TOTAL_CARDS;
import static repository.Computer.getComputerPicks;
import static service.Result.getResult;
import static service.Result.printResult;
import static validation.Validator.validateInput;
import static validation.Validator.validateOneOrTwo;

public class Game {
    public void play() {
        List<Integer> computer = getComputerPicks();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            String input = Console.readLine();
            validateInput(input);

            Result result = getResult(computer, input);
            printResult(result);

            if (isThreeStrikes(result)) {
                if (checkIfShouldRestart()) {
                    computer = getComputerPicks();
                } else break;
            }
        }
    }

    private boolean isThreeStrikes(Result result) {
        if (result.getStrikes() == TOTAL_CARDS) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private boolean checkIfShouldRestart() {
        final String RESTART = "1";

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        validateOneOrTwo(input);

        return input.equals(RESTART);
    }
}

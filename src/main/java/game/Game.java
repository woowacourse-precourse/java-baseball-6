package game;

import camp.nextstep.edu.missionutils.Console;
import service.Result;

import java.util.List;

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

            computer = checkThreeStrikes(result, computer);
            if (computer == null) break;
        }
    }

    private List<Integer> checkThreeStrikes(Result result, List<Integer> computer) {
        final String RESTART = "1";
//        final String QUIT = "2";

        if (result.getStrikes() == computer.size()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();

            validateOneOrTwo(input);

            return input.equals(RESTART) ? getComputerPicks() : null;
        }
        return computer;
    }
}

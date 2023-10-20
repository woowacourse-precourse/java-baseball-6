package baseball.controller;

import baseball.model.ComputerNumberGenerator;
import baseball.model.Game;
import baseball.view.RestartInput;
import baseball.view.UserInput;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    public void run() {
        Game game;
        ComputerNumberGenerator generator = new ComputerNumberGenerator();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            UserInput userInput = new UserInput(input);
            game = new Game(generator, userInput);
            String result = game.play();
            System.out.println(result);
            if (result.equals(Game.endGame)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                RestartInput restartInput = new RestartInput(Console.readLine());
                if (restartInput.getRestartInput() == 1) {
                    generator = new ComputerNumberGenerator();
                } else {
                    break;
                }
            }
        }

    }
}

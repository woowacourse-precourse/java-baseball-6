package baseball;

import static baseball.Config.NUMBER_LENGTH;

public class Game {


    public void start() {
        String computerNumber, playerNumber;

        Player player = new Player();
        ComputerNumber computer = new ComputerNumber();
        Hint hint = new Hint();

        computerNumber = computer.pickTargetNumber(NUMBER_LENGTH);

        do {
            playerNumber = player.inputNumber(NUMBER_LENGTH);

            hint.reset();
            hint.updateHint(playerNumber, computerNumber);
            hint.printHint();
        } while (!hint.checkClear());
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    }
}

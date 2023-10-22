package baseball;

public class BaseballGame {

    public static void start() {
        Computer computer = new Computer();
        computer.makeNumber();
        Computer.resetState();

        Player player = new Player();
        while (Computer.getStateStrike() != 3) {
            Computer.resetState();
            String playerNumber = player.inputNumber();

            computer.checkNumber(Computer.computerNumber, playerNumber);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (Player.gamePlayOrNot()) {
            BaseballGame.start();
        } else {
            System.out.println("게임을 종료합니다.");
            System.exit(0);
        }
    }

}

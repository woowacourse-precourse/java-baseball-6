package baseball;

public class BaseballGame {

    public static void start() {
        Computer computer = new Computer();
        computer.makeNumber();

        Player player = new Player();
        while (Computer.getStateStrike() != 3) {
            // 스트라이크, 볼, 낫싱 횟수 초기화
            Computer.resetState();
            // 만약 입력한 값이 조건에 만족하지 않으면 예외 발생 후 프로그램 종료
            if (!player.inputNumber()) {
                return;
            };
            computer.checkNumber(Computer.computerNumber, Player.playerNumber);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (Player.gamePlayOrNot()) {
            player.resetPlayerNumber();
            Computer.resetState();
            Computer.resetComputerNumber();
            BaseballGame.start();
        } else {
            System.out.println("게임을 종료합니다.");
            return;
        }
    }

}

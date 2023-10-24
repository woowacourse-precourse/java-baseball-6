package baseball;

public class BaseballGame {

    public static void start() {
        // 컴퓨터가 갖고 있는 랜덤 숫자 생성
        Computer computer = new Computer();
        computer.makeNumber();

        Player player = new Player();
        while (computer.getStateStrike() != 3) {
            // 스트라이크, 볼, 낫싱 횟수 초기화
            computer.resetState();
            // 만약 입력한 값이 조건에 만족하지 않으면 예외 발생 후 프로그램 종료
            if (!player.inputNumber()) {
                return;
            };
            computer.checkNumber(computer.computerNumber, player.playerNumber);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        // 게임 재시작 시 컴퓨터 숫자와 플레이어 입력값, 상태값 모두 초기화
        if (Player.gamePlayOrNot()) {
            player.resetPlayerNumber();
            computer.resetState();
            computer.resetComputerNumber();
            BaseballGame.start();
        } else {
            System.out.println("게임을 종료합니다.");
            return;
        }
    }

}

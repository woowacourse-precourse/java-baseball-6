package baseball;

public class Game {
    private Player player;
    private Computer computer;

    Game(Player player) {
        this.player = player;
    }

    public void startGame() {
        do {
            System.out.println("숫자 야구 게임을 시작합니다.");

            this.computer = new Computer(); // 위치 옮김

            comparePlayerNumberAndComputerNumber();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            player.setGameRestartInput();

            if (player.getInput().equals("2")) {
                break;
            }

        } while(player.getInput().equals("1"));

    }

    private void comparePlayerNumberAndComputerNumber() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            player.setThreeNumbersInput();

            // Computer computer = new Computer(); // 여기에 선언하면 순서가 이상해짐
            Hint hint = new Hint(player.getInput(), computer.getRandomNumbers());
            hint.calculateTheNumberOfBallAndStrike();
            System.out.println(hint);

            if (hint.getStrikeCounter() == 3) {
                break;
            }
        }
    }

}

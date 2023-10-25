package baseball;

public class Game {

    private Computer computer;
    private Player player;

    public Game(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        init();
        loop();
    }

    private void init() {
        computer.generateRandomNumbers();
        player.setNumbers(new InputHandler().getPlayInput());
    }

    private void loop() {
        while (true) {
            if (handleGameOver()){
                return;
            }
            player.setNumbers(new InputHandler().getPlayInput());
        }
    }

    private boolean handleGameOver() {
        Umpire umpire = new Umpire(computer.getNumbers(), player.getNumbers());
        if (umpire.isGameSet()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            computer.generateRandomNumbers();
            if (!restartOrExitGame()){
                return true;
            }
        }
        return false;
    }
}

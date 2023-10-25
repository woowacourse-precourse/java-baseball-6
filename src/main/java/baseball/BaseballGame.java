package baseball;

public class BaseballGame {
    private boolean running;
    private final Computer computer;
    private final Player player;

    public BaseballGame() {
        this.running = true;
        this.computer = new Computer();
        this.player = new Player();
    }

    // 게임 시작
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.chooseRandomValues();
        while (running) {
            run();
        }

        // 게임 종료 or 재시작 선택
        isRestart();
    }

    // 게임 실행 중
    private void run() {
        System.out.print("숫자를 입력해주세요. : ");
        player.chooseValues();
        ResultDTO result = computer.compare(player.getValues());
        if (result.getStrike() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            running = false;
        }
    }

    // 게임 재시작
    private void isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        running = player.isRestart();
        if (running) {
            start();
        }
    }
}

package baseball;

public class Application {
    private boolean isPlaying = true;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        computer.setComputerNum();

        User user = new User();
        Application app = new Application();
        app.gamePlay();
    }

    public void gamePlay() {
        User user = new User();
        while (isPlaying) {
            user.setUserNum();
        }
    }
}

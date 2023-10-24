package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        Player player = new Player();
        boolean exitFlag = false;
        while (!exitFlag) {
            computer.run();
            exitFlag = player.newGame();
        }
        System.out.println("프로그램 종료");
    }

}

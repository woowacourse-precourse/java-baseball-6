package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        Computer computer = new Computer();
        BaseballGameManger baseballGameManger = new BaseballGameManger(user, computer);
        baseballGameManger.playBaseballGame();

        while (true) {
            int choice = baseballGameManger.menuChoice();
            if (choice == 1) {
                baseballGameManger.playBaseballGame();
            } else if (choice == 2) {
                System.out.println("게임을 종료합니다. 감사합니다!");
                break;
            }
        }
    }
}

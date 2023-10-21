package baseball;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        GameManager gameManager = new GameManager();
        User user = new User();
        Computer computer = new Computer();
        startMessage();
        while (true) {
            String result = startGame(user, computer, gameManager);
            System.out.println(result);
            if (gameManager.isCompleted(result)) {
                endMessage();
                restartGameMessage();
                if (!gameManager.doGameAgain(Integer.parseInt(user.readLine()),computer)) break;
            }
        }
    }

    static void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static String startGame(User user, Computer computer, GameManager gameManager) {
        System.out.print("숫자를 입력해주세요 : ");
        user.readLine();
        return gameManager.doGame(computer.number, user.number);

    }

    static void endMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    static void restartGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

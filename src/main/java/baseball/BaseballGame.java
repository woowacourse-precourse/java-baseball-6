package baseball;

public class BaseballGame {
    private boolean flag;
    private String input;
    private Computer computer;
    private User user;

    BaseballGame() {
        flag = false;
        computer = new Computer();
        user = new User();
    }
    public void Game() {
        while (!flag) {
            startGame();
            inGame();
            endGame();
        }
    }

    private void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.setAnswer();
    }

    private void inGame() {
        do {
            System.out.print("숫자를 입력해주세요 : ");
            input = user.getInput();
        } while(!computer.checkAnswer(input));
    }

    private void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Boolean result = user.checkNextGame();
        if (result)
            flag = true;
    }
}

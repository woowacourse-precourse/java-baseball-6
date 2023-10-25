package baseball;


public class Game {
    private boolean quit;
    private String input;
    private Computer computer;
    private User user;

    enum QuitInput {
        RESTART("1"),
        QUIT("2");

        private String num;

        private QuitInput(String num) {
            this.num = num;
        }

        public String getQuitInput() {
            return num;
        }
    }

    Game() {
        quit = false;
        computer = new Computer();
        user = new User();
    }

    public void doGame() {
        do {
            startGame();
            inGame();
            endGame();
        } while (!quit);
    }

    private void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.makeAnswer();
    }

    private void inGame() {
        do {
            System.out.print("숫자를 입력해주세요 : ");
            input = user.getGameInput();
        } while (!computer.checkAnswer(input));
    }

    private void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = user.getQuitInput();
        if (input.equals(QuitInput.QUIT.getQuitInput())) {
            quit = true;
        }
    }
}

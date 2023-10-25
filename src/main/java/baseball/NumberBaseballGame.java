package baseball;

public class NumberBaseballGame {
    private ComputerPlayer computerPlayer;
    private UserInput userInput;
    private GameRestartOption restartOption;

    private boolean gameWon;

    public NumberBaseballGame() {
        computerPlayer = new ComputerPlayer();
        userInput = new UserInput();
        restartOption = new GameRestartOption(); // GameRestartOption 초기화 추가
        gameWon = false;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            int[] computerNumber = computerPlayer.generateRandomNumber();
            System.out.println("컴퓨터가 숫자를 생성했습니다. 게임을 시작합니다.");

            while (!gameWon) {
                System.out.print("숫자를 입력하세요 (1-9 중복 없이): ");
                String input = userInput.getInput();

                try {
                    int[] userGuess = userInput.validateAndParseInput(input);
                    int[] result = computerPlayer.checkGuess(userGuess, computerNumber);
                    computerPlayer.displayResult(result);

                    if (result[0] == 3) {
                        gameWon = true;
                        System.out.println("게임에서 승리하셨습니다! 컴퓨터의 숫자는 " + computerNumber[0] + computerNumber[1] + computerNumber[2] + " 입니다.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("잘못된 입력입니다. 1-9 중복 없이 다시 시도하세요.");
                }
            }

            // 게임 재시작 또는 종료 확인
            if (!restartOption.askForRestart()) {
                break; // 게임 종료
            } else {
                gameWon = false; // 게임 재시작
            }
        } while (true);
    }

    public static void main(String[] args) {
        NumberBaseballGame game = new NumberBaseballGame();
        game.startGame();
    }
}

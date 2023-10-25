package baseball;

public class GameManager {
    private final User user;
    private final Computer computer;
    private Pair<Integer, Integer> userGuessJudgement;

    public GameManager() {
        this.user = new User();
        this.computer = new Computer();
        this.userGuessJudgement = null;
    }

    private String getUserInputVal() {
        return user.returnUserInputVal();
    }

    private boolean checkGameEnd() {
        // 유저가 승리했으면 Game End
        return user.returnWinning();
    }

    private boolean validateUserInput(String userInput) {
        // 인게임에서 사용자 입력값의 길이가 3이 아니면 false
        if (userInput.length() != 3) {
            return false;
        }

        try {
            int userNumber = Integer.parseInt(userInput);
            // userNumber가 -99와 같이 음의 정수이면 false
            if (userNumber < 0) {
                return false;
            }
            // userNumber 자릿수 중에 하나라도 0이면 false
            while (userNumber > 0) {
                if (userNumber % 10 == 0) {
                    return false;
                }
                userNumber /= 10;
            }

        } catch (NumberFormatException error) {
            // 인게임에서 사용자 입력값의 파싱 결과가 숫자가 아니면 false
            return false;
        }

        return true;
    }

    private boolean validateUserInputForRestartGame(String userInput) {
        return userInput.equals("1") || userInput.equals("2");
    }

    private void printComputerGeneratedNumbers() {
        System.out.printf("컴퓨터가 생성한 수 : ");
        for (int number : computer.getNumbers()) {
            System.out.printf("%d", number);
        }
        System.out.printf("\n");
    }

    private void printGameStartMessage() {
        System.out.printf("숫자 야구 게임을 시작합니다.\n");
    }

    private void printUserInputPrompt() {
        System.out.printf("숫자를 입력해주세요 : ");
    }

    private void printGameRestartMessage() {
        System.out.printf("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        System.out.printf("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
    }

    private boolean checkGuessStageEnd() {
        return userGuessJudgement.getFirst() == 3;
    }

    private void setUpBeforeRestartGame() {
        user.lose();
        computer.generateRandomNumbers();
        // 디버깅 용
        printComputerGeneratedNumbers();
    }

    public void runGame() {
        // 디버깅 용
        printComputerGeneratedNumbers();
        // 게임 시작 메시지 출력
        printGameStartMessage();
        // 게임 종료를 확인할 때까지 게임 진행
        while (!checkGameEnd()) {

            printUserInputPrompt();
            // 사용자 입력값이 유효하지 않으면 예외 발생
            if (!validateUserInput(user.readConsoleInput())) {
                throw new IllegalArgumentException();
            }
            userGuessJudgement = computer.judgeUserGuess(this.getUserInputVal());
            computer.printUserGuessJudgmentResult(userGuessJudgement);
            if (checkGuessStageEnd()) {
                user.win();
                printGameRestartMessage();
                if (!validateUserInputForRestartGame(user.readConsoleInput())) {
                    throw new IllegalArgumentException();
                }
                switch (this.getUserInputVal()) {
                    case "1":
                        this.setUpBeforeRestartGame();
                        continue;
                    case "2":
                        // 게임 종료
                        continue;
                    default:
                        throw new IllegalArgumentException();
                }
            }

        }
    }
}
package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}

class User {
    private String input;
    private boolean winning;

    public User() {
        this.input = "";
        this.winning = false;
    }

    public void win() {
        winning = true;
    }

    public void lose() {
        winning = false;
    }

    public boolean returnWinning() {
        return winning;
    }

    public String readConsoleInput() {
        input = Console.readLine();
        return input;
    }

    public String returnUserInputVal() {
        return input;
    }
}

class Computer {
    private final List<Integer> numbers;


    public Computer() {
        this.numbers = new ArrayList<Integer>();
        // 1~9까지 서로 다른 임의의 수 3개를 생성하여 저장
        generateRandomNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    public Pair<Integer, Integer> judgeUserGuess(String userGuess) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < userGuess.length(); i++) {
            int userGuessNumber = userGuess.charAt(i) - '0';
            if (numbers.get(i) == userGuessNumber) {
                strike++;
            } else if (numbers.contains(userGuessNumber)) {
                ball++;
            }
        }
        return new Pair<Integer, Integer>(strike, ball);
    }

    public void printUserGuessJudgementResult(Pair<Integer, Integer> userGuessJudgement) {
        if (userGuessJudgement.getFirst() == 0 && userGuessJudgement.getSecond() == 0) {
            System.out.printf("낫싱\n");
        } else if (userGuessJudgement.getFirst() == 0) {
            System.out.printf("%d볼\n", userGuessJudgement.getSecond());
        } else if (userGuessJudgement.getSecond() == 0) {
            System.out.printf("%d스트라이크\n", userGuessJudgement.getFirst());
        } else {
            System.out.printf("%d볼 %d스트라이크\n", userGuessJudgement.getSecond(), userGuessJudgement.getFirst());
        }
    }

    public void generateRandomNumbers() {
        // 만약 numbers가 비어있지 않다면 비워준다.
        if (!numbers.isEmpty()) {
            numbers.clear();
        }
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

}

class GameManager {
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
        if (userInput.equals("1") || userInput.equals("2")) {
            return true;
        }
        return false;
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
            computer.printUserGuessJudgementResult(userGuessJudgement);
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

public class Application {

    public static void main(String[] args) {
        final GameManager gameManager = new GameManager();
        gameManager.runGame();
    }
}

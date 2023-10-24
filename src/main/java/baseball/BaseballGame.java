package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class BaseballGame {
    private int ball;
    private int strike;
    private static final String CONTINUE = "1";
    private static final String QUIT = "2";
    private static String isContinue = CONTINUE;

    BaseballGame() {
    }

    public void init() {
        this.ball = 0;
        this.strike = 0;
    }

    public List<Integer> getRandomNum() {
        RandomNum RN = new RandomNum();
        return RN.getComputerNumbers();
    }

    public void checkInput(String userNumber) {
        Array.checkArrayNumber(userNumber);
        Array.checkArrayLength(userNumber);
        Array.checkRange(userNumber);
    }

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine(); // 서로 다른 3개의 숫자 입력
    }

    public void getAnswer(List<Integer> computer, List<Integer> userNum) {
        // 컴퓨터가 만든 서로 다른 랜덤 3자리 수 computer 와 사용자 입력을 받은 서로 다른 3자리 수 userNum 비교
        for (int i = 0; i < computer.size(); i++) {
            if (userNum.get(i).equals(computer.get(i))) { // 같은 수가 같은 자리에 있으면 스트라이크
                this.strike++;
            } else if (userNum.contains(computer.get(i))) {
                this.ball++;
            }
        }
        printAnswer(); // 출력
    }

    public String startNewGame() {
        String userInput;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        userInput = readLine();
        Array.checkArrayNumber(userInput);
        Array.checkOneOrTwo(userInput);

        if (userInput.equals("2")) { // 1이면 게임 다시
            // 게임 다시
            return QUIT;
        }
        return CONTINUE;
    }

    public boolean isAllStrike() {
        if (strike == 3 && ball == 0) { // 3개의 숫자를 모두 맞히면
            return true;
        }
        return false;
    }

    public void printAnswer() {

        if (strike == 0 && ball == 0) { // 같은 수가 전혀 없으면
            System.out.println("낫싱");
        }
        if (strike == 3 && ball == 0) { // 3개의 숫자를 모두 맞히면
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            isContinue = startNewGame();
        }
        // 볼만 있을 경우, 스트라이크만 있을 경우, 볼, 스트라이크 둘 다 있으면
        if (ball > 0) {
            System.out.print(ball + "볼 ");
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            System.out.println();
        }
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            game();
        } while (isContinue.equals(CONTINUE));
    }

    public void game() {
        String userNumber;
        List<Integer> computer = this.getRandomNum();

        do {
            init();

            userNumber = inputNumber();
            checkInput(userNumber);

            List<Integer> userNum = Array.checkForDuplicateNumbers(userNumber);

            getAnswer(computer, userNum); // 볼, 스트라이크 세기
        } while (!isAllStrike());

    }
}

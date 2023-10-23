package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballGame {
    private int ball = 0;
    private int strike = 0;
    private String userNumber;
    private String userInput;
    private static final String CONTINUE = "1";
    private static final String QUIT = "2";

    BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void init() {
        this.ball = 0;
        this.strike = 0;
    }

    public void getRandomNum(List<Integer> computer) {
        RandomNum RN = new RandomNum(computer);
    }

    public void checkInput(String userNumber) {
        // 3자리 수 초과 입력
        Array.checkArrayLength(userNumber);
        // 0이 포함된 경우
        Array.checkZeroInArray(userNumber);
        // 숫자가 아닌 경우
        Array.checkArrayNumber(userNumber);
    }

    public void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        this.userNumber = readLine(); // 서로 다른 3개의 숫자 입력
    }

    public void getAnswer(List<Integer> computer, List<Integer> userNum) {
        // 컴퓨터가 만든 서로 다른 랜덤 3자리 수 computer 와 사용자 입력을 받은 서로 다른 3자리 수 userNum 비교
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(userNum.get(i))) { // 같은 수가 같은 자리에 있으면 스트라이크
                this.strike++;
                continue;
            }
            if (userNum.contains(computer.get(i))) {
                this.ball++;
            }
        }
    }

    public String startNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        this.userInput = readLine();
        Array.checkArrayNumber(this.userInput);
        Array.checkOneOrTwo(this.userInput);

        if (this.userInput.equals("1")) { // 1이면 게임 다시
            // 게임 다시
            return CONTINUE;
        } else if (this.userInput.equals("2")) { // 2이면 게임 종료
            // 게임 종료
            return QUIT;
        }
        return null;
    }

    public void printAnswer() {
        String isContinue = CONTINUE;

        if (strike == 0 && ball == 0) { // 같은 수가 전혀 없으면
            System.out.println("낫싱");
        }
        if (strike == 3 && ball == 0) { // 3개의 숫자를 모두 맞히면
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            isContinue = startNewGame();
        }
        // 볼만 있을 경우
        // 스트라이크만 있을 경우
        // 볼, 스트라이크 둘 다 있으면
        if (ball > 0) {
            System.out.print(ball + "볼 ");
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            System.out.println();
        }

        if (Objects.equals(isContinue, "1")) {
            play();
        } else if ((Objects.equals(isContinue, "2"))) {
            return;
        }

    }

    public void play() {
        init();

        //서로 다른 random 3자리 수 만들기
        List<Integer> computer = new ArrayList<>();
        this.getRandomNum(computer);

        // 입력
        this.inputNumber();

        // 입력 확인
        this.checkInput(this.userNumber);

        // 같은 수 포함
        List<Integer> userNum = new ArrayList<>();
        Array.checkForDuplicateNumbers(userNum, this.userNumber);
        //System.out.println(userNum);

        // 볼, 스트라이크 세기
        this.getAnswer(computer, userNum);
        // 출력
        this.printAnswer();

    }
}

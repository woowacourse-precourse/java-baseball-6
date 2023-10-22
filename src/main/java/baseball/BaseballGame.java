package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private int ball = 0;
    private int strike = 0;

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

    public void getAnswer(List<Integer> computer, List<Integer> userNum) {
        // 컴퓨터가 만든 서로 다른 랜덤 3자리 수 computer 와 사용자 입력을 받은 서로 다른 3자리 수 userNum 비교
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(userNum.get(i))) { // 같은 수가 같은 자리에 있으면 스트라이크
                this.strike++;
            } else {
                for (int j = 0; j < userNum.size(); j++) {
                    if (j == i) {
                        continue; // 스트라이크
                    }
                    if (computer.get(i).equals(userNum.get(j))) { // 같은 수가 다른 자리에 있으면 볼
                        this.ball++;
                    }
                }
            }
        }
    }

    public void startNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = readLine();
        Array.checkOneOrTwo(userInput);

        if (userInput.equals("1")) { // 1이면 게임 다시
            // 게임 다시
            play();
        } else if (userInput.equals("2")) { // 2이면 게임 종료
            // 게임 종료
            return;
        }
    }

    public void printAnswer() {
        if (strike == 0 && ball == 0) { // 같은 수가 전혀 없으면
            System.out.println("낫싱");
        } else if (strike == 3) { // 3개의 숫자를 모두 맞히면
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            startNewGame();
        } else if (ball > 0 && strike == 0) { // 볼만 있을 경우
            System.out.println(ball + "볼");
        } else if (strike > 0 && ball == 0) { // 스트라이크만 있을 경우
            System.out.println(strike + "스트라이크");
        } else { // 볼, 스트라이크 둘 다 있으면
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        play();

    }

    public void play() {
        init();

        //서로 다른 random 3자리 수 만들기
        List<Integer> computer = new ArrayList<>();
        this.getRandomNum(computer);

        // 입력
        String userNumber = readLine(); // 서로 다른 3개의 숫자 입력

        // 입력 확인
        this.checkInput(userNumber);

        // 같은 수 포함
        List<Integer> userNum = new ArrayList<>();
        Array.checkForDuplicateNumbers(userNum, userNumber);
        System.out.println(userNum);

        // 볼, 스트라이크 세기
        this.getAnswer(computer, userNum);
        // 출력
        this.printAnswer();


    }
}

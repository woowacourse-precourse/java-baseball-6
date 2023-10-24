package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 상대방(컴퓨터) 숫자 객체
 */
class ComputerNumber {
    private List<Integer> computer;

    public List<Integer> makeComputer() {
        computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}

public class Application {

    /**
     * 입력 받은 수 검증
     * @param input
     * @return true || false
     */
    public boolean inputCheckAll(String input) {
        //3자리 수가 맞는지 확인
        if (!inputCheckLength(input)) {
            return false;
        }
        //다른 문자가 아닌, 숫자인지 확인
        if (!inputCheckNumber(input)) {
            return false;
        }
        //서로 다른 수가 맞는지 확인
        if (!inputCheckDifferent(input)) {
            return false;
        }

        return true;
    }

    /**
     * 입력 값에 대한 결과 출력
     * @param computer
     * @param input
     * @return
     */
    public String sameCheck(List<Integer> computer, String input) {
        int inputNumber = Integer.valueOf(input);
        Map<String, Integer> B_S = new HashMap<>();
        final String ball = "Ball";
        final String strike = "Strike";
        int inputNum;

        B_S.put(ball, 0);
        B_S.put(strike, 0);

        for (int i = computer.size() - 1; i >= 0; i--) {
            inputNum = inputNumber % 10;

            int strikeCount = strikeCheck(computer.get(i), inputNum);   //inputNum과 computer.get(i)의 값이 같다면
            B_S.put(strike, B_S.get(strike) + strikeCount);             //B_S에 "Strike"의 value를 1 증가

            int ballCount = ballCheck(computer, inputNum) - strikeCount;    //inputNum이 computer의 숫자 중 strike가 아니고 같은 숫자가 있다면
            B_S.put(ball, B_S.get(ball) + ballCount);                       //B_S에 "Ball"의 value를 1 증가

            inputNumber /= 10;
        }

        return translateMapToString(B_S);
    }

    public String translateMapToString(Map<String, Integer> B_S) {
        String ball = "Ball";
        String strike = "Strike";
        String result = "";

        if (B_S.get(ball) > 0) {
            result += B_S.get(ball) + "볼";
        }
        if (B_S.get(ball) > 0 && B_S.get(strike) > 0) {
            result += " ";
        }
        if (B_S.get(strike) > 0) {
            result += B_S.get(strike) + "스트라이크";
        }
        if (result.equals("")) {
            result += "낫싱";
        }
        return result;
    }

    public int strikeCheck(int computerNum, int inputNum) {
        if (computerNum == inputNum) {
            return 1;
        }
        return 0;
    }

    public int ballCheck(List<Integer> computer, int inputNum) {
        int ballCount = 0;

        if (computer.contains(inputNum)) {
            ballCount++;
        }

        return ballCount;
    }

    public boolean inputCheckLength(String input) {
        if (input.length() != 3) {
            return false;
        }
        return true;
    }

    public boolean inputCheckNumber(String input) {
        if (!input.matches("[1-9]+")) {
            return false;
        }
        return true;
    }

    public boolean inputCheckDifferent(String input) {
        int[] numArr = new int[10];
        int inputNum = Integer.valueOf(input);

        for (int i = 0; i < 3; i++) {
            int num = inputNum % 10;

            if (numArr[num] > 0) {
                return false;
            }

            numArr[num]++;
            inputNum /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        Application application = new Application();
        ComputerNumber computerNumber = new ComputerNumber();       //상대방(컴퓨터) 숫자 객체 선언
        List<Integer> computer = computerNumber.makeComputer();     //상대방(컴퓨터)이 숫자 생성
        String input = "";                                          //입력받는 값을 넣어 줄 변수
        boolean gameFlag = true;                                    //게임 계속 실행할지 그만둘지 표시
        String result = "";                                         //결과를 출력해줄 변수
        String gameOverInput = "";                                  //게임 종료 후 입력받는 값을 넣어 줄 변수

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(gameFlag) {
            System.out.print("숫자를 입력해주세요 : ");

            input = Console.readLine();                             //사용자가 숫자를 입력할 수 있는 환경 구현

            if (!application.inputCheckAll(input)) {                //입력 값이 정해진 규칙에 적합하지 않으면 예외 처리
                throw new IllegalArgumentException();
            }

            result = application.sameCheck(computer, input);        //입력 값에 대한 결과 출력
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                gameOverInput = Console.readLine();
            }

            if ("2".equals(gameOverInput)) {                        //2를 입력했다면
                gameFlag = false;                                   //while문이 반복하지 않도록 gameFlag에 false 입력
            } else if ("1".equals(gameOverInput)) {                 //1을 입력했다면
                computer = computerNumber.makeComputer();           //상대방(컴퓨터)의 숫자를 새로 생성해서 게임 진행
                gameOverInput = "";
            }
        }
    }
}

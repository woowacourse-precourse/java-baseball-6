package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> computer = new ArrayList<>();
    static boolean checkMakeComputer, checkStrike, checkContinue;
    static int[] user;
    static int inputNum, cntStrike, cntBall;
    static String answer, ballStr, strikeStr, userInput;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            // 컴퓨터 랜덤 숫자가 생성이 안된 경우 생성하기
            if (!checkMakeComputer) {
                makeRandomNum();
                checkMakeComputer = true;
            }
            // 스트라이크, 볼 개수 카운트 후 정답 판단 후 결과 출력하기
            countStrikeAndBall();
            judgeAndShowResult();
            // 정답을 맞춘 후 숫자 2 입력 시 게임 종료
            if (checkContinue) {
                break;
            }
        }
    }

    public static void countStrikeAndBall() {
        // 3개의 숫자를 입력받는다.
        System.out.print("숫자를 입력해주세요 : ");
        userInput = readLine();
        inputNum = check_error(userInput);
        user = new int[3];
        cntStrike = 0;
        cntBall = 0;
        user[0] = inputNum / 100;
        user[1] = (inputNum / 10) % 10;
        user[2] = inputNum % 10;
        for (int i = 0; i < 3; i++) {
            if (user[i] == computer.get(i)) {
                cntStrike++;
            } else {
                for (int j = 0; j < 3; j++) {
                    if (i != j && user[i] == computer.get(j)) {
                        cntBall++;
                    }
                }
            }
        }
    }

    public static void judgeAndShowResult() {
        // 낫싱, 오직 볼, 오직 스트라이크, 볼&스트라이크, 정답
        answer = "";
        checkStrike = false;
        if (cntStrike == 0 && cntBall == 0) {
            answer += "낫싱";
        } else if (cntStrike == 0 && cntBall > 0) {
            ballStr = String.valueOf(cntBall);
            answer += ballStr + "볼";
        } else if (cntStrike > 0 && cntBall == 0) {
            strikeStr = String.valueOf(cntStrike);
            answer += strikeStr + "스트라이크";
            if (cntStrike == 3) {
                checkStrike = true;
            }
        } else if (cntStrike > 0 && cntBall > 0) {
            strikeStr = String.valueOf(cntStrike);
            ballStr = String.valueOf(cntBall);
            answer += ballStr + "볼 " + strikeStr + "스트라이크";
        }
        System.out.println(answer);
        if (checkStrike) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            checkMakeComputer = false;
            int continueNum = Integer.parseInt(readLine());
            if (continueNum == 2) {
                System.out.println("게임을 종료합니다.");
                checkContinue = true;
            }
        }
    }


    public static void makeRandomNum() {
        computer.clear();
        // 우테코에서 제공하는 라이브러리 중 Randoms를 이용하여 컴퓨터에게 난수 제공
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static int check_error(String input) {
        // 에러 상황 나누기
        // 1. 3자리 숫자가 아닌 경우
        // 2. 1부터 9의 숫자를 입력하지 않은 경우
        // 3. 111부터 999까지의 숫자가 아닌 경우
        // 4. 같은 숫자를 입력한 경우
        int numSum = 0;
        int inputLength = input.length();
        char char0 = input.charAt(0);
        char char1 = input.charAt(1);
        char char2 = input.charAt(2);
        if (inputLength != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        if ((char0 < '1' && char0 > '9') || (char1 < '1' && char1 > '9') || (char2 < '1' && char2 > '9')) {
            throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해주세요.");
        }
        numSum += Character.getNumericValue(char0) * 100;
        numSum += Character.getNumericValue(char1) * 10;
        numSum += Character.getNumericValue(char2);
        if (numSum > 999 || numSum < 111) {
            throw new IllegalArgumentException("111부터 999까지의 숫자를 입력해주세요.");
        }
        if ((char0 == char1) || (char0 == char2) || (char1 == char2)) {
            throw new IllegalArgumentException("3개의 숫자 모두 다른 숫자를 입력해주세요.");
        }
        return numSum;
    }
}
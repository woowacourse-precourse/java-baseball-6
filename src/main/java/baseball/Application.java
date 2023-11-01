package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class Application {
    static List<Integer> computer;  // 컴퓨터 랜덤값
    static List<Integer> user;      // 사용자 입력값
    static int strikeCount;         // strike 수
    static int ballCount;           // ball 수
    static int digitNumber;         // 대상값 자릿수

    public static void main(String[] args) {
        digitNumber = 3;  // 대상값 자릿수 설정(3자리)

        while (true) {
            // 게임 시작
            startGame();

            // 게임 진행
            playGame();

            // 게임이 끝났을 때 재시작 여부 결정
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userString = Console.readLine();
            if (!restartGame(userString)) {
                break;
            }
        }
    }

    private static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터 랜덤값 input
        computer = new ArrayList<>();
        inputComputer();
    }

    private static void playGame() {
        while (true) {
            // 사용자 입력값 input
            System.out.print("숫자를 입력해주세요 : ");
            String userString = Console.readLine();
            user = new ArrayList<>();
            if (!isCorrectInput(userString)) {        // 자릿수 및 1-9 숫자 체크 : **예외 발생
                throw new IllegalArgumentException();
            }
            inputUser(userString);

            // 값 비교
            strikeCount = 0;
            ballCount = 0;
            for (int i=0; i<digitNumber; i++) {
                int userValue = user.get(i);
                int computerValue = computer.get(i);
                compareValue(userValue, computerValue);
            }

            // 힌트값 출력
            printHint();

            // 정답을 맞췄을 경우, 게임 종료 안내문구 출력 && 사용자 입력 중지
            if (strikeCount == digitNumber) {
                System.out.println(digitNumber + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static void inputComputer() {
        while (computer.size() < digitNumber) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)) {  // 숫자 중복 방지
                computer.add(randomNumber);
            }
        }
    }

    private static void inputUser(String target) {
        for (String str : target.split("")) {
            int num = Integer.parseInt(str);
            if (user.contains(num)) {                // 숫자 중복 체크 : **예외 발생
                throw new IllegalArgumentException();
            }
            user.add(num);
        }
    }

    private static boolean isCorrectInput(String target) {
        if (target.length() != digitNumber) {
            return false;
        }
        if (!Pattern.matches("[1-9]+", target))  {
            return false;
        }
        return true;
    }

    private static void compareValue(int userValue, int computerValue) {
        // strike,ball Count
        if (userValue == computerValue) {
            strikeCount++;
        } else if (computer.contains(userValue)) {
            ballCount++;
        }
    }

    private static void printHint() {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    private static boolean restartGame(String target) {
        if (target.equals("1")) {
            return true;
        } else if (target.equals("2")) {
            return false;
        } else {   // 사용자 입력값 오류 : 1 또는 2가 아닌 다른 값을 입력한 경우 : **예외 발생
            throw new IllegalArgumentException();
        }
    }
}
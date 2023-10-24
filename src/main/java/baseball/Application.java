package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Application {
    static int setNumber = 1;
    static String computerNumber;
    static String userNumber;

    public static void generateComputerNumber() { //컴퓨터 난수 생성
        ArrayList<String> ClearNumberList = new ArrayList<>();
        ClearNumberList.clear();
        String randomNumber;
        String ClearRandomNumber;
        while (ClearNumberList.size() < 3) {
            randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (ClearNumberList.contains(randomNumber)) {
                continue;
            }
            ClearNumberList.add(randomNumber);
        }
        ClearRandomNumber = String.join("", ClearNumberList);
        computerNumber = ClearRandomNumber;
    }

    public static int[] getResult(String computerNumber, String userNumber) {
        int ball = 0;
        int strike = 0;
        int[] result = {0, 0};
        for (int i = 0; i < 3; i++) {
            if (computerNumber.contains(Character.toString(userNumber.charAt(i)))) {
                ball++;
            }

        }
        for (char userNum : userNumber.toCharArray()) {
            if (computerNumber.indexOf(userNum) == userNumber.indexOf(userNum)) {
                strike++;
            }
        }
        ball -= strike;
        result = new int[]{strike, ball};
        return result;
    }

    public static void printResult(String computerNumber, String userNumber) {
        int[] result = getResult(computerNumber, userNumber); //idx 0 = 스트라이크, idx 1 = 볼
        int strike = result[0];
        int ball = result[1];
        if (strike > 0 && ball == 0) { //스트라이크
            System.out.printf("\n%d스트라이크\n", strike);
            if (strike == 3) { //3스트라이크
                System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                getNumberAfterFinish();// 1혹은 2를 입력 받음
                if (setNumber == 1) {
                    generateComputerNumber(); //재시작용 난수 생성
                }
            }
        } else if (strike == 0 && ball > 0) { //볼
            System.out.printf("\n%d볼\n", ball);
        } else if (strike > 0 && ball > 0) { //스트라이크 - 볼
            System.out.printf("\n%d볼 %d스트라이크\n", ball, strike);
        } else if (strike == 0 && ball == 0) { //낫싱
            System.out.println("\n낫싱");
        }
    }

    public static void getNumberAfterFinish() {
        int setNumberCheck = Integer.parseInt(Console.readLine());
        isCorrectRetryNumber(setNumberCheck);
        setNumber = setNumberCheck;

    }

    public static void isCorrectRetryNumber(int number) throws IllegalArgumentException {
        if (number != 1 && number != 2) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startMention(); // 게임 시작 멘트
        generateComputerNumber(); // 초기 난수 생성
        setNumber = 1;
        while (setNumber != 2) {
            System.out.print("숫자를 입력해주세요 : ");
            String user = Console.readLine();
            getUserNumber(user);
            printResult(computerNumber, userNumber);
            //start();
        }
    }

    public static void getUserNumber(String inputNumber) {
        isWrongLength(inputNumber);
        isSameNumber(inputNumber);
        isNotDigitNumber(inputNumber);
        userNumber = inputNumber;
    }

    public static void isWrongLength(String userNumber) throws IllegalArgumentException {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("입력한 숫자는 3자리여야 합니다.");
        }
    }

    public static void isNotDigitNumber(String userNumber) throws IllegalArgumentException {
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(userNumber.charAt(i))) {
                throw new IllegalArgumentException("자연수가 아닙니다.");
            }
        }
    }

    public static void isSameNumber(String userNumber) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(userNumber.charAt(i));
        }
        if (set.size() != userNumber.length()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    public static void startMention() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}

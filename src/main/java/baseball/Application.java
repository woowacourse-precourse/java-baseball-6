package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        boolean playAgain = true;

        while (playAgain) {

            System.out.println("숫자 야구 게임을 시작합니다.");
            int[] ComputerNumber = CheckComputerNumber(getComputerNumber());
            playGame(ComputerNumber);
            playAgain = playAgain();

        }
    }

    private static void playGame(int[] ComputerNumber) { //depth 2 , 게임 실행 메소드

        boolean win = false;

        while (!win) {

            int[] UserNumber = StringToIntArray(getUserNumber());
            CheckUserNumber(UserNumber);
            int[] result = checkNum(ComputerNumber, UserNumber);
            printResult(result);
            System.out.println();

            if (result[1] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                win = true;
            }

        }
    }

    private static boolean playAgain() { //depth 0 , 게임 제시작 메소드

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String num = Console.readLine();

        return !num.equals("2");
    }

    private static int[] getComputerNumber() { //depth 1 , 컴퓨터 수 생성 메소드
        int[] computerNumber = new int[3];

        computerNumber[0] = Randoms.pickNumberInRange(1, 9);

        for (int i = 1; i < 3; i++) {
            computerNumber[i] = Randoms.pickNumberInRange(1, 9);
        }

        return computerNumber;
    }

    private static int[] CheckComputerNumber(int[] array) { //depth 3, 컴퓨터가 생성한 수 에 대한 중복 검사 메소드
        int[] newArray = new int[3];
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int num : array) {
            if (set.contains(num)) {
                int newNumber;

                do {
                    newNumber = Randoms.pickNumberInRange(1, 9);
                } while (set.contains(newNumber)); // 중복된 값을 피하기 위해 반복

                newArray[count] = newNumber;
            }

            if (!set.contains(num)) {
                newArray[count] = array[count];
            }

            set.add(num);
            count++;
        }

        return newArray;
    }


    private static String getUserNumber() {// depth 0, 유저에게 값을 입력받는 메소드
        System.out.print("숫자를 입력해주세요 : ");
        String UserNum = Console.readLine();
        return UserNum;
    }

    private static void CheckUserNumber(int[] array) { //depth 2, 유저 가 입력한 값에 오류가 있는지 확인하는 메소드
        //서로 다른 3자리 정수
        Set<Integer> verify = new HashSet<>();
        for (int num : array) {
            if (verify.contains(num) || array.length != 3) {
                throw new IllegalArgumentException("유효하지 않은 사용자 입력입니다.");
            }
            verify.add(num);
        }
    }

    private static int[] StringToIntArray(String input) {//depth 1, 문자열로 입력받은 값을 정수 배열로 변환
        int[] result = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            result[i] = Character.getNumericValue(digit);
        }
        return result;
    }

    private static int[] checkNum(int[] computerNumber, int[] userNum) {//depth 2 , 볼 과 스트라이크 판별 메소드
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            int num = userNum[i];

            if (userNum[i] == computerNumber[i]) {
                strikes++;
            }

            if (Arrays.stream(computerNumber).anyMatch(x -> x == num) && userNum[i] != computerNumber[i]) {
                balls++;
            }
        }

        return new int[]{balls, strikes};
    }

    private static void printResult(int[] result) { //depth 1
        if (result[0] == 0 && result[1] == 0) {// 볼도 스트라이크도 아닌경우
            System.out.println("낫싱");
            return;
        }

        if (result[1] > 0 && result[0] > 0) { // 볼, 스트라이크 둘다 있는 경우
            System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
            return;
        }

        if (result[1] > 0 && result[0] == 0) { // 스트라이크 만 있는 경우
            System.out.println(result[1] + "스트라이크");
            return;
        }

        if (result[1] == 0 && result[0] > 0) { //  볼 만 있는   경우
            System.out.println(result[0] + "볼 ");
        }

    }
}

package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;


//프로그램 실행 시작점
public class Application {
    public static void main(String[] args) {

        Application app = new Application();
        Baseball baseball = new Baseball();

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean exitFlag = false;
        while (!exitFlag) {
            baseball.run(); //Baseball-> Run
            exitFlag = app.askExit();
        }
        System.out.println("프로그램을 종료합니다.");
    }

    // 게임종료 묻기 - 유저가 2를 입력하면 종료 대신 1말고 다른 숫자 입력해도 새로시작됨
    public boolean askExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLine();

        if (userInput.equals("2")) {
            return true;
        }
        return false;
    }


    //
    // 컴퓨터 3자리 난수 발생
    private static int[] generateComputerNumbers() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Randoms.pickNumberInRange(1, 9); // 1부터 9까지의 숫자

        }

        return numbers;
    }

    // 사용자로부터 3자리 숫자 입력 받기
    private static int[] getUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine();
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            // getNumericValue = char 숫자 -> int형으로 변환
            numbers[i] = Character.getNumericValue(input.charAt(i));
            int[] userNumber = getUserNumbers();
            System.out.println(Arrays.toString(userNumber));
        }
        return numbers;
    }

    // 정답과 내 입력값 비교하기

}

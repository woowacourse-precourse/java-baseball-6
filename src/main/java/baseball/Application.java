package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class Application {
    public static void main(String[] args) {
        startGame();

        int computerNumber = generateComputerNumber();
        System.out.println("computerNumber = " + computerNumber);

        int userInput = getUserInput();
        System.out.println("userInput = " + userInput);


    }

    private static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static int generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                sb.append(randomNumber);
            }
        }
        return Integer.parseInt(sb.toString());
    }

    private static int getUserInput() {
        // 사용자로부터 Console 로 입력 받기
        // 입력 받은 문자열을 검증 -> isValidateNumber
        // StringTokenizer로 한 자씩 분리해서 배열 형태로 만들 필요가 있음.

        System.out.print("숫자를 입력해주세요 : ");
        int userInput = Integer.parseInt(readLine());

        return userInput;
    }

    private static int isValidateNumber(int num) {
        // 사용자 입력 검증
        // 3자리 숫자가 아닌 경우 exception 발생
        return 0;
    }

    private static void printHint(int num) {
        // 사용자 입력에 따른 힌트 출력
    }

    private static int getOptionNumber(String userInput) {
        // 게임을 계속하는 것과 관련해서 1과 2가 아닌 수를 입력 받을 시 exception 발생
        return 0;
    }

    private static boolean continueOrQuit(int optionNumber) {
        // getOptionNumber로 검증한 숫자를 받아서 게임을 지속할지 중단할지 결정
        return true;
    }

}

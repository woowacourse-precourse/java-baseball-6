package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean startGame = true;
        while (startGame) {
            String computerNumberStr = makeComputerNumber(); // 정답 생성
            playGame(computerNumberStr); // 게임 진행

            // 게임 완료시 재시작 or 종료 선택
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userDecision = readLine();
            if (userDecision.equals("2")) {
                startGame = false; // 게임 종료
            } else if (userDecision.equals("1")) {
                // 게임 재시작
            } else {
                throw new IllegalArgumentException("입력 오류: 1과 2 외의 입력값");
            }
        }
    }

    // 서로 다른 3개의 숫자를 리스트에 생성하고, 해당 숫자들로 이어진 3자리 수를 문자열 형태로 반환
    public static String makeComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int computerNumber = 100 * computer.get(0) + 10 * computer.get(1) + computer.get(2);
        return Integer.toString(computerNumber);
    }

    // 입력값이 정답(computerNumberStr)과 같을 때까지 (입력 - 정답과 비교 - 결과 출력)을 반복
    public static void playGame(String computerNumberStr) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userNumberStr = readLine();

            // 입력값이 정답과 같으면 반복 종료
            if (userNumberStr.equals(computerNumberStr)) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            checkInputError(userNumberStr); // 입력값이 서로 다른 3자리 수인지 확인
            compareNumber(computerNumberStr, userNumberStr); // 정답과 입력값 비교 후 결과 출력
        }
    }

    // 입력값(userNumberStr)이 서로 다른 3자리의 숫자가 아닐 경우 IllegalArgumentException 발생
    public static void checkInputError(String userNumberStr) {
        // 숫자가 아닐 때
        try {
            Integer.parseInt(userNumberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 오류: 숫자 외의 문자 포함");
        }
        // 3자리가 아닐때
        if (userNumberStr.length() != 3) {
            throw new IllegalArgumentException("입력 오류: 3자리가 아님");
        }
        // 같은 숫자가 있을 때
        char digit1 = userNumberStr.charAt(0);
        char digit2 = userNumberStr.charAt(1);
        char digit3 = userNumberStr.charAt(2);
        if (digit1 == digit2 || digit1 == digit3 || digit2 == digit3) {
            throw new IllegalArgumentException("입력 오류: 중복된 숫자 포함");
        }
    }

    // 정답(computerNumberStr)과 입력값(userNumberStr)을 비교한 후 결과를 출력
    public static void compareNumber(String computerNumberStr, String userNumberStr) {
        // 입력값과 정답을 한 자리씩 비교하고 결과에 따라 스트라이크, 볼 개수 세기
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < computerNumberStr.length(); i++) {
            char computerDigit = computerNumberStr.charAt(i);
            char userDigit = userNumberStr.charAt(i);
            if (userDigit == computerDigit) {
                strike++; // 같은 자리, 같은 수 --> 스트라이크
            } else if (computerNumberStr.contains(String.valueOf(userDigit))) {
                ball++; // 다른 자리, 같은 수 포함 --> 볼
            }
        }
        // 스트라이크, 볼 개수 출력
        if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        } else { // 스트라이크, 볼 모두 1개 이상이 아닐 때
            System.out.println("낫싱");
        }
    }
}
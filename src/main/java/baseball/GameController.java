package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    // 게임 관련 상수 및 변수
    private static final String THREE_STRIKES = "3스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private String randomValue;

    // 게임 생성자 randomValue 초기화
    public GameController() {
        this.randomValue = generateNumber();
    }

    // 게임 진행 메서드
    public void play() {
        while (true) {
            String userInput = getUserInput();
            String result = compare(randomValue, userInput);
            System.out.println(result);

            if (isGameOver(result)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                if (!askForRestart()) {
                    break;
                }
                randomValue = generateNumber(); // 개선 필요
            }
        }
    }

    // 사용자 입력 받기
    public static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        InputValidator.validate(userInput);
        return userInput;
    }

    // 게임 종료 여부 확인
    public static boolean isGameOver(String result) {
        return THREE_STRIKES.equals(result);
    }

    // 게임 재시작 여부 확인
    public static boolean askForRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = Integer.parseInt(Console.readLine());
        if (choice != 1 && choice != 2) {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
        return choice == 1;
    }

    // 랜덤 숫자 생성
    public static String generateNumber() {
        StringBuilder sb = new StringBuilder();
        List<Integer> computer = new ArrayList<>();
        while (sb.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                sb.append(randomNumber);
            }
        }
        return sb.toString();
    }

    // 사용자 입력과 랜덤 숫자 비교 -> 비교 결과 출력
    public static String compare(String randomValue, String userInput) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < randomValue.length(); i++) {
            char n = randomValue.charAt(i);
            int indexUserInput = userInput.indexOf(n);

            if (indexUserInput == i) {
                strike++;
            } else if (indexUserInput != -1) {
                ball++;
            }
        }

        if (strike == 0 && ball == 0) {
            return NOTHING;
        }

        if (strike == 3) {
            return THREE_STRIKES;
        }

        StringBuilder sb = new StringBuilder();

        if (ball > 0) {
            sb.append(ball).append(BALL);
        }
        sb.append(" ");
        if (strike > 0) {
            sb.append(strike).append(STRIKE);
        }
        return sb.toString().trim();
    }
}

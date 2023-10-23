package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class Defender {
    private static final StringBuilder target = new StringBuilder();
    private static int ballCount = 0;
    private static int strikeCount = 0;

    // 정답(3자리 숫자) 생성
    public static void reroll() {
        target.setLength(0);
        List<Integer> temp = new ArrayList<>();
        while (temp.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!temp.contains(randomNumber)) {
                temp.add(randomNumber);
            }
        }
        for (int i = 0; i < 3; i++) {
            target.append(temp.get(i));
        }
        System.out.println(target); // 테스트용
    }

    // 정답 확인하기 - 볼, 스트라이크, 낫싱 출력하기
    public static void printScore(String answer) {
        calculateBallCount(answer);
        calculateStrikeCount(answer);

        // TODO: if문 분기 정리
        if (ballCount != 0 && strikeCount == 0) {
            System.out.printf("%d볼 ", ballCount);
            System.out.println();
        }
        if (ballCount == 0 && strikeCount != 0) {
            System.out.printf("%d스트라이크", strikeCount);
            System.out.println();
        }
        if (ballCount != 0 && strikeCount != 0) {
            System.out.printf("%d볼 ", ballCount);
            System.out.printf("%d스트라이크", strikeCount);
            System.out.println();
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }
    }

    // 정답 확인하기 - 볼
    public static void calculateBallCount(String answer) {
        ballCount = 0;
        // TODO: indent 정리(depth: 3)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && answer.charAt(i) == target.charAt(j)) {
                    ballCount++;
                }
            }
        }
    }

    // 정답 확인하기 - 스트라이크
    public static void calculateStrikeCount(String answer) {
        strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.charAt(i) == target.charAt(i)) {
                strikeCount++;
            }
        }
    }

    // 조건 확인
    public static boolean isThreeStrikes() {
        return strikeCount == 3;
    }

}

class Session {
    public static void startGame() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String answer = Console.readLine();

            Validation.isValidAnswer(answer);
            Defender.printScore(answer);

            if (endGame()) {
                break;
            }
        }
    }

    // 프로그램 종료하기
    public static boolean endGame() {
        boolean isRestart = false;

        if (Defender.isThreeStrikes()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart = Console.readLine();

            // TODO: Validation 클래스 이용
            isRestart = Validation.isValidAnswer2(restart);
        }
        return isRestart;
    }
}

class Validation {
    private static final String answerErrorMessage = "각 자리 수가 1~9이며, 서로 중복되지 않는 3자리 수를 입력해주세요.";
    private static final String restartErrorMessage = "1 또는 2로만 입력해주세요.";

    // 입력 유효성 검사 1. 빈 입력값 확인 - answer, restart
    private static void checkEmpty(String arg, String message) {
        if (arg.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    // 입력 유효성 검사 2. 숫자가 아닌 입력값(문자열) 확인 - answer, restart
    private static void checkNumber(String arg, String message) {
        try {
            Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }

    // 입력 유효성 검사 3. 0이 포함되어 있는가? - answer
    public static void checkIncludeZero(String arg) {
        for (int i = 0; i < 3; i++) {
            if (arg.charAt(i) == '0') {
                throw new IllegalArgumentException(answerErrorMessage);
            }
        }
    }

    // 입력 유효성 검사 4. 숫자이지만 3자리가 아닌 입력값 확인 - answer
    public static void checkLength(String arg) {
        if (arg.length() != 3) {
            throw new IllegalArgumentException(answerErrorMessage);
        }
    }

    // 입력 유효성 검사 5. 숫자이며, 3자리이지만 중복되는 입력값 확인 - answer
    public static void checkRepeat(String arg) {
        if (arg.charAt(0) == arg.charAt(1) || arg.charAt(0) == arg.charAt(2)
                || arg.charAt(1) == arg.charAt(2)) {
            throw new IllegalArgumentException(answerErrorMessage);
        }
    }

    // 입력 유효성 검사 6. 1 또는 2가 아닌 수 입력 - restart
    public static boolean checkRestart(int arg) {
        if (arg != 1 && arg != 2) {
            throw new IllegalArgumentException(restartErrorMessage);
        }
        if (arg == 1) {
            Defender.reroll();
        }
        if (arg == 2) {
            System.out.println("프로그램을 종료합니다.");
            return true;
        }
        return false;
    }


    // 제시한 답에 대한 유효성 검사
    public static void isValidAnswer(String arg) {
        checkEmpty(arg, answerErrorMessage);
        checkNumber(arg, answerErrorMessage);
        checkIncludeZero(arg);
        checkLength(arg);
        checkRepeat(arg);
    }

    // 재시작에 대한 유효성 검사
    public static boolean isValidAnswer2(String arg) {
        checkEmpty(arg, restartErrorMessage);
        checkNumber(arg, restartErrorMessage);
        
        int restart = Integer.parseInt(arg);
        return checkRestart(restart);
    }
}

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Defender.reroll();

        // 게임 시작, 입력 받기
        System.out.println("숫자 야구 게임을 시작합니다.");
        Session.startGame();

    }
}

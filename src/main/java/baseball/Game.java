package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private final String answer = generateAnswer(); // 1부터 9까지 서로 다른 수로 이루어진 3자리의 수

    public void start() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine(); // 사용자로부터 3자리의 수를 입력받는다.
            validateInput(input); // 입력값 검증
            if (isCorrect(input)) { // 정답이면 게임 종료
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private String generateAnswer() {
        boolean[] isUsed = new boolean[10];
        StringBuilder sb = new StringBuilder();

        while (sb.length() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);

            if (isUsed[number])
                continue;

            isUsed[number] = true;
            sb.append(number);
        }

        return sb.toString();
    }

    private void validateInput(String input) {
        if (!input.matches("^[1-9]{3}$")) {
            throw new IllegalArgumentException("1부터 9로 이루어진 3자리 숫자를 입력해주세요!");
        }
        if (input.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("중복된 숫자는 안돼요!");
        }
    }

    private boolean isCorrect(String input) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < input.length(); i++) {
            if (answer.charAt(i) == input.charAt(i)) {
                strike++;
            } else if (answer.contains(String.valueOf(input.charAt(i)))) {
                ball++;
            }
        }

        if (strike == 3) {
            System.out.println("3스트라이크");
            return true;
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        return false;
    }

    public boolean isEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (input.equals("1")) {
            return false;
        } else if (input.equals("2")) {
            return true;
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요!");
        }
    }
}

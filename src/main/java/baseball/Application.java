package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            BaseballGame game = new BaseballGame();
            game.play();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();

            if (!input.equals("1")) {
                System.out.println("안녕히 가세요!");
                break;
            }
        }
    }

    private static class BaseballGame {

        private static final int DIGIT_COUNT = 3;
        private static final int DIGIT_MIN = 1;
        private static final int DIGIT_MAX = 9;

        private final List<Integer> computerDigits;

        public BaseballGame() {
            this(Randoms.pickUniqueNumbersInRange(DIGIT_MIN, DIGIT_MAX, DIGIT_COUNT));
        }
        public BaseballGame(List<Integer> computerDigits) {
            this.computerDigits = computerDigits;
        }

        public boolean play() {
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                if (!isValidInput(input)) {
                    throw new IllegalArgumentException("잘못된 입력입니다! 1부터 9까지의 3자리 숫자를 입력해주세요.");
                }

                List<Integer> userDigits = parseDigits(input);
                int strikes = calculateStrikes(userDigits);
                int balls = calculateBalls(userDigits) - strikes;

                if (strikes == DIGIT_COUNT) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    return true;  // 게임 종료
                } else if (strikes > 0 || balls > 0) {
                    System.out.println(strikes + "스트라이크 " + balls + "볼");
                } else {
                    System.out.println("낫싱");
                }

                if (strikes == DIGIT_COUNT || balls == DIGIT_COUNT) {
                    return true;  // 게임 종료
                }
            }
        }

        private int calculateStrikes(List<Integer> userDigits) {
            int count = 0;
            for (int i = 0; i < DIGIT_COUNT; i++) {
                if (computerDigits.get(i).equals(userDigits.get(i))) {
                    count++;
                }
            }
            return count;
        }

        private int calculateBalls(List<Integer> userDigits) {
            int count = 0;
            for (int i = 0; i < DIGIT_COUNT; i++) {
                if (computerDigits.contains(userDigits.get(i)) && !computerDigits.get(i).equals(userDigits.get(i))) {
                    count++;
                }
            }
            return count;
        }


        private List<Integer> parseDigits(String input) {
            return input.chars().mapToObj(Character::getNumericValue).collect(Collectors.toList());
        }

        private boolean isValidInput(String input) {
            return input.length() == DIGIT_COUNT && input.chars().allMatch(c -> c >= '1' && c <= '9');
        }
    }
}


package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {
    private static final int DIGIT_COUNT = 3;
    private static final int DIGIT_MIN = 1;
    private static final int DIGIT_MAX = 9;
    private final List<Integer> computerDigits;

    public BaseballGame() {
        this(Randoms.pickUniqueNumbersInRange(1, 9, 3));
    }

    public BaseballGame(List<Integer> computerDigits) {
        this.computerDigits = computerDigits;
    }

    public boolean play() {
        int strikes;
        int balls;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if (!this.isValidInput(input)) {
                throw new IllegalArgumentException("잘못된 입력입니다! 1부터 9까지의 3자리 숫자를 입력해주세요.");
            }

            List<Integer> userDigits = this.parseDigits(input);
            strikes = this.calculateStrikes(userDigits);
            balls = this.calculateBalls(userDigits) - strikes;
            if (strikes == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }

            if (strikes <= 0 && balls <= 0) {
                System.out.println("낫싱");
            } else {
                System.out.println("" + strikes + "스트라이크 " + balls + "볼");
            }
        } while(strikes != 3);

        return true;
    }

    private int calculateStrikes(List<Integer> userDigits) {
        int count = 0;

        for(int i = 0; i < 3; ++i) {
            if (((Integer)this.computerDigits.get(i)).equals(userDigits.get(i))) {
                ++count;
            }
        }

        return count;
    }

    private int calculateBalls(List<Integer> userDigits) {
        int count = 0;

        for(int i = 0; i < 3; ++i) {
            if (this.computerDigits.contains(userDigits.get(i)) && !((Integer)this.computerDigits.get(i)).equals(userDigits.get(i))) {
                ++count;
            }
        }

        return count;
    }

    private List<Integer> parseDigits(String input) {
        return input.chars().mapToObj(Character::getNumericValue).collect(Collectors.toList());
    }

    private boolean isValidInput(String input) {
        return input.length() == 3 && input.chars().allMatch((c) -> {
            return c >= '1' && c <= '9';
        });
    }
}

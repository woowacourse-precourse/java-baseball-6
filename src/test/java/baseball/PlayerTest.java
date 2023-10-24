package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PlayerTest {
    private final String 문자정상입력 = "123";
    private final int 숫자정상입력 = 123;
    private final String[] 예외숫자들 = {
            "113", "ㄱ&`", "-123", "012", "12",
            "1234", "ㄱ&ㅈ", "1ㄱ2", "ab2", "!$%",
            "A2@", "311"};

    static class Player {
        private int number;
        private int[] numbers = new int[10];

        public static Player nextNumberOf(String stringNumber) {
            return new Player(stringNumber);
        }

        private Player() {
        }

        private Player(String stringNumber) {
            System.out.println("숫자를 입력해주세요 :" + stringNumber);

            if (isCorrectNumber(stringNumber)) {
                this.number = Integer.parseInt(stringNumber);
            }
        }

        public int getNumber() {
            return this.number;
        }

        private boolean isCorrectNumber(String stringNumber) {
            validateOnlyNumber(stringNumber);
            validatePositive(stringNumber);
            validateThreeCount(stringNumber);
            validateDistinct(stringNumber);
            return true;
        }

        private static void validateOnlyNumber(String stringNumber) {
            if (!stringNumber.matches("[1-9]+")) {
                throw new IllegalArgumentException("입력하신 내용엔 숫자외 값이 포함되었습니다.");
            }
        }

        private void validatePositive(String stringNumber) {
            if (Integer.parseInt(stringNumber) <= 0) {
                throw new IllegalArgumentException("입력하신 숫자는 정수가 아닙니다.");
            }
        }

        private void validateThreeCount(String stringNumber) {
            if (stringNumber.length() != 3) {
                throw new IllegalArgumentException("입력하신 숫자는 3개가 아닙니다.");
            }
        }

        private void validateDistinct(String stringNumber) {
            for (int i = 0; i < 3; i++) {
                int number = stringNumber.charAt(i) - '0';
                this.numbers[number]++;

                if (this.numbers[number] > 1) {
                    throw new IllegalArgumentException("입력하신 숫자는 중복되었습니다.");
                }
            }
        }
    }

    private int input(String stringNumber) {
        return Player.nextNumberOf(stringNumber).getNumber();
    }

    @Test
    void 플레이어_입력_정상() {
        int number = input(문자정상입력);

        assertThat(number).isEqualTo(숫자정상입력);
    }

    @Test
    void 플레이어_입력_예외() {
        for (String 예외숫자 : 예외숫자들) {
            assertThrows(IllegalArgumentException.class, () -> input(예외숫자));
        }
    }

}

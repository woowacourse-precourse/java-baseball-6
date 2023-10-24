package baseball;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

import baseball.core.Core;
import baseball.utils.Utils;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test

    void generateRandomNumber_테스트() {
        //given

        //when
        final List<Integer> computerRandomNumber = Utils.generateRandomNumber(3);

        //then
        assertThat(computerRandomNumber.size())
                .as("컴퓨터 랜덤 숫자 리스트 길이 검사")
                .isEqualTo(3);

        assertThat(computerRandomNumber.size())
                .as("컴퓨터 랜덤 숫자 리스트 중복 요소 검사")
                .isEqualTo(new HashSet<>(computerRandomNumber).size());

        for (int digit : computerRandomNumber) {
            assertThat(digit).as("컴퓨터 랜덤 숫자 리스트 요소 범위 검사").isBetween(1, 9);
        }
    }

    @Test
    void countStrike_테스트() {
        //given
        final Core T = new Core();
        final List<List<Integer>> case1 = List.of(List.of(1, 2, 3), List.of(4, 5, 6));  // 0 strike
        final List<List<Integer>> case2 = List.of(List.of(1, 2, 3), List.of(4, 2, 6));  // 1 strike
        final List<List<Integer>> case3 = List.of(List.of(1, 2, 3), List.of(1, 2, 6));  // 2 strike
        final List<List<Integer>> case4 = List.of(List.of(1, 2, 3), List.of(4, 2, 3));  // 2 strike
        final List<List<Integer>> case5 = List.of(List.of(1, 2, 3), List.of(1, 2, 3));  // 3 strike

        //when
        final int result1 = T.countStrike(case1.get(0), case1.get(1));
        final int result2 = T.countStrike(case2.get(0), case2.get(1));
        final int result3 = T.countStrike(case3.get(0), case3.get(1));
        final int result4 = T.countStrike(case4.get(0), case4.get(1));
        final int result5 = T.countStrike(case5.get(0), case5.get(1));


        //then
        assertThat(result1).as("countStrike 테스트").isEqualTo(0);
        assertThat(result2).as("countStrike 테스트").isEqualTo(1);
        assertThat(result3).as("countStrike 테스트").isEqualTo(2);
        assertThat(result4).as("countStrike 테스트").isEqualTo(2);
        assertThat(result5).as("countStrike 테스트").isEqualTo(3);
    }

    @Test
    void isDigitStrike_테스트() {
        //given
        final Core T = new Core();
        final List<List<Integer>> case1 = List.of(List.of(1, 2, 3), List.of(4, 2, 3));  // 2 strike

        //when
        final boolean result1 = T.isDigitStrike(case1.get(0), case1.get(1), 0); //false
        final boolean result2 = T.isDigitStrike(case1.get(0), case1.get(1), 1); //true
        final boolean result3 = T.isDigitStrike(case1.get(0), case1.get(1), 2); //true

        //then
        assertThat(result1).as("isDigitalStrike 테스트").isEqualTo(false);
        assertThat(result2).as("isDigitalStrike 테스트").isEqualTo(true);
        assertThat(result3).as("isDigitalStrike 테스트").isEqualTo(true);
    }

    @Test
    void isDigitBall_테스트() {
        //given
        final Core T = new Core();
        final List<List<Integer>> case1 = List.of(List.of(1, 2, 3), List.of(2, 1, 3));
        final List<List<Integer>> case2 = List.of(List.of(1, 2, 3), List.of(4, 5, 6));

        //when
        final boolean result1 = T.isDigitBall(case1.get(0), case1.get(1), 0);   //true
        final boolean result2 = T.isDigitBall(case1.get(0), case1.get(1), 1);   //true
        final boolean result3 = T.isDigitBall(case1.get(0), case1.get(1), 2);   //false

        final boolean result4 = T.isDigitBall(case2.get(0), case2.get(1), 0);   //false
        final boolean result5 = T.isDigitBall(case2.get(0), case2.get(1), 1);   //false
        final boolean result6 = T.isDigitBall(case2.get(0), case2.get(1), 2);   //false

        //then
        assertThat(result1).as("isDigitBall 테스트").isEqualTo(true);
        assertThat(result2).as("isDigitBall 테스트").isEqualTo(true);
        assertThat(result3).as("isDigitBall 테스트").isEqualTo(false);

        assertThat(result4).as("isDigitBall 테스트").isEqualTo(false);
        assertThat(result5).as("isDigitBall 테스트").isEqualTo(false);
        assertThat(result6).as("isDigitBall 테스트").isEqualTo(false);
    }

    @Test
    void countBall_테스트() {
        //given
        final Core T = new Core();
        final List<List<Integer>> case1 = List.of(List.of(1, 2, 3), List.of(4, 5, 6));  // 0 balls
        final List<List<Integer>> case2 = List.of(List.of(3, 4, 5), List.of(8, 5, 6));  // 1 balls
        final List<List<Integer>> case3 = List.of(List.of(1, 2, 3), List.of(2, 1, 3));  // 2 balls
        final List<List<Integer>> case4 = List.of(List.of(3, 6, 8), List.of(6, 8, 3));  // 3 balls
        final List<List<Integer>> case5 = List.of(List.of(6, 4, 3), List.of(3, 6, 4));  // 3 balls

        //when
        final int result1 = T.countBall(case1.get(0), case1.get(1));
        final int result2 = T.countBall(case2.get(0), case2.get(1));
        final int result3 = T.countBall(case3.get(0), case3.get(1));
        final int result4 = T.countBall(case4.get(0), case4.get(1));
        final int result5 = T.countBall(case5.get(0), case5.get(1));

        //then
        assertThat(result1).as("countBall 테스트").isEqualTo(0);
        assertThat(result2).as("countBall 테스트").isEqualTo(1);
        assertThat(result3).as("countBall 테스트").isEqualTo(2);
        assertThat(result4).as("countBall 테스트").isEqualTo(3);
        assertThat(result5).as("countBall 테스트").isEqualTo(3);

    }

    @Test
    void validateStringOneOrTwo_정상처리_테스트() {
        //given
        final String case1 = "1";
        final String case2 = "2";

        //when
        final Throwable thrown1 = catchThrowable(() -> {
            Utils.validateStringOneOrTwo(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            Utils.validateStringOneOrTwo(case2);
        });

        //then
        assertThat(thrown1).as("validateStringOneOrTwo 정상처리 테스트").doesNotThrowAnyException();
        assertThat(thrown2).as("validateStringOneOrTwo 정상처리 테스트").doesNotThrowAnyException();
    }

    @Test
    void validateStringOneOrTwo_예외처리_테스트() {
        //given
        final String case1 = "3";
        final String case2 = "294";
        final String case3 = "Exception String";
        final String case4 = "";


        //when
        final Throwable thrown1 = catchThrowable(() -> {
            Utils.validateStringOneOrTwo(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            Utils.validateStringOneOrTwo(case2);
        });
        final Throwable thrown3 = catchThrowable(() -> {
            Utils.validateStringOneOrTwo(case3);
        });
        final Throwable thrown4 = catchThrowable(() -> {
            Utils.validateStringOneOrTwo(case4);
        });

        //then
        assertThat(thrown1)
                .as("validateStringOneOrTwo 예외처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(thrown2)
                .as("validateStringOneOrTwo 예외처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(thrown3)
                .as("validateStringOneOrTwo 예외처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(thrown4)
                .as("validateStringOneOrTwo 예외처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
    }

    @Test
    void validateStringThreeDifferentDigits_정상처리_테스트() {
        //given
        final String case1 = "384";
        final String case2 = "247";

        //when
        final Throwable thrown1 = catchThrowable(() -> {
            Utils.validateStringThreeDifferentDigits(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            Utils.validateStringThreeDifferentDigits(case2);
        });

        //then
        assertThat(thrown1).as("validateStringThreeDifferentDigits 정상처리 테스트").doesNotThrowAnyException();
        assertThat(thrown2).as("validateStringThreeDifferentDigits 정상처리 테스트").doesNotThrowAnyException();
    }

    @Test
    void validateStringThreeDifferentDigits_예외처리_테스트() {
        //given
        final String case1 = "000";
        final String case2 = "272";
        final String case3 = "12345";
        final String case4 = "";
        final String case5 = "Exception String";

        //when
        final Throwable thrown1 = catchThrowable(() -> {
            Utils.validateStringThreeDifferentDigits(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            Utils.validateStringThreeDifferentDigits(case2);
        });
        final Throwable thrown3 = catchThrowable(() -> {
            Utils.validateStringThreeDifferentDigits(case3);
        });
        final Throwable thrown4 = catchThrowable(() -> {
            Utils.validateStringThreeDifferentDigits(case4);
        });
        final Throwable thrown5 = catchThrowable(() -> {
            Utils.validateStringThreeDifferentDigits(case5);
        });

        //then
        assertThat(thrown1)
                .as("validateStringThreeDifferentDigits 예외처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(thrown2)
                .as("validateStringThreeDifferentDigits 예외처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(thrown3)
                .as("validateStringThreeDifferentDigits 예외처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(thrown4)
                .as("validateStringThreeDifferentDigits 예외처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(thrown5)
                .as("validateStringThreeDifferentDigits 예외처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
    }

    @Test
    void validateStringLength_정상처리_테스트() {
        //given
        final String case1 = "134";
        final String case2 = "";
        final String case3 = "abcde fg";

        //when
        final Throwable result1 = catchThrowable(() -> {
            Utils.validateStringLength(case1, 3);
        });
        final Throwable result2 = catchThrowable(() -> {
            Utils.validateStringLength(case2, 0);
        });
        final Throwable result3 = catchThrowable(() -> {
            Utils.validateStringLength(case3, 8);
        });

        //then
        assertThat(result1).as("validateStringLength 정상처리 테스트").doesNotThrowAnyException();
        assertThat(result2).as("validateStringLength 정상처리 테스트").doesNotThrowAnyException();
        assertThat(result3).as("validateStringLength 정상처리 테스트").doesNotThrowAnyException();
    }

    @Test
    void validateStringLength_예외처리_테스트() {
        //given
        final String case1 = "13";
        final String case2 = "";

        //when
        final Throwable result1 = catchThrowable(() -> {
            Utils.validateStringLength(case1, 3);
        });
        final Throwable result2 = catchThrowable(() -> {
            Utils.validateStringLength(case2, 3);
        });

        //then
        assertThat(result1)
                .as("validateStringLength 예외처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(result2)
                .as("validateStringLength 예외처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
    }

    @Test
    void validateStringNaturalNumbers_정상처리_테스트() {
        //given
        final String case1 = "134";
        final String case2 = "162467";

        //when
        final Throwable result1 = catchThrowable(() -> {
            Utils.validateStringNaturalNumbers(case1);
        });
        final Throwable result2 = catchThrowable(() -> {
            Utils.validateStringNaturalNumbers(case2);
        });

        //then
        assertThat(result1).as("validateStringNaturalNumbers 정상처리 테스트").doesNotThrowAnyException();
        assertThat(result2).as("validateStringNaturalNumbers 정상처리 테스트").doesNotThrowAnyException();
    }

    @Test
    void validateStringNaturalNumbers_예외처리_테스트() {
        //given
        final String case1 = "103";
        final String case2 = "7345akvu3123";

        //when
        final Throwable result1 = catchThrowable(() -> {
            Utils.validateStringNaturalNumbers(case1);
        });
        final Throwable result2 = catchThrowable(() -> {
            Utils.validateStringNaturalNumbers(case2);
        });

        //then
        assertThat(result1)
                .as("validateStringNaturalNumbers 예외처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(result2)
                .as("validateStringNaturalNumbers 예외처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
    }

    @Test
    void validateAllDifferentCharacters_정상처리_테스트() {
        //given
        final String case1 = "123456789";
        final String case2 = "abcdefghij";

        //when
        final Throwable result1 = catchThrowable(() -> {
            Utils.validateAllDifferentCharacters(case1);
        });
        final Throwable result2 = catchThrowable(() -> {
            Utils.validateAllDifferentCharacters(case2);
        });

        //then
        assertThat(result1).as("validateAllDifferentCharacters 정상처리 테스트").doesNotThrowAnyException();
        assertThat(result2).as("validateAllDifferentCharacters 정상처리 테스트").doesNotThrowAnyException();
    }

    @Test
    void validateAllDifferentCharacters_예외처리_테스트() {
        //given
        final String case1 = "112";
        final String case2 = "aabbcc";

        //when
        final Throwable result1 = catchThrowable(() -> {
            Utils.validateAllDifferentCharacters(case1);
        });
        final Throwable result2 = catchThrowable(() -> {
            Utils.validateAllDifferentCharacters(case2);
        });

        //then
        assertThat(result1)
                .as("validateAllDifferentCharacters 예외처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(result2)
                .as("validateAllDifferentCharacters 예외처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
    }


    @Test
    void stringToIntegerList_테스트() {
        //given
        final String case1 = "123";
        final String case2 = "837";

        //when
        final List<Integer> result1 = Utils.stringToIntegerList(case1);
        final List<Integer> result2 = Utils.stringToIntegerList(case2);

        //then
        assertThat(result1).as("stringToIntegerList 테스트").isEqualTo(List.of(1, 2, 3));
        assertThat(result2).as("stringToIntegerList 테스트").isEqualTo(List.of(8, 3, 7));

    }

    @Test
    void printGameResult_테스트() {
        //given
        final Core T = new Core();
        final List<Integer> case1 = List.of(3, 0);   // 3 strikes
        final List<Integer> case2 = List.of(0, 0);   // 0 strikes 0 balls
        final List<Integer> case3 = List.of(2, 1);   // 2 strikes 1 balls
        final List<Integer> case4 = List.of(1, 2);   // 1 strikes 2 balls
        final List<Integer> case5 = List.of(2, 0);   // 2 strikes 0 balls
        final List<Integer> case6 = List.of(0, 2);   // 0 strikes 1 balls

        //when
        final OutputStream result1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result1));
        T.printGameResult(case1.get(0), case1.get(1));

        final OutputStream result2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result2));
        T.printGameResult(case2.get(0), case2.get(1));

        final OutputStream result3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result3));
        T.printGameResult(case3.get(0), case3.get(1));

        final OutputStream result4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result4));
        T.printGameResult(case4.get(0), case4.get(1));

        final OutputStream result5 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result5));
        T.printGameResult(case5.get(0), case5.get(1));

        final OutputStream result6 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result6));
        T.printGameResult(case6.get(0), case6.get(1));

        //then
        assertThat(result1.toString().strip()).as("printGameResult 테스트").isEqualTo("3스트라이크");
        assertThat(result2.toString().strip()).as("printGameResult 테스트").isEqualTo("낫싱");
        assertThat(result3.toString().strip()).as("printGameResult 테스트").isEqualTo("1볼 2스트라이크");
        assertThat(result4.toString().strip()).as("printGameResult 테스트").isEqualTo("2볼 1스트라이크");
        assertThat(result5.toString().strip()).as("printGameResult 테스트").isEqualTo("2스트라이크");
        assertThat(result6.toString().strip()).as("printGameResult 테스트").isEqualTo("2볼");
    }

    @Test

    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}




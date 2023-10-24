package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("컴퓨터 랜덤 번호 갯수 테스트")
    @Test
    void computerNumberSizeTest() {
        // given
        final int size = 3;

        // when
        final List<Integer> computerNumberList = Game.createNumbers(size);

        // then
        assertThat(computerNumberList.size()).isEqualTo(size);
    }

    @DisplayName("컴퓨터 랜덤 번호 범위 테스트")
    @Test
    void computerNumberRangeTest() {
        // given
        final int size = 3;

        // when
        final List<Integer> computerNumberList = Game.createNumbers(size);

        // then
        assertThat(computerNumberList.stream().allMatch(v -> v >= 1 && v <= 9)).isTrue();
    }

    @DisplayName("컴퓨터 랜덤 번호 중복 체크")
    @Test
    void computerNumberDuplicationTest() {
        // given
        final int size = 3;

        // when
        final List<Integer> computerNumberList = Game.createNumbers(size);

        // then
        assertThat(computerNumberList.size()).isEqualTo(new HashSet<>(computerNumberList).size());
    }

    @DisplayName("사용자 숫자 입력 정상처리 테스트")
    @Test
    void userNumberListRangeTest() {
        // given
        final int size = 3;

        Game game1 = new Game(size);
        final String input1 = "123";

        Game game2 = new Game(size);
        final String input2 = "456";

        // when
        final Throwable throwable1 = catchThrowable(() -> {
            Method method1 = Game.class.getDeclaredMethod("isValidInput", String.class, int.class);
            method1.setAccessible(true);
            method1.invoke(game1, input1, size);
        });
        final Throwable throwable2 = catchThrowable(() -> {
            Method method2 = Game.class.getDeclaredMethod("isValidInput", String.class, int.class);
            method2.setAccessible(true);
            method2.invoke(game2, input2, size);
        });

        // then
        assertThat(throwable1).doesNotThrowAnyException();
        assertThat(throwable2).doesNotThrowAnyException();
    }

    @DisplayName("사용자 숫자 입력 예외처리 테스트 - 범위")
    @Test
    void userNumberListRangeExceptionTest() {
        // given
        final int size = 3;

        Game game1 = new Game(size);
        final String input1 = "String";
        Game game2 = new Game(size);
        final String input2 = "12 3";
        Game game3 = new Game(size);
        final String input3 = "12!";
        Game game4 = new Game(size);
        final String input4 = "abcd7";

        // when
        final Throwable throwable1 = catchThrowable(() -> {
            Method method1= Game.class.getDeclaredMethod("isValidInput", String.class, int.class);
            method1.setAccessible(true);
            method1.invoke(game1, input1, size);
        });
        final Throwable throwable2 = catchThrowable(() -> {
            Method method2= Game.class.getDeclaredMethod("isValidInput", String.class, int.class);
            method2.setAccessible(true);
            method2.invoke(game2, input2, size);
        });
        final Throwable throwable3 = catchThrowable(() -> {
            Method method3= Game.class.getDeclaredMethod("isValidInput", String.class, int.class);
            method3.setAccessible(true);
            method3.invoke(game3, input3, size);
        });
        final Throwable throwable4 = catchThrowable(() -> {
            Method method4= Game.class.getDeclaredMethod("isValidInput", String.class, int.class);
            method4.setAccessible(true);
            method4.invoke(game4, input4, size);
        });

        // then
        assertThat(((InvocationTargetException) throwable1).getTargetException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_NATURAL_NUMBER);
        assertThat(((InvocationTargetException) throwable2).getTargetException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_NATURAL_NUMBER);
        assertThat(((InvocationTargetException) throwable3).getTargetException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_NATURAL_NUMBER);
        assertThat(((InvocationTargetException) throwable4).getTargetException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_NATURAL_NUMBER);

    }

    @DisplayName("사용자 숫자 입력 예외처리 테스트 - 숫자 개수")
    @Test
    void userNumberListSizeExceptionTest() {
        // given
        final int size = 3;

        Game game1 = new Game(size);
        final String input1 = "1";
        Game game2 = new Game(size);
        final String input2 = "22";
        Game game3 = new Game(size);
        final String input3 = "4444";
        Game game4 = new Game(size);
        final String input4 = "55555";

        // when
        final Throwable throwable1 = catchThrowable(() -> {
            Method method1 = Game.class.getDeclaredMethod("isValidInput", String.class, int.class);
            method1.setAccessible(true);
            method1.invoke(game1, input1, size);
        });
        final Throwable throwable2 = catchThrowable(() -> {
            Method method2 = Game.class.getDeclaredMethod("isValidInput", String.class, int.class);
            method2.setAccessible(true);
            method2.invoke(game2, input2, size);
        });
        final Throwable throwable3 = catchThrowable(() -> {
            Method method3 = Game.class.getDeclaredMethod("isValidInput", String.class, int.class);
            method3.setAccessible(true);
            method3.invoke(game3, input3, size);
        });
        final Throwable throwable4 = catchThrowable(() -> {
            Method method4 = Game.class.getDeclaredMethod("isValidInput", String.class, int.class);
            method4.setAccessible(true);
            method4.invoke(game4, input4, size);
        });

        // then
        assertThat(((InvocationTargetException) throwable1).getTargetException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(size + PrintMessage.ONLY_THIS_SIZE);
        assertThat(((InvocationTargetException) throwable2).getTargetException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(size + PrintMessage.ONLY_THIS_SIZE);
        assertThat(((InvocationTargetException) throwable3).getTargetException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(size + PrintMessage.ONLY_THIS_SIZE);
        assertThat(((InvocationTargetException) throwable4).getTargetException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(size + PrintMessage.ONLY_THIS_SIZE);
    }

    @DisplayName("사용자 숫자 입력 예외처리 테스트 - 중복")
    @Test
    void userNumberListDuplicationExceptionTest() {
        // given
        final int size = 3;

        Game game1 = new Game(size);
        final String input1 = "111";
        Game game2 = new Game(size);
        final String input2 = "112";
        Game game3 = new Game(size);
        final String input3 = "121";
        Game game4 = new Game(size);
        final String input4 = "122";

        // when
        final Throwable throwable1 = catchThrowable(() -> {
            Method method1 = Game.class.getDeclaredMethod("isValidInput", String.class, int.class);
            method1.setAccessible(true);
            method1.invoke(game1, input1, size);
        });
        final Throwable throwable2 = catchThrowable(() -> {
            Method method2 = Game.class.getDeclaredMethod("isValidInput", String.class, int.class);
            method2.setAccessible(true);
            method2.invoke(game2, input2, size);
        });
        final Throwable throwable3 = catchThrowable(() -> {
            Method method3 = Game.class.getDeclaredMethod("isValidInput", String.class, int.class);
            method3.setAccessible(true);
            method3.invoke(game3, input3, size);
        });
        final Throwable throwable4 = catchThrowable(() -> {
            Method method = Game.class.getDeclaredMethod("isValidInput", String.class, int.class);
            method.setAccessible(true);
            method.invoke(game4, input4, size);
        });

        // then
        assertThat(((InvocationTargetException) throwable1).getTargetException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.NOT_DUPLICATE_NUMBER);
        assertThat(((InvocationTargetException) throwable2).getTargetException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.NOT_DUPLICATE_NUMBER);
        assertThat(((InvocationTargetException) throwable3).getTargetException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.NOT_DUPLICATE_NUMBER);
        assertThat(((InvocationTargetException) throwable4).getTargetException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.NOT_DUPLICATE_NUMBER);
    }

    @DisplayName("사용자 입력을 숫자 리스트로 변환하는 메서드 테스트")
    @Test
    void stringArrToIntegerListTest() {
        // given
        final String input1 = "123";
        final String input2 = "654";
        final String input3 = "369";

        // when
        final List<Integer> result1 = Utils.stringArrToIntegerList(input1);
        final List<Integer> result2 = Utils.stringArrToIntegerList(input2);
        final List<Integer> result3 = Utils.stringArrToIntegerList(input3);

        // then
        assertThat(result1).isEqualTo(Arrays.asList(1, 2, 3));
        assertThat(result2).isEqualTo(Arrays.asList(6, 5, 4));
        assertThat(result3).isEqualTo(Arrays.asList(3, 6, 9));
    }

    @DisplayName("스트라이크 개수 세는 테스트")
    @Test
    void countStrikeTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        final int size = 3;
        final List<Integer> computer = Arrays.asList(1, 3, 5);

        final List<Integer> user1 = Arrays.asList(2, 4, 8); // 0 strike
        Player player1 = new Player(computer, user1, size);

        final List<Integer> user2 = Arrays.asList(1, 7, 9); // 1 strike
        Player player2 = new Player(computer, user2, size);
        final List<Integer> user3 = Arrays.asList(2, 3, 8); // 1 strike
        Player player3 = new Player(computer, user3, size);
        final List<Integer> user4 = Arrays.asList(4, 7, 5); // 1 strike
        Player player4 = new Player(computer, user4, size);

        final List<Integer> user5 = Arrays.asList(1, 3, 9); // 2 strike
        Player player5 = new Player(computer, user5, size);
        final List<Integer> user6 = Arrays.asList(1, 2, 5); // 2 strike
        Player player6 = new Player(computer, user6, size);
        final List<Integer> user7 = Arrays.asList(2, 3, 5); // 2 strike
        Player player7 = new Player(computer, user7, size);

        final List<Integer> user8 = Arrays.asList(1, 3, 5); // 3 strike
        Player player8 = new Player(computer, user8, size);

        // when
        final int result1 = player1.getStrike();
        final int result2 = player2.getStrike();
        final int result3 = player3.getStrike();
        final int result4 = player4.getStrike();
        final int result5 = player5.getStrike();
        final int result6 = player6.getStrike();
        final int result7 = player7.getStrike();
        final int result8 = player8.getStrike();


        // then
        assertThat(result1).isEqualTo(0);
        assertThat(result2).isEqualTo(1);
        assertThat(result3).isEqualTo(1);
        assertThat(result4).isEqualTo(1);
        assertThat(result5).isEqualTo(2);
        assertThat(result6).isEqualTo(2);
        assertThat(result7).isEqualTo(2);
        assertThat(result8).isEqualTo(3);
    }

    @DisplayName("볼 개수 세는 테스트")
    @Test
    void countBallTest() {
        // given
        final int size = 3;
        final List<Integer> computer = Arrays.asList(1, 3, 5);

        final List<Integer> user1 = Arrays.asList(2, 4, 8); // 0 ball
        Player player1 = new Player(computer, user1, size);

        final List<Integer> user2 = Arrays.asList(9, 8, 1); // 1 ball
        Player player2 = new Player(computer, user2, size);
        final List<Integer> user3 = Arrays.asList(9, 1, 8); // 1 ball
        Player player3 = new Player(computer, user3, size);
        final List<Integer> user4 = Arrays.asList(7, 5, 8); // 1 ball
        Player player4 = new Player(computer, user4, size);

        final List<Integer> user5 = Arrays.asList(3, 5, 9); // 2 ball
        Player player5 = new Player(computer, user5, size);
        final List<Integer> user6 = Arrays.asList(9, 1, 3); // 2 ball
        Player player6 = new Player(computer, user6, size);
        final List<Integer> user7 = Arrays.asList(5, 9, 1); // 2 ball
        Player player7 = new Player(computer, user7, size);

        final List<Integer> user8 = Arrays.asList(3, 5, 1); // 3 ball
        Player player8 = new Player(computer, user8, size);

        // when
        final int result1 = player1.getBall();
        final int result2 = player2.getBall();
        final int result3 = player3.getBall();
        final int result4 = player4.getBall();
        final int result5 = player5.getBall();
        final int result6 = player6.getBall();
        final int result7 = player7.getBall();
        final int result8 = player8.getBall();

        // then
        assertThat(result1).isEqualTo(0);
        assertThat(result2).isEqualTo(1);
        assertThat(result3).isEqualTo(1);
        assertThat(result4).isEqualTo(1);
        assertThat(result5).isEqualTo(2);
        assertThat(result6).isEqualTo(2);
        assertThat(result7).isEqualTo(2);
        assertThat(result8).isEqualTo(3);
    }

    @DisplayName("결과 출력 메서드 테스트")
    @Test
    void printResultTest() {
        // given
        final int size = 3;
        Player player1 = new Player(List.of(1, 2, 3), List.of(4, 5, 6), size); // 낫싱
        Player player2 = new Player(List.of(2, 4, 8), List.of(1, 2, 3), size); // 1볼
        Player player3 = new Player(List.of(2, 4, 8), List.of(4, 8, 9), size); // 2볼
        Player player4 = new Player(List.of(3, 6, 9), List.of(2, 4, 9), size); // 1스트라이크
        Player player5 = new Player(List.of(3, 6, 9), List.of(3, 5, 9), size); // 2스트라이크
        Player player6 = new Player(List.of(1, 2, 3), List.of(1, 2, 3), size); // 3스트라이크
        Player player7 = new Player(List.of(1, 2, 3), List.of(3, 2, 1), size); // 2볼 1스트라이크

        // when
        final OutputStream result1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result1));
        player1.printResult();

        final OutputStream result2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result2));
        player2.printResult();

        final OutputStream result3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result3));
        player3.printResult();

        final OutputStream result4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result4));
        player4.printResult();

        final OutputStream result5 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result5));
        player5.printResult();

        final OutputStream result6 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result6));
        player6.printResult();

        final OutputStream result7 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result7));
        player7.printResult();

        // then
        assertThat(result1.toString().strip()).isEqualTo("낫싱");
        assertThat(result2.toString().strip()).isEqualTo("1볼");
        assertThat(result3.toString().strip()).isEqualTo("2볼");
        assertThat(result4.toString().strip()).isEqualTo("1스트라이크");
        assertThat(result5.toString().strip()).isEqualTo("2스트라이크");
        assertThat(result6.toString().strip()).isEqualTo("3스트라이크");
        assertThat(result7.toString().strip()).isEqualTo("2볼 1스트라이크");
    }

    @DisplayName("게임 재시작/종료 입력 유효성 확인 메서드 예외처리 테스트")
    @Test
    public void selectRestartOrExit() {
        // given
        final int size = 3;
        Game game1 = new Game(size);
        final String input1 = "0";

        Game game2 = new Game(size);
        final String input2 = "3";

        Game game3 = new Game(size);
        final String input3 = "yes";

        Game game4 = new Game(size);
        final String input4 = "no";

        Game game5 = new Game(size);
        final String input5 = "!";

        // when
        final Throwable throwable1 = catchThrowable(() -> {
            game1.selectRestartOrExit(input1);
        });
        final Throwable throwable2 = catchThrowable(() -> {
            game2.selectRestartOrExit(input2);
        });
        final Throwable throwable3 = catchThrowable(() -> {
            game3.selectRestartOrExit(input3);
        });
        final Throwable throwable4 = catchThrowable(() -> {
            game4.selectRestartOrExit(input4);
        });
        final Throwable throwable5 = catchThrowable(() -> {
            game5.selectRestartOrExit(input5);
        });

        // then
        assertThat(throwable1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_ONE_OR_TWO);
        assertThat(throwable2)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_ONE_OR_TWO);
        assertThat(throwable3)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_ONE_OR_TWO);
        assertThat(throwable4)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_ONE_OR_TWO);
        assertThat(throwable5)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_ONE_OR_TWO);
    }

    @DisplayName("게임 재시작/종료 입력 유효성 확인 메서드 정상처리 테스트")
    @Test
    public void isOneOrTwoTest() {
        // given
        final int size = 3;
        Game game = new Game(size);
        final String input1 = "1";
        final String input2 = "2";

        // when
        final Throwable throwable1 = catchThrowable(() -> {
            game.selectRestartOrExit(input1);
        });
        final Throwable throwable2 = catchThrowable(() -> {
            game.selectRestartOrExit(input2);
        });

        // then
        assertThat(throwable1).doesNotThrowAnyException();
        assertThat(throwable2).doesNotThrowAnyException();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

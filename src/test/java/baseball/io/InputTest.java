package baseball.io;

import camp.nextstep.edu.missionutils.Console;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputTest {

    /*
    Console 내부에서 scanner 인스턴스(이하 'scanner')를 관리하기 때문에, 바깥에서 임의로 scanner 인스턴스를 제어할 수 없다.
    scanner가 가지는 stream을 customStream으로 바꾸든지 말든지,
    여러번 테스트를 반복하면 scanner에 buffer가 계속 누적되어 있다(이전 buffer를 클리어하지 못하고 말이다).

    Console에서 scanner 객체를 생성하는 부분을 보면, scanner가 null이면 새 scanner를 만들어 반환하고 있다.
    그래서 scanner 객체를 새로 만들어주면 해결될 거라고 생각했다(현재로선 더 좋은 방법은 모르겠다).

    그래서 reflection을 활용하여, 테스트를 마칠 때마다(@AfterEach) scanner를 null로 만들어줬더니 실제로 해결되었다.
    */
    @AfterEach
    void tearDown() throws NoSuchFieldException, IllegalAccessException {
        Field field = Console.class.getDeclaredField("scanner");
        field.setAccessible(true);
        field.set(Scanner.class, null);
    }

    @Test
    void consoleLine() {
        String message = "테스트 문구입니다.";

        String input = message + "\n";
        InputStream customInput =
                new BufferedInputStream(new ByteArrayInputStream(input.getBytes()));
        System.setIn(customInput);
        String userInput = Input.consoleLine();

        Assertions.assertThat(userInput).isEqualTo(message);
    }

    @Test
    void consoleNumber테스트() {
        String testNumberString = "420";
        int testNumber = Integer.parseInt(testNumberString);

        String input = testNumberString + "\n";
        InputStream customInput =
                new BufferedInputStream(new ByteArrayInputStream(input.getBytes()));
        System.setIn(customInput);
        int userInput = Input.consoleNumber();

        Assertions.assertThat(userInput).isEqualTo(testNumber);
    }

    @Test
    void 기본consoleNumbers테스트() {
        String testNumberString = "429";
        List<Integer> testNumbers = List.of(4, 2, 9);

        String input = testNumberString + "\n";
        InputStream customInput =
                new BufferedInputStream(new ByteArrayInputStream(input.getBytes()));
        System.setIn(customInput);
        List<Integer> numbers = Input.consoleNumbers();

        Assertions.assertThat(numbers).isEqualTo(testNumbers);
    }

    @Test
    void 구분자가_들어간_consoleNumbers테스트() {
        String testNumberString = "4,2,9";
        List<Integer> testNumbers = List.of(4, 2, 9);

        String input = testNumberString + "\n";
        InputStream customInput =
                new BufferedInputStream(new ByteArrayInputStream(input.getBytes()));
        System.setIn(customInput);
        List<Integer> numbers = Input.consoleNumbers(",");

        Assertions.assertThat(numbers).isEqualTo(testNumbers);
    }

}
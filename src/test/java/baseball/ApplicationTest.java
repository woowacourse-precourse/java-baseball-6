package baseball;

import baseball.domain.ClientNumbers;
import baseball.domain.ComputerNumbers;
import baseball.domain.Info;
import baseball.exception.InputNotNumber;
import baseball.exception.InputNumberNotUnique;
import baseball.exception.InputSizeNot3;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /**
     * 도메인 메서드 테스트
     */
    @Test
    void clientNumbers_와_computerNumbers_전혀_다른_경우() {
        // computerNumbers 와 전혀 다른 clientNumbers 만들기
        ComputerNumbers computerNumbers = new ComputerNumbers();
        ClientNumbers clientNumbers = provideClientNumbersDifferentWithComputerNumbers(computerNumbers);

        // 서로 동일한 clientNumbers 와 computerNumbers 를 비교하여 info 만들기
        Info info = clientNumbers.compareWithComputerNumbers(computerNumbers);

        // 예상하는 info 만들기
        Info infoExpected = new Info(0, 0, true);

        // 동등성 비교
        Assertions.assertThat(info.equals(infoExpected)).isTrue();
    }

    @Test
    void clientNumbers_와_computerNumbers_완벽히_동일한_경우() {
        // computerNumbers 와 1개가 불일치한 clientNumbers 만들기
        ComputerNumbers computerNumbers = new ComputerNumbers();
        ClientNumbers clientNumbers = provideClientNumbersSameWithComputerNumbers(computerNumbers);

        // 서로 동일한 clientNumbers 와 computerNumbers 를 비교하여 info 만들기
        Info info = clientNumbers.compareWithComputerNumbers(computerNumbers);

        // 예상하는 info 만들기
        Info infoExpected = new Info(0, 2, true);

        // 동등성 비교
        Assertions.assertThat(info.equals(infoExpected)).isTrue();
    }

    @Test
    void clientNumbers_와_computerNumbers_일부_동일한_경우() {
        // computerNumbers 와 동일한 clientNumbers 만들기
        ComputerNumbers computerNumbers = new ComputerNumbers();
        ClientNumbers clientNumbers = provideClientNumbersPartlySameComputerNumbers(computerNumbers);

        // 서로 동일한 clientNumbers 와 computerNumbers 를 비교하여 info 만들기
        Info info = clientNumbers.compareWithComputerNumbers(computerNumbers);

        // 예상하는 info 만들기
        Info infoExpected = new Info(0, 3, false);

        // 동등성 비교
        Assertions.assertThat(info.equals(infoExpected)).isTrue();
    }


    private ClientNumbers provideClientNumbersDifferentWithComputerNumbers(ComputerNumbers computerNumbers) {
        List<Integer> list1to9 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        List<Integer> numbers = computerNumbers.getNumbers();
        list1to9.removeIf(i -> numbers.contains(i));

        StringBuilder sb = new StringBuilder();
        list1to9.forEach(i -> sb.append(i));
        ClientNumbers clientNumbers = new ClientNumbers(sb.substring(0, 3).toString());

        return clientNumbers;
    }

    private ClientNumbers provideClientNumbersSameWithComputerNumbers(ComputerNumbers computerNumbers) {
        List<Integer> list1to9 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> numbers = computerNumbers.getNumbers();
        list1to9.removeIf(i -> numbers.contains(i));

        StringBuilder sb = new StringBuilder();
        numbers.forEach(i -> sb.append(i));
        String differentString = sb.toString().replace(String.valueOf(numbers.get(0)), String.valueOf(list1to9.get(0)));

        ClientNumbers clientNumbers = new ClientNumbers(differentString);

        return clientNumbers;
    }

    private ClientNumbers provideClientNumbersPartlySameComputerNumbers(ComputerNumbers computerNumbers) {
        List<Integer> numbers = computerNumbers.getNumbers();
        StringBuilder sb = new StringBuilder();
        numbers.forEach(i -> sb.append(i));
        String sameString = sb.toString();

        ClientNumbers clientNumbers = new ClientNumbers(sameString);

        return clientNumbers;
    }

    /**
     * 예외 테스트
     */
    @Test
    void 숫자가가_아닌_문자열을_입력한_경우() {
        Assertions.assertThatThrownBy(() -> new ClientNumbers("일이삼")).isInstanceOf(InputNotNumber.class);
    }

    @Test
    void 중복된_숫자를_입력한_경우() {
        Assertions.assertThatThrownBy(() -> new ClientNumbers("112")).isInstanceOf(InputNumberNotUnique.class);
    }

    @Test
    void 입력값의_사이즈가_3_이상인_경우() {
        Assertions.assertThatThrownBy(() -> new ClientNumbers("1234")).isInstanceOf(InputSizeNot3.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

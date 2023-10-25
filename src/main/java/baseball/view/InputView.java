package baseball.view;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumbers;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int restartGame() {
        //System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static BaseballNumbers inputBaseballNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumbers = scanner.nextLine();
        validationInputNumber(inputNumbers);

        return BaseballNumbers.from(Arrays.stream(inputNumbers.split(""))
                .mapToInt(Integer::parseInt)
                .mapToObj(BaseballNumber::from)
                .collect(Collectors.toList()));
    }

    public static void validationInputNumber(String inputNumbers) {
        if (Objects.isNull(inputNumbers)) {
            throw new IllegalArgumentException("입력된 숫자가 없습니다.");
        }
        if (!Pattern.matches("^[0-9]*$", inputNumbers)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}

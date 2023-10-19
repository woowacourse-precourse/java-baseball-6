package baseball;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine();
        List<Integer> number = convertIntegerList(input);
        validateThreeNums(number);
    }

    private static List<Integer> convertIntegerList(String number) {
        try {
            return Arrays.stream(number.split(""))
                    .map(Integer::parseInt)
                    .toList();
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자가 아닌 숫자를 입력해주세요");
        }
    }

    private static void validateThreeNums(List<Integer> number) {
        if (number.size() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요");
        }
    }
}

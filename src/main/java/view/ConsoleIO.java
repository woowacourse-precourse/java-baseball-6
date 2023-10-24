package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleIO {

    private ConsoleIO() {
    }

    public static List<Integer> insert() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine().chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    public static void resultPrint(Integer ballCount, Integer strikeCount) {
        if(ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }

        if(ballCount == 0 && strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
        }

        if(ballCount > 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼");
        }

        if(ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }
}

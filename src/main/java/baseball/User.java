package baseball;

import java.util.Scanner;
import java.util.stream.Stream;

public class User {
    public int[] callNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자를 입력해주세요 : ");

        int[] num = Stream.of(camp.nextstep.edu.missionutils.Console.readLine()
                .split("")).mapToInt(Integer::parseInt).toArray();

        validateNumber(num);

        return num ;
    }

    private void validateNumber(int num[]) {
        if(num.length != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
        }
    }

}

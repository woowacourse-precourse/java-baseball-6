
package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInput {
    public List<Integer> player_num() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> player_num = new ArrayList<>();
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자만 입력해주세요");
        }

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (String number : input.split("")) {
            int num = Integer.parseInt(number);

            if (uniqueNumbers.contains(num)) {
                throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다");
            }

            if (num == 0) {
                throw new IllegalArgumentException("0은 입력할 수 없습니다");
            }

            uniqueNumbers.add(num);
            player_num.add(num);
        }

        return player_num;
    }
}

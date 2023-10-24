package baseball.CreateNum;

import baseball.Exception.Exception;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static List<Integer> userNumberList() {
        List<Integer> user = new ArrayList<>();

        System.out.print("숫자를 입력해주세요: ");
        String s = Console.readLine();

        Exception.validateInputLength(s);

        for (int x = 0; x < s.length(); x++) {

            Exception.validateNonDigitCharacter(s.charAt(x));
            Exception.validateDuplicates(user,s.charAt(x));
            Exception.validateMinimumValue(s.charAt(x));

            user.add((int) s.charAt(x) - 48);
        }
        return user;
    }
}

package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class User {
    Validation validation = new Validation();

    public List<Integer> userNumber() {
        List<Integer> user = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String userInsert = readLine();
        if (validation.isOkInput(userInsert)) {
            for (int i = 0; i < 3; i++) {
                user.add(Character.getNumericValue(userInsert.charAt(i)));
            }
            return user;
        } else {
            throw new IllegalArgumentException("오류가 발생했습니다.");
        }

    }

}

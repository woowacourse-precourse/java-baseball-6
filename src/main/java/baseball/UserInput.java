package baseball;
/*
    클래스 명 : UserInput
    설명      : 사용자의 수 입력과 검증
    작성자	  : 김준태
	날짜	  : 2023. 10. 23.
 */
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public List<Integer> validatedUserInput() {

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> userNumber = new ArrayList<>();
        //사용자의 입력이 3자리수가 맞는 확인
        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 3자리 수를 입력해주세요.");
        }
        //사용자의 입력을 List로 변경 및 입력이 숫자가 맞는 확인
        for (int i = 0; i < input.length(); i++) {
            char digitChar = input.charAt(i);
            if (!Character.isDigit(digitChar)) {
                throw new IllegalArgumentException("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
            int digit = Character.getNumericValue(digitChar);
            userNumber.add(digit);
        }
        //사용자의 입력에 동일한 숫자가 없는지 확인
        if (userNumber.get(0) == userNumber.get(1) || userNumber.get(0) == userNumber.get(2) || userNumber.get(1) == userNumber.get(2)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 각기 다른 3자리 수를 입력해주세요.");
        }

        return userNumber;
    }
}
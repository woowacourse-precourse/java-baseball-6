package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    private Validate validate; // 입력값이 오류가 없는지 검사하는 객체

    Input() {
        this.validate = new Validate();
    }

    List<Integer> getNumber() { //사용자의 숫자를 입력받고 예외가 없다면 반환하는 함수
        List<Integer> user;
        String number = Console.readLine();
        user = toArrayList(number); // 사용자가 입력한 정수 List<Integer>로 변환
        validate.validateUser(user); // 사용자가 입력한 숫자 예외 확인
        return user;
    }

    List<Integer> toArrayList(String number) { // String을 ArrayList로 변환하는 함수
        List<Integer> inputNumber = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            inputNumber.add(number.charAt(i) - '0');
        }
        return inputNumber; // List<Integer>로 변환된 변수 반환
    }
}

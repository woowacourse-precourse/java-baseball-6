package baseball.object;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
public class Human {
    public static List<Integer> DigitSetting() {
        String number;
        List<Integer> human = new ArrayList<>();
        number = Console.readLine();
        Validation(number);
        int tenDig = 100,IntNumber;
        IntNumber = Integer.parseInt(number);
        for(int i = 0; i < 3; i++){
            human.add(IntNumber / tenDig);
            IntNumber %= tenDig;
            tenDig /= 10;
        }
        return human;
    }
    private static void Validation(String number) {
        boolean digitContains = false;
        for (char character : number.toCharArray()) {
            if (Character.isDigit(character)) {
                digitContains = true;
                break;
            }
        }
        if(!digitContains)
            throw new IllegalArgumentException("입력한 값에 숫자가 포함되어 있지 않습니다. 다시 입력해 주세요.");

        if(number.length() != 3 )
            throw new IllegalArgumentException("숫자가 세 자리가 아닙니다. 다시 입력해 주세요");
    }
}

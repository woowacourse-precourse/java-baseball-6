package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다." );
    }

    public List<Integer> generateNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }

    public boolean isNumeric(String strNum) {
        try {
            Integer number = Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public List<Integer> inputUserNumber() {
        System.out.println("숫자를 입력해주세요 : " );
        String inputNumber = Console.readLine();
        List<Integer> integerList = new ArrayList<>();
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
        if (!isNumeric(inputNumber)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; ++i) {
            if (integerList.contains(inputNumber.indexOf(i))) {
                throw new IllegalArgumentException();
            }
            integerList.add(inputNumber.indexOf(i));
        }

        return integerList;
    }


}

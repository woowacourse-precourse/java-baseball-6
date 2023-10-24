package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> mine = new ArrayList<>();

    public List<Integer> getComputer() {
        return computer;
    }
    public List<Integer> getMine() {
        return mine;
    }

    public void setComputer() {
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    public void setMine() {
        mine.clear();
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();

        if (inputNumber.length() != 3 || !isInteger(inputNumber)) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < 3; i++) {
            int num = Character.getNumericValue(inputNumber.charAt(i));
            if (mine.contains(num)) {  // 중복입력 예외처리
                throw new IllegalArgumentException();
            }else mine.add(num);
        }
    }

    public static boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
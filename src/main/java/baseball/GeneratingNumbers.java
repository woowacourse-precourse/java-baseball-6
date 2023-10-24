package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GeneratingNumbers {
    static Nums nums = new Nums();

    // 상대방(컴퓨터) 숫자 생성
    public void getComputerNums(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        nums.setComputer(computer);
    }

    // 내 숫자 생성
    public void getMyNums(){
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();

        // 숫자 개수가 3개가 아닐 경우, 문자를 입력할 경우 예외처리
        if (inputNumber.length() != 3 || !isInteger(inputNumber)) {
            throw new IllegalArgumentException();
        }

        List<Integer> mine = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = Character.getNumericValue(inputNumber.charAt(i));
            if (mine.contains(num)) {  // 중복입력 예외처리
                throw new IllegalArgumentException();
            }else mine.add(num);
        }

        nums.setMine(mine);
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

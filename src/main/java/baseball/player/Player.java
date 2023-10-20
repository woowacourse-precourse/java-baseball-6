package baseball.player;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    /**
     * 사용자가 제시하는 숫자를 입력받음
     * @return 입력된 값을 List로 반환
     */
    public static List<Integer> getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputStr = Console.readLine();
        int input = Player.isVaild(inputStr);
        List<Integer> inputs = new ArrayList<>();
        while (input > 0) {
            int digit = input % 10;
            inputs.add(digit);
            input /= 10;
        }
        Collections.reverse(inputs);
        return inputs;
    }

    /**
     * 사용자가 입력한 값이 유효한지 확인
     * @param num 사용자가 입력한 String 값
     * @return int로 변환된 3자리 숫자 반환
     */
    public static int isVaild(String num) {
        try{
            int numInt = Integer.parseInt(num);
            if (num.length() != 3) {
                System.out.println("입력된 숫자의 자리수가 3이 아닙니다.");
                throw new IllegalArgumentException();
            }
            if (num.chars().distinct().count() != num.length()) {
                System.out.println("중복된 숫자가 있습니다.");
                throw new IllegalArgumentException();
            }
            return numInt;
        } catch (NumberFormatException e){
            System.out.println("입력값이 숫자가 아닙니다.");
            throw new IllegalArgumentException();
        }
    }
}

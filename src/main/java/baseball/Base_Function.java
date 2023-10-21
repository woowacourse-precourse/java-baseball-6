package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Base_Function
{
    public List<Integer> Make_RandomNum()
    {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public String Input_Data()
    {
        String str_input = Console.readLine();
        return str_input;
    }

    public int Input_Correction_Check(String input_str, int str_len)
    {
        if(input_str.length() != str_len)
            throw new IllegalArgumentException("입력오류. 애플리케이션 종료합니다.");
        if(str_len==1 && input_str.charAt(0)-'0'!=1 && input_str.charAt(0)-'0'!=2)
            throw new IllegalArgumentException("입력오류 1또는2의 입력값이 아닙니다. 애플리케이션 종료합니다.");
        /*
        try {
            if(input_str.length() != str_len)
                throw new IllegalArgumentException("입력오류. 애플리케이션 종료합니다.");
            if(str_len==1 && input_str.charAt(0)-'0'!=1 && input_str.charAt(0)-'0'!=2)
                throw new IllegalArgumentException("입력오류 1또는2의 입력값이 아닙니다. 애플리케이션 종료합니다.");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
        */

        return 1;

    }
    public int Input_Correction_Check(List<Integer> Input_num)
    {
        for (int i = 0; i < 3; i++) {
            // 입력 숫자가 1~9를 벗어난 경우
            if (Input_num.get(i) < 1 || Input_num.get(i) > 9) {
                throw new IllegalArgumentException("입력오류. 입력값이 1~9 숫자가 아닙니다. 애플리케이션 종료합니다.");
            }
            // 중복된 입력 값이 있는 경우
            if(Input_num.get(i) == Input_num.get((i+1)%3))
                throw new IllegalArgumentException("입력오류. 중복된 값이 입력되었습니다. 애플리케이션 종료합니다.");
        }
        /*
        try {
            for (int i = 0; i < 3; i++) {
                // 입력 숫자가 1~9를 벗어난 경우
                if (Input_num.get(i) < 1 || Input_num.get(i) > 9) {
                    throw new IllegalArgumentException("입력오류. 입력값이 1~9 숫자가 아닙니다. 애플리케이션 종료합니다.");
                }
                // 중복된 입력 값이 있는 경우
                if(Input_num.get(i) == Input_num.get((i+1)%3))
                    throw new IllegalArgumentException("입력오류. 중복된 값이 입력되었습니다. 애플리케이션 종료합니다.");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
         */
        return 1;
    }

}

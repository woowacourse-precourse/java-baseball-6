package baseball;

import camp.nextstep.edu.missionutils.Console;

public class validCheck {
    public static int isValidNumber(){

        String snumber = Console.readLine();
        int number;

        // 숫자인지 아닌지 판별
        number = Integer.parseInt(snumber);

        // user 입력 숫자 판별
        int first;
        int second;
        int third;

        // 숫자 값이 3자리가 아닌 경우
        if(number < 100 || number > 999){
            throw new IllegalArgumentException("값의 입력범위를 넘었습니다.");
        }
        else{
            // 각 자릿수 구하기
            first = number/100;
            second = (number%100)/10;
            third = (number%10);

            // 한 쌍이라도 값이 같으면? 예외처리
            if(first == second || second == third || first == third)
                throw new IllegalArgumentException("숫자의 양식이 주어진 양식이 아닙니다");

            // 숫자에 하나라도 0이 있는 경우 왜냐하면 1-9까지니까
            if(second == 0 || third == 0)
                throw new IllegalArgumentException("숫자의 양식이 주어진 양식이 아닙니다.");
        }

        return number;
    }
}

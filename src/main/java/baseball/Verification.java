package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.stream.Stream;

public class Verification {
    public static int[] input(){
        String in = Console.readLine();
        if (in.length() == 3) {
            int[] input = Stream.of(in.split("")).mapToInt(Integer::parseInt).toArray();
            inputDuplicateCheck(input);
            return input;
        }else{
            throw new IllegalArgumentException("입력하신 숫자는 "+in.length()+"자리 입니다. 3자리로 입력해주세요.");
        }
    }

    public static void inputDuplicateCheck(int[] input){
        int zero = input[0];
        int first = input[1];
        int second = input[2];
        if(zero == first || first == second || zero == second){
            throw new IllegalArgumentException("중복된 숫자가 있습니다. 다시 입력해주세요. : ");
        }else{
            inputRangeCheck(input);
        }
    }

    public static void inputRangeCheck(int[] input){
        for(int in : input){
            if(in < 1 || in > 9){
                throw new IllegalArgumentException("숫자의 범위가 1~9사이가 아닙니다.");
            }
        }
    }
}

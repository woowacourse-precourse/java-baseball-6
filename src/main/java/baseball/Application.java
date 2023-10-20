package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
        //Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
        //사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

        System.out.println("숫자 야구 게임을 시작합니다.");
        int[] user = check();
        int[] computer = create();
        print(cal(computer, user));

    }

    private static void print(int[] result){
        if(result[0] == 0 && result[1] == 0){
            System.out.println("낫싱");
        } else {
            System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
        }
    }

    private static int[] create(){
        int[] computer = new int[3];

        for(int i=0; i<computer.length; i++){
            computer[i] = Randoms.pickNumberInRange(1, 9);
        }

        return computer;
    }

    private static int[] cal(int[] computer, int[] user) {
        int strike = 0;
        int ball = 0;
        int[] result = new int[2];

        for(int i=0; i<computer.length; i++){
            for(int j=0; j<user.length; j++){
                if (i == j && computer[i] == user[j]) {
                    strike++;
                    break;
                } else if (computer[i] == user[j]) {
                    ball++;
                    break;
                }
            }
        }

        result[0] = strike;
        result[1] = ball;

        return result;
    }

    private static int[] check() {
        int[] input_array;

        try {
            System.out.print("숫자를 입력해주세요 : ");
            int input = Integer.parseInt(Console.readLine());
            int a = input/100;
            int b = input%100/10;
            int c = input%10;
            if(input > 987 || input < 123 || a == b || a == c || b == c){ //input 조건 확인
                throw new IllegalArgumentException();
            }

            input_array = new int[]{a, b, c};


        }catch (IllegalArgumentException e) {
            System.out.println("형식에 맞게 다시 입력해주세요.");
            throw e;
        };

        return input_array;
    }
}

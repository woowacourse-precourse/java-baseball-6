package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //(1) 초기설정

        int[] random_num = new int[10];
        int[] input_num = new int[10];


    }

    //TODO: 2023.10.20 (2)번 기능 메서드 구현 - 창덕
    private void rand_num_gen(int[] rand_num) {
        int num1, num2, num3;
        num1 = Randoms.pickNumberInRange(1, 9);
        rand_num[num1] = 1;

        do {
            num2 = Randoms.pickNumberInRange(1, 9);
        } while (rand_num[num2]!=0);
        rand_num[num2]=2;

        do {
            num3 = Randoms.pickNumberInRange(1, 9);
        }while(rand_num[num3]!=0);
        rand_num[num3]=3;
    }



}

package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int myNum = Integer.parseInt(Console.readLine());
        int randomNum = Randoms.pickNumberInRange(1,myNum);
        System.out.println(randomNum);
        Console.close();
    }
}

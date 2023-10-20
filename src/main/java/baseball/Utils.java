package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    Exceptions exceptions = new Exceptions();

    public List<Integer> makeBaseball(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        return computer;
    }

    public int strikeCount(List<Integer> computer, String inputNum) {
        int count =0;

        int first = Integer.parseInt(inputNum.substring(0,1));
        int second = Integer.parseInt(inputNum.substring(1,2));
        int third = Integer.parseInt(inputNum.substring(inputNum.length() -1));

        if (first == computer.get(0)) {
            count++;
        }
        if ( second == computer.get(1)) {
            count++;
        }
        if (third == computer.get(2)) {
            count++;
        }
        return count;
    }

    public int ballCount(List<Integer> computer, String inputNum) {
        int count =0;

        int first = Integer.parseInt(inputNum.substring(0,1));
        int second = Integer.parseInt(inputNum.substring(1,2));
        int third = Integer.parseInt(inputNum.substring(inputNum.length() -1));

        if (computer.contains(first) && first != computer.get(0)) {
            count++;
        }
        if (computer.contains(second) && second != computer.get(1)) {
            count++;
        }
        if (computer.contains(third) && third != computer.get(2)) {
            count++;
        }
        return count;
    }

    public void isCountMsg(int strike,int ball){

        if (ball > 0 && strike > 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        } else if (strike > 0) {
            System.out.printf("%d스트라이크\n", strike);

        } else if (ball > 0 ) {
            System.out.printf("%d볼\n", ball);

        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }

//    public String inputNumber(){
//        String num = Console.readLine();
//        exceptions.isInvalidNumberDuplication(num);
//        exceptions.isInvalidNumberLength(num);
//        return num;
//    }



}

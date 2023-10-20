package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballFunction {
    public static List<Integer> genNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> getNum(){
        List<Integer> player = new ArrayList<>();
        int input = Integer.parseInt(Console.readLine());
        if (input>=1000){
            System.out.println("error");
        }
        player.add(input/100);
        player.add((input%100)/10);
        player.add(input%10);

        return player;
    }



    public static void main(String[] args) {
        System.out.println(genNum());
        System.out.println(getNum());
    }
}

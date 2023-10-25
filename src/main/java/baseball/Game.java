package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Game {
    private List<Integer> computer = new ArrayList<>();

    Game(List<Integer> computer){
        this.computer = computer;
    }

    boolean check(int num){
        if(num > 999 || num < 100){
            return false;
        }
        int first = num / 100;
        int second = num % 100 / 10;
        int third = num % 100 % 10;

        TreeSet treeSet = new TreeSet<>();
        treeSet.add(first);
        treeSet.add(second);
        treeSet.add(third);

        return treeSet.size() == 3;
    }
    boolean playing(int num){
        int num_s = 0;
        int num_b = 0;

        int first = num / 100;
        int second = num % 100 / 10;
        int third = num % 100 % 10;

        num_s = strike(first, second, third);
        num_b = ball(first, second, third);

        if(num_s == 3){
            System.out.println("3스트라이크");
            return true;
        }


        String result = "";

        if(num_s == 0 && num_b == 0){
            result = "낫싱";
        }
        else {
            if (num_b != 0) {
                result += (num_b + "볼 ");
            }
            if (num_s != 0) {
                result += (num_s + "스트라이크");
            }
        }
        System.out.println(result);
        return false;
    }

    int ball(int first, int second, int third){
        int result = 0;
        if(computer.contains(first) && computer.get(0) != first)
            result++;
        if(computer.contains(second) && computer.get(1) != second)
            result++;
        if(computer.contains(third) && computer.get(2) != third)
            result++;

        return result;
    }

    int strike(int first, int second, int third){
        int result = 0;
        if(computer.get(0) == first)
            result++;
        if(computer.get(1) == second)
            result++;
        if(computer.get(2) == third)
            result++;

        return result;
    }
}

package baseball.rule;

import java.util.*;

public class Rule {


    public int numStrike(List <Integer> computer, List<Integer> user){
        int cnt = 0;
        for (int i = 0; i < 3; i++){
            int c = computer.get(i);
            int u = user.get(i);
            if (c == u){
                cnt++;
            }
        }
        return cnt;
    }

    public int numBall(List <Integer> computer, List<Integer> user){
        int c1 = computer.get(0);
        int u1 = user.get(0);
        int c2 = computer.get(1);
        int u2 = user.get(1);
        int c3 = computer.get(2);
        int u3 = user.get(2);

        int cnt = 0;

        if (c1 == u2 || c1 == u3 || c2 == c3 ) {
            cnt++;
        }

        return cnt;
    }

    public void printResult(int s, int b){
        if (s == 0 && b == 0){
            System.out.println("낫싱");
        }
        else if (s > 0 && b > 0){
            System.out.printf("%d볼 %d스트라이크\n",b, s);
        }
        else if (s > 0 && b == 0) {
            System.out.printf("%d스트라이크\n", s);
        }
        else if (s == 0 && b > 0){
            System.out.printf("%d볼\n",b);
        }
    }

}

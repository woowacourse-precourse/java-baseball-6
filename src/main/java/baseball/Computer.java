package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer{

    public List<Integer> count(List<Integer> computer, List<Integer> player){
        Numbers randNums = new Numbers();
        int strike = 0;
        int ball = 0;
        for(int i=0; i<player.size(); i++){
            int target = player.get(i);
            for(int j=0; j<computer.size(); j++){
                int checking = computer.get(j);
                if(i == j && target == checking){
                    strike++;
                } else if (i != j && target == checking) {
                    ball++;
                }
            }
        }
        List<Integer> sb = new ArrayList<>();
        sb.add(strike);
        sb.add(ball);
        return sb;
    }
}

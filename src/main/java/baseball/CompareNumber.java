package baseball;

import java.util.List;

public class CompareNumber {

    public int[] compareNumber(List<Integer> computer, List<Integer> user) {
        int[] strikeBall = new int[2];
        for (int i = 0; i < 3; i++) {
            if(includeNumber(computer,user.get(i))){
                if(computer.get(i).equals(user.get(i))){
                    strikeBall[0]++;
                }else{
                    strikeBall[1]++;
                }
            }

        }
        return strikeBall;
    }

    public Boolean includeNumber(List computer, int user) {
        return computer.contains(user);
    }
}

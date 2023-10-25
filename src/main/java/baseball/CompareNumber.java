package baseball;

import java.util.List;

public class CompareNumber {
    public int[] compareNumber(List<Integer> userNumbers, List<Integer> computerNumbers){
        int strikes = 0;
        int balls = 0;

        for (int i=0; i<userNumbers.size(); i++){
            int userNumber = userNumbers.get(i);
            int computerNumber = computerNumbers.get(i);

            if(userNumber == computerNumber){
                strikes++;
            } else if(computerNumbers.contains(userNumber)){
                balls++;
            }
        }
        return new int[]{strikes, balls};
    }
}

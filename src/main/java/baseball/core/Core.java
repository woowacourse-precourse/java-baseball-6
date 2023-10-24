package baseball.core;

import java.util.List;

public class Core {

    public int countAll(List<Integer> userNumber, List<Integer> computerNumber) {
        int result = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (computerNumber.contains(userNumber.get(i))) {
                result += 1;
            }
        }
        return result;
    }

    public int countStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        int strike = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike += 1;
            }
        }
        return strike;
    }


    public void jugement(int total,int strikes, int balls) {
        if (total == 0) {
            System.out.println("낫싱");
            return;
        } else if (strikes == 0) {
            System.out.printf("%d볼\n",balls);
            return;
        } else if (balls == 0) {
            System.out.printf("%d스트라이크\n",strikes);
            return;
        }
        System.out.printf("%d볼 %d스트라이크\n",balls,strikes);
    }

}

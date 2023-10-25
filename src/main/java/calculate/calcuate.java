package calculate;

import java.util.ArrayList;
import java.util.List;


public class calcuate {

    public static int[] calculateResult(List<Integer> computerNumbers, int[] userNumbers) {
        int strikes = 0;
        int balls = 0;
        List<Integer> usedByComputer = new ArrayList<>();
        List<Integer> usedByUser = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == computerNumbers.get(i)) {
                strikes++;
            } else {
                usedByComputer.add(computerNumbers.get(i));
                usedByUser.add(userNumbers[i]);
            }
        }

        for (int number : usedByUser) {
            if (usedByComputer.contains(number)) {
                balls++;
                usedByComputer.remove(Integer.valueOf(number));
            }
        }


        return new int[]{balls, strikes};
    }


    public static void Hint(int[] result) {
        int ballCount = result[0];
        int strikeCount = result[1];


        String Message = "";

        if (ballCount > 0) {
            Message += ballCount + "볼 ";
        }
        if (strikeCount > 0) {
            Message += strikeCount + "스트라이크";
        }
        if (ballCount == 0 && strikeCount == 0) {
            Message += "낫싱";
        }

        System.out.println(Message);
    }


}

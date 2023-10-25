package calculate;

import java.util.List;


public class calcuate {

    public static int[] calculateResult(List<Integer> computerNumbers, int[] userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == computerNumbers.get(i)) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers[i])) {
                balls++;
            }
        }

        // 중복된 숫자를 고려해 중복 숫자의 볼 개수를 조정
        balls -= strikes;

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

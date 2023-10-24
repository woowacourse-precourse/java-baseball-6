package baseball;

import java.util.ArrayList;

public class Judge {
    private static Alert alert = new Alert();

    public static String judge(ArrayList<Integer> user, ArrayList<Integer> computer) {

        int strike = 0;
        int nothing = 0;

        for (int i = 0; i < 3; i++) {
            if (!computer.contains(user.get(i))) {
                // 숫자가 존재 하지 않으면 낫씽
                nothing += 1;
            } else if (computer.get(i) == user.get(i)) {
                // 숫자가 존재하고 위치가 같으면 strike
                strike += 1;
            }
        }

        int ball = 3 - strike - nothing;

        if (strike == 3) {
            System.out.println(strike + alert.STRIKE);
            return "Strike";
        } else if (ball > 0 && strike == 0) {
            System.out.println(ball + alert.BALL);
        } else if (ball == 0 && strike > 0) {
            System.out.println(strike + alert.STRIKE);
        } else if (ball > 0 && strike > 0) {
            System.out.println(ball + alert.BALL + " " + strike + alert.STRIKE);
        } else if (nothing == 3) {
            alert.nothingMessage();
        }

        return "";
    }
}

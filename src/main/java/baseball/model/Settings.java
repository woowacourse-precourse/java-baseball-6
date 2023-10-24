package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Settings {

    public static List<Integer> computer = new ArrayList<>();
    public static List<Integer> user = new ArrayList<>();
    public static String restart = "1";
    public static int strike = 0;
    public static int ball = 0;

    public static List<Integer> GenerateNumbers() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        return computerNumber;
    }

    public static void Init() {
        user = new ArrayList<>();
        strike = 0;
        ball = 0;
        restart = "1";
    }

}

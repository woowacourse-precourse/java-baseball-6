package baseball.model;
import camp.nextstep.edu.missionutils.*;
import java.util.*;

public class GameData {
    public static final int ENDPOINT = 3;
    public static boolean GAME_STATUS = true;
    public static List<Integer> RANDOM_NUMBERS;

    public static void UPDATE_RANDOM_NUMBERS(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        RANDOM_NUMBERS = computer;
    }
}
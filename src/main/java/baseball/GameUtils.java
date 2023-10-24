package baseball;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameUtils {
    public static List<Integer> compareNumbers(String playerNumber, List<Integer> computerNumber) {
        final int STRIKE = 0;
        final int BALL = 1;
        List<Integer> ballCount = Arrays.asList(0, 0);

        for (int i = 0; i < 3; i++) {
            int computerDigit = computerNumber.get(i);

            for (int j = 0; j < 3; j++) {
                int playerDigit = playerNumber.charAt(j) - '0';
                if (playerDigit == computerDigit) {
                    if (i == j) {
                        ballCount.set(STRIKE, ballCount.get(STRIKE) + 1);
                    } else {
                        ballCount.set(BALL, ballCount.get(BALL) + 1);
                    }
                }
            }
        }

        return ballCount;
    }

    public boolean isValidInputForm(String target){
        boolean flag = true;
        Set<Object> set = new HashSet<>();

        if (target.length() != 3){
            flag = false;
        }
        for (int i = 0; i < target.length(); i++){
            char indexValue = target.charAt(i);
            if (!Character.isDigit(indexValue) || !(('0' < indexValue)&&(indexValue <= '9')))
                flag = false;

            else if(!set.add(indexValue)){
                flag = false;
            }
        }

        return flag;
    }
    public static void printGameTurnResult(List<Integer> gameTurnResult) {
        if (GameUtils.isNothing(gameTurnResult)){
            System.out.print("낫싱");
        }
        if (gameTurnResult.get(1) != 0){
            System.out.print(gameTurnResult.get(1)+"볼 ");
        }
        if (gameTurnResult.get(0) != 0){
            System.out.print(gameTurnResult.get(0)+"스트라이크");
        }
    }

    public static boolean isGameOver(List<Integer> gameTurnResult) {
        return gameTurnResult.get(0) == 3;
    }
    public static boolean isNothing(List<Integer> gameTurnResult) {
        return gameTurnResult.get(0) == 0 && gameTurnResult.get(1) == 0;
    }

}
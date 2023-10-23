package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.run();

    }

    private static class BaseballGame {

        ArrayList<Integer> computerInputNums;

        private void run() {
         
            computerInputNums = randomInputNums();
        }

        private ArrayList<Integer> randomInputNums() {
            ArrayList<Integer> radomNums = new ArrayList<>();
        
            while (radomNums.size() < 3) {
                int randomNum = Randoms.pickNumberInRange(1, 9);
                if (!radomNums.contains(randomNum)) {
                    radomNums.add(randomNum);
                }
            }
            return radomNums;
        }
    }

}

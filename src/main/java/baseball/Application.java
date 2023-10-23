package baseball;

import java.util.ArrayList;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.run();

    }

    private static class BaseballGame {

        ArrayList<Integer> computerInputNums;
        ArrayList<Integer> userInputNums;

        private void run() {
         
            computerInputNums = randomInputNums();
            userInputNums = inputNums();
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

        private ArrayList<Integer> inputNums() {
            String regexpOnlyNum = "^[\\d]*$";
            
            System.out.print("숫자를 입력해주세요 : ");
        
            String readNum = Console.readLine();
            
            if (readNum.length() > 3) {
                throw new IllegalArgumentException("너무 많은 숫자를 입력하였습니다.", null);
            } else if (!Pattern.matches(regexpOnlyNum,readNum)){
                throw new IllegalArgumentException("숫자가 아닌 문자가 입력되었습니다.", null);    
            }
            
            ArrayList<Integer> readuserInputNums = new ArrayList<>();

            for (int i = 0; i < readNum.length(); i++) {
                readuserInputNums.add(Integer.parseInt(readNum.substring(i, i+1)));
            }
            
            if (readuserInputNums.size() != readuserInputNums.stream().distinct().count()) {
                throw new IllegalArgumentException("중복된 숫자를 입력하였습니다.", null);
            }

            return readuserInputNums;
        }
    }

}

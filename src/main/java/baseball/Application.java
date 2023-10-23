package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static List<Integer> computerNumber;
    private static int ballCount;
    private static int strikeCount;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        generateRandomNumbers();
    }


        public static List<Integer> generateRandomNumbers() {
            computerNumber = new ArrayList<>();
            while (computerNumber.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerNumber.contains(randomNumber)) {
                    computerNumber.add(randomNumber);
                }
            }
            return computerNumber;
        }

        public static void compareNumbers(List<Integer> userInput){
            ballCount = 0;
            strikeCount = 0;

            for(int i=0; i<3; i++){
                if(userInput.get(i).equals(computerNumber.get(i))){
                    strikeCount++;
                } else if (computerNumber.contains(userInput.get(i))) {
                    ballCount++;
                }
            }
        }
    }


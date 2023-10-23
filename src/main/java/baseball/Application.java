package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    private static List<Integer> computerNumber;
    private static int ballCount;
    private static int strikeCount;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean continueGame;
        do{
            generateRandomNumbers();
            strikeCount = 0;

            while (strikeCount<3){
                System.out.println("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();

            }
        }
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

        public static boolean isValidInput(String input) {
            if(input.length()!=3){
                throw new IllegalArgumentException("3자리의 자연수를 입력하세요.");
            }

            Set<Character> uniqueChars = new HashSet<>();
            for(char ch:input.toCharArray()){
                if(ch<'1'||ch>'9'||!uniqueChars.add(ch)){
                    throw new IllegalArgumentException("1부터 9까지의 자연수가 중복이 없도록 입력하세요.");
                }
            }
            return true;
        }

    }


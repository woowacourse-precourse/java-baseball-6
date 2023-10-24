package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static final int NUMBER_COUNT = 3;
    private static final String STRIKE = " 스트라이크";
    private static final String BALL = " 볼";
    private static final String NOTHING = "낫싱";

    public static void main(String[] args) {
        boolean keepPlaying;

        do {
            List<Integer> computerNumbers = generateComputerNumbers();
            boolean gameWon;

            System.out.println("숫자 야구 게임을 시작합니다.");

            do {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> userNumbers = parseInput(Console.readLine());

                Map<String, Integer> resultCounts = countStrikesAndBalls(computerNumbers, userNumbers);
                gameWon = resultCounts.get(STRIKE) == NUMBER_COUNT;

                printResult(resultCounts, gameWon);

            } while (!gameWon);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            keepPlaying = Console.readLine().equals("1");

        } while (keepPlaying);
    }

    private static List<Integer> generateComputerNumbers() {
        List<Integer> numbersList= new ArrayList<>();

        while(numbersList.size() < NUMBER_COUNT){
            int randomNumber= Randoms.pickNumberInRange(1 ,9);

            if(!numbersList.contains(randomNumber)){
                numbersList.add(randomNumber);
            }
        }

        return numbersList;
    }

    private static List<Integer> parseInput(String input) {
        if(input.length() != NUMBER_COUNT){
            throw new IllegalArgumentException("잘못된 입력입니다. 세 자리 숫자를 입력하세요.");
        }

        List<Integer> parsedInput= new ArrayList<>();

        for(char c : input.toCharArray()){
            parsedInput.add(Character.getNumericValue(c));
        }

        return parsedInput;
    }

    private static Map<String,Integer> countStrikesAndBalls(List<Integer> computerNumbers,List<Integer> userNumbers){
        Map<String,Integer> resultCount= new HashMap<>();

        int strikeCount=0;
        int ballCount=0;

        for(int i=0;i<NUMBER_COUNT;i++){
            if(userNumbers.get(i).equals(computerNumbers.get(i))){
                strikeCount++;
            }else if(computerNumbers.contains(userNumbers.get(i))){
                ballCount++;
            }
        }

        resultCount.put(STRIKE ,strikeCount);
        resultCount.put(BALL ,ballCount);

        return resultCount;
    }

    private static void printResult(Map<String,Integer> resultsMap ,boolean isGameWon){

        if(isGameWon){
            System.out.println(NUMBER_COUNT + STRIKE + "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if(resultsMap.get(STRIKE)==0 && resultsMap.get(BALL)==0){
            System.out.println(NOTHING);
        }else{
            String result="";

            if(resultsMap.get(STRIKE)>0){
                result += resultsMap.get(STRIKE) + STRIKE;
            }

            if(resultsMap.get(BALL)>0){
                result += " " + resultsMap.get(BALL) + BALL;
            }

            System.out.println(result.trim());
        }
    }
}

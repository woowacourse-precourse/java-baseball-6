package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;
    private static final int DIGITS = 3;

    public static void main(String[] args) {
        boolean restartGame = true;

        while (restartGame) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computerNumbers = generateRandomNumbers();

            boolean gameContinue = true;
            while (gameContinue) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();

                try {
                    List<Integer> userNumbers = inputToNumberList(userInput);
                    String resultMessage = checkNumbers(computerNumbers, userNumbers);

                    System.out.println(resultMessage);

                    if ("3스트라이크".equals(resultMessage)) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        gameContinue = false;
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
            String restartInput = Console.readLine();

            if (!"1".equals(restartInput)) {
                restartGame = false;
            }
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbersPool= new ArrayList<>();
        while(numbersPool.size() < DIGITS){
            int randomNumber= Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if(!numbersPool.contains(randomNumber)){
                numbersPool.add(randomNumber);
            }
        }

        return numbersPool;
    }

    private static List<Integer> inputToNumberList(String userInput) throws IllegalArgumentException{
        if(userInput.length() != DIGITS){
            throw new IllegalArgumentException("잘못된 입력입니다. 세 자리의 숫자를 입력해주세요.");
        }

        ArrayList<Integer> numberList = new ArrayList<>();

        for(char c : userInput.toCharArray()){
            int number = c - '0';
            if(number < MIN_NUMBER || number > MAX_NUMBER || numberList.contains(number)){
                throw new IllegalArgumentException("잘못된 입력입니다. 서로 다른 세 자리의 수를 입력해주세요.");
            }
            numberList.add(number);
        }

        return numberList;
    }



    private static String checkNumbers(List<Integer> computer,List<Integer> player){
        int strikeCount=0;
        int ballCount=0;

        for(int i=0;i<DIGITS;i++){
            if(computer.get(i).equals(player.get(i))){
                strikeCount++;
            }else if(computer.contains(player.get(i))){
                ballCount++;
            }
        }

        if(strikeCount==0 && ballCount==0){
            return "낫싱";
        }

        String result="";
        if(ballCount>0){
            result+=ballCount+"볼 ";
        }
        if(strikeCount>0){
            result+=strikeCount+"스트라이크";
        }

        return result.trim();
    }
}

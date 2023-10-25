package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int NUMBER_LENGTH = 3;
    gradlew.bat clean test
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            playGame();
        } while (isRestart());

        System.out.println("게임을 종료합니다.");
    }
    private static void playGame() {
        List<Integer> computer = generateComputerNumbers();
        boolean isGameOver = false;

        while (!isGameOver) {
            List<Integer> userGuess = getUserGuess();
            String result = calculateResult(computer, userGuess);
            System.out.println(result);

            if (result.equals(NUMBER_LENGTH + "스트라이크")) {
                isGameOver = true;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
    }
    private static List<Integer> generateComputerNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
    private static List<Integer> getUserGuess() {
        String input;
        do{
            input= Console.readLine();
        }while(!isValidInput(input));

        return parseUserInput(input);
    }
    private static boolean isValidInput(String input){
        try{
            Integer.parseInt(input);
            return input.length()==NUMBER_LENGTH && isDistinctDigits(input);
        }catch(NumberFormatException e){
            return false;
        }
    }
    private static boolean isDistinctDigits(String number){
        for(int i=0;i<number.length()-1;i++){
            if(number.substring(i+1).contains(number.substring(i,i+1))){
                return false;
            }
        }
        return true;
    }
    private static List<Integer> parseUserInput(String input){
        List<Integer> digits=new ArrayList<>();
        for(int i=0;i<NUMBER_LENGTH;i++){
            digits.add(Integer.parseInt(input.substring(i,i+1)));
        }
        return digits;
    }
    private static String calculateResult(List<Integer> computer, List<Integer> userGuess) {

        int strikeCount=0,ballCount=0;

        for(int i=0;i<NUMBER_LENGTH;i++){
            int guessDigit=userGuess.get(i);

            if(computer.get(i)==guessDigit){
                strikeCount++;
            }else if(computer.contains(guessDigit)){
                ballCount++;
            }
        }

        if(strikeCount==0 && ballCount==0){
            return "낫싱";
        }else{
            StringBuilder result=new StringBuilder();

            if(strikeCount > 0){
                result.append(strikeCount).append("스트라이크 ");
            }

            if(ballCount > 0 ){
                result.append(ballCount).append("볼");
            }
            return result.toString();
        }
    }
    private static boolean isRestart(){
        String choice;

        do{
            choice=Console.readLine();

        }while(!isValidChoice(choice));

        return choice.equals("1");
    }
    private static boolean isValidChoice(String choice){

        return choice.equals("1") || choice.equals("2");

    }
}

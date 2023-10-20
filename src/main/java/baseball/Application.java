package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application{

    private static List<Integer> computerNumber = new ArrayList<>();

    public static void main(String[] args){
        startGame();
        computerNumber = createComputerRandomNumber();
        playGame();

    }

    private static void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static List<Integer> createComputerRandomNumber(){
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3){
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(number)){
                randomNumbers.add(number);
            }
        }
        return randomNumbers;
    }

    private static void playGame(){
        List<Integer>userNumber = input();
    }

    private static List<Integer> input(){
        List<Integer> inputNumbers;
        System.out.print("숫자를 입력해주세요: ");
        String inputString = readLine();
        //TODO : 입력값 유효성 검사
        inputNumbers = stringIntoIntegerList(inputString);
        return inputNumbers;
    }

    private static List<Integer> stringIntoIntegerList(String inputString){
        List<Integer> integerList = new ArrayList<>();
        for(int i=0;i<inputString.length();i++){
            integerList.add(inputString.charAt(i)-'0');
        }
        return integerList;
    }

}

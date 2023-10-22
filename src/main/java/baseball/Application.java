package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.lang.Exception.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Number makeNumbers = new Number();
        MainGame mainGame = new MainGame();
        Computer com = new Computer();
        boolean again = true;

        while(again){
            List<Integer> answer = makeNumbers.makeRandomNumbers();
            System.out.println(answer);
            List<Integer> player = mainGame.gameStart();
            List<Integer> sb =  com.count(answer, player);
            // 스트라이크 볼 여부로 3개다 맞추면 게임 끝, 아니면 다시 계속
            while(!mainGame.result(sb)){
                System.out.println(mainGame.hint(sb));
                player = mainGame.gameProgress();
                sb = com.count(answer, player);
            }
            again = mainGame.playAgain();
        }

    }
}
/**
 * Number 클래스 처음 숫자를 만들어 냄 (완료)
 * Computer 클래스 입력받은 숫자로 strike, ball 판단 (완료)
 * Game 클래스 strike, ball 가지고 게임의 완료 여부 (완료)
 * Input 클래스 게임의 진행을 위해 입출력을 담당
 * Exception 클래스 예외를 담당하는 클래스
 */
class Number{
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;

    public List<Integer> makeRandomNumbers(){
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
class Computer{

    public List<Integer> count(List<Integer> computer, List<Integer> player){
        Number randNums = new Number();
        int strike = 0;
        int ball = 0;
        for(int i=0; i<player.size(); i++){
            int target = player.get(i);
            for(int j=0; j<computer.size(); j++){
                int checking = computer.get(j);
                if(i == j && target == checking){
                    // 숫자도 맞고 자릿수도 맞고
                    strike++;
                } else if (i != j && target == checking) {
                    // 숫자는 맞는데 자릿수가 안맞아
                    ball++;
                }
            }
        }
        List<Integer> sb = new ArrayList<>();
        sb.add(strike);
        sb.add(ball);
        return sb;
    }
}
class MainGame {
    private final Exception exception = new Exception();
    public String hint(List<Integer> sb){
        if(sb.get(0) == 0 && sb.get(1) == 0){
            return "낫싱";
        }else if(sb.get(0) == 0){
            return sb.get(1) + "볼";
        }else if(sb.get(1) == 0){
            return sb.get(0)+ "스트라이크";
        }
        return sb.get(1) + "볼" + sb.get(0)+ "스트라이크";
    }
    public boolean result(List<Integer> sb){
        if(sb.get(0) == 3){
            return true;
        }else{
            return false;
        }
    }
    public List<Integer> gameStart(){

        View.printStart();
        String player = Console.readLine();
        exception.checkInputValidation(player);
        View view = new View();
        return view.strToList(player);
    }
    public boolean playAgain(){
        View.printResult();
        String playEnd = Console.readLine();
        return playEnd.equals("1");
    }
    public List<Integer> gameProgress(){
        View.printNumber();
        String player = Console.readLine();
        exception.checkInputValidation(player);
        View view = new View();
        return view.strToList(player);
    }


}
class View{
    private static final String GAME_START_MESSAGE = "게임을 시작합니다.";
    private static final String GAME_START_INPUT_MESSAGE = "숫자를 입력해주세요: ";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_END_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    private static final String GAME_NUMBER = "숫자를 입력해주세요";
    public List<Integer> strToList(String player){
        String[] playerInput = player.split("");
        List<Integer> list = new ArrayList<>();
        for(String s : playerInput){
            list.add(Integer.parseInt(s));
        }
        System.out.println(list);
        return list;
    }
    public static void printStart(){
        System.out.println(GAME_START_MESSAGE);
        System.out.println(GAME_START_INPUT_MESSAGE);
    }
    public static void printResult(){
        System.out.println(GAME_END_MESSAGE);
        System.out.println(GAME_END_INPUT_MESSAGE);
    }
    public static void printNumber(){
        System.out.println(GAME_NUMBER);
    }
}
class Exception{
    private static final String REGEX  = "[0-9]+";
    public void checkInputValidation(String s){
        if(s.length() < 3 || !s.matches(REGEX)){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}

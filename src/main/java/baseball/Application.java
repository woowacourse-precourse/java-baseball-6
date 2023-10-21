package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.ArrayList;
public class Application {
    private static final int NUM_COUNT = 3;
    private static final int Min_NUM = 1;
    private static final int Max_NUM = 9;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do{
            playGame();
            System.out.println("게임 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        }while("1".equals(Console.readLine()));
    }


    private static void playGame(){
        List<Integer> computerNums = generateRandomNumbers();
        List<Integer> userNums = null;

        System.out.println("숫자 야구 게임을 시작합니다.");

        do{
            try{
                System.out.print("숫자를 입력해주세요 : ");
                userNums = convertInputToNumberList(Console.readLine());
            }catch(IllegalArgumentException e){ // ex. 네 자리 숫자 입력받을 때
                System.out.println("잘못된 값입니다. 다시 시도하세요.");
                continue;
            }
            printResult(getStrikeCount(computerNums, userNums), getBallCount(computerNums, userNums));
        }while(!computerNums.equals(userNums));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


    private static List<Integer> generateRandomNumbers(){
        List<Integer> numbers = new ArrayList<>();

        return numbers;
    }


    private static List<Integer> convertInputToNumberList(String input){
        List<Integer> numberList = new ArrayList<>();


        return numberList;
    }


    private static int getStrikeCount(List<Integer> computer, List<Integer> user){
        int strikeCnt = 0;


        return strikeCnt;
    }


    private static int getBallCount(List<Integer> computer, List<Integer> user){
        int ballCnt = 0;

        return ballCnt - getStrikeCount(computer, user);
    }

    
    private static void printResult(int strikes, int balls){


    }

}

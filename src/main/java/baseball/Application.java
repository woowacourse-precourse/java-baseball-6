package baseball;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {

    private static Integer[] orderOfNumbers = new Integer[10];
    private static List<Integer> computerNumbers = new ArrayList<>();
    private static String userNumbers;
    public static void main(String[] args) {
        // 시작
        System.out.println("숫자 야구 게임을 시작합니다.");
        GameStatus gameStatus = GameStatus.START;

        while(gameStatus == GameStatus.START){
            // 초기화
            init();

            // 컴퓨터 수 생성
            generateComputerNumbers();

            // 사용자 수 입력
            getUserInputNumber();
        }
    }

    public enum GameStatus{
        NONE,
        START,
        END
    }

    public static void init(){
        Arrays.fill(orderOfNumbers, 0);
        computerNumbers.clear();
        userNumbers = "";
    }

    public static void generateComputerNumbers(){
        int orderCnt = 1;

        while(computerNumbers.size() < 3){

            int randomNumber = Randoms.pickNumberInRange(1,9);

            if(!computerNumbers.contains(randomNumber)){
                computerNumbers.add(randomNumber);
                orderOfNumbers[randomNumber] = orderCnt++;
            }
        }
    }

    public static void getUserInputNumber(){
        System.out.println("숫자를 입력해주세요 : ");
        userNumbers = Console.readLine();

        if(!isValidUserNumber(userNumbers)) {
            System.out.println("잘못된 입력값입니다. 프로그램을 종료합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static boolean isValidUserNumber(String number){
        if(number.matches("[1-9]{3}"))
            return true;

        return false;
    }
}

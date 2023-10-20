package baseball;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

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
}

package baseball;
import java.util.List;
import static baseball.Functions.*;


public class Application {
    public static void main(String[] args) {

        while(true){
            baseball(); //숫자야구 플레이

            // 재시작 여부
            int restartNum = getRestartNum();
            //1을 받으면 종료
            if(restartNum == 2){
                break;
            }
        }
    }
    static void baseball(){
        // 시작 안내 문구
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터숫자 (맞추어야할 숫자)
        List<Integer> computerNum = generateRandomNumber();

        while(true){
            try{
                // 사용자로부터 입력 받기
                List<Integer> userGuess = getUserGuess();

                // 입력 숫자와 컴퓨터 숫자 비교
                int[] result = compareNumbers(computerNum, userGuess);

                // 결과 출력
                printResult(result);

                // 게임 종료 조건 확인
                if (result[0] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }

            }catch  (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("잘못된 값이 입력되었습니다. 게임을 종료합니다.");
                break;
            }
        }
    }
}

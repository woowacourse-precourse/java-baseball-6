package baseball;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        User user = new User();

        while(true) {
            System.out.println("숫자를 입력해주세요 : ");
            String input = readLine();

            user.selectUserNum(input);
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startGame();//startGame() 호출
    }
}

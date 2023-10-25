package baseball.view;
/*
 * 출력될 메세지를 여기에 작성
 * */
import camp.nextstep.edu.missionutils.Console;
public class MessageView {
    public static void start_M(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static String input_M(){
        System.out.println("숫자를 입력해 주세요: ");
        return Console.readLine();
    }
    public static void ball_M(){
        System.out.println("볼");
    }
    public static void strike_M(){
        System.out.println("스트라이크");
    }
    public static void nothing_M(){
        System.out.println("낫싱");
    }
    //갯수
    public static void printCount(int count){
        System.out.print(count);
    }
    public static void final_M(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public static String menu_M(){
        System.out.println("게임을 새로 시작하려면" +NumberView.Restart_num+", 종료하려면 "+NumberView.Finish_num+"를 입력하세요.");
        return Console.readLine();
    }
}

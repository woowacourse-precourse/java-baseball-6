package baseball;

import baseball.entity.PlayerImpl;
import baseball.impl.Player;
import camp.nextstep.edu.missionutils.Console;

public class View {
    static Player player = new PlayerImpl();
    private View(){

    }
    public static void StartGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static String InputMessage(){
        System.out.print("숫자를 입력해주세요 : ");
        String input =  Console.readLine();
        player.gameInputCheck(input);
        return input;
    }
    public static boolean ContinueMessage(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input =  Console.readLine();
        return player.continueInputCheck(input);
    }
    public static boolean OutputMessage(Long Ball,Long Strike){
        String BallMessage = BallMessageFormat(Ball);
        String StrikeMessage = StrikeMessageFormat(Strike);
        if(BallMessage.isEmpty() && StrikeMessage.isEmpty()){
            System.out.println("낫싱");
            return false;
        }

        if(!BallMessage.isEmpty() && !StrikeMessage.isEmpty()){
            System.out.println(BallMessage+" "+StrikeMessage);
            return false;
        }
        System.out.println(BallMessage+StrikeMessage);
        return Strike.equals(3L);
    }
    private static String BallMessageFormat(Long Ball){
        if(Ball.equals(0L)){
            return "";
        }
        return Ball +"볼";
    }
    private static String StrikeMessageFormat(Long Strike){
        if(Strike.equals(0L)){
            return "";
        }
        return Strike +"스트라이크";
    }
    public static void GoalMessage(){
        System.out.println("3개의 숫자를 모두 맞히셧습니다! 게임 종료");
    }
}

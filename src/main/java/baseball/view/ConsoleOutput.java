package baseball.view;

public class ConsoleOutput {


    /**
     * 게임 시작 문구
     */
    public static void init(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    /**
     * 입력 문구
     */
    public static void requestInput(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    /**
     * 힌트 문구
     */
    public static void displayHint(String hint){
        System.out.print(hint);
    }


}

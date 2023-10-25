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
        System.out.println(hint);
    }

    /**
     * 승리 문구
     */
    public static void displayVictory(){
        System.out.println("3스트라이크\n 3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


    /**
     * 재시작 문구
     */
    public static void requestRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

package baseball;

public class GameOutput {
    public static void displayStartPrompt() { System.out.println("숫자 야구 게임을 시작합니다."); }
    public static void displayResumePrompt(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public static void displayQuitPrompt(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public static void displayHint(int strike, int ball){
        if (strike == 0 && ball == 0){
            System.out.print("낫싱");
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.print("\n");
    }
    public static void displayInputNumberPrompt(){
        System.out.print("숫자를 입력해주세요 : ");
    }
}

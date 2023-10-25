package baseball.view;


public class OutputView {
    private OutputView() {
    }
    public static void outputForGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void outputForGameValueInput(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void outputForGameSuccess(String result){
        System.out.println(result);
    }

    public static void outputForBallScore(String result){
        System.out.println(result);
    }

    public static void outputForStrikeScore(String result){
        System.out.println(result);
    }

    public static void outputForNothingScore(String result){
        System.out.println(result);
    }

    public static void outputForBallAndStrikeScore(String result){
        System.out.println(result);
    }

    public static void outputForRetryCondition(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

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

    public static void outputForGameSuccess(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void outputForBallScore(int ball_count){
        System.out.print(ball_count+"볼");
    }

    public static void outputForStrikeScore(int strike_count){
        System.out.println(strike_count+"스트라이크");
    }

    private static void outputForSpace(){
        System.out.print(" ");
    }

    public static void outputForNothingScore(){
        System.out.println("낫싱");
    }

    public static void outputForBallAndStrikeScore(int ball_count,int strike_count){
        outputForBallScore(ball_count);
        outputForSpace();
        outputForStrikeScore(strike_count);
    }
}

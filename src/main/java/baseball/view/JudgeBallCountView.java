package baseball.view;public class JudgeBallCountView {
    public static void judgeNothing(){
        System.out.println("낫싱");
    }
    public static void judgeBall(int count){
        System.out.print(count+"볼 ");
    }
    public static void judgeStrike(int count){
        System.out.print(count+"스트라이크");
    }
}

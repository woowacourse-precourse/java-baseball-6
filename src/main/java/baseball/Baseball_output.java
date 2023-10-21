package baseball;

public class Baseball_output {

    public static void printStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        return ;
    }
    public static void printNothing(){
        System.out.println("낫싱");
        return ;
    }
    public static void printBall(int numOfBall){
        System.out.println(numOfBall+"볼");
        return ;
    }
    public static void printBallAndStrike(int numOfBall, int numOfStrike){
        System.out.println(numOfBall+"볼 "+numOfStrike+"스트라이크");
        return ;
    }
    public static void printStrike(int numOfStrike){
        System.out.println(numOfStrike+"스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return ;
    }
    public static void printRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return ;
    }

}

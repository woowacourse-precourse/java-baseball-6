package baseball;

public class OutputPrint {
    public static void printResult(int strike, int ball){
        if(strike != 0){
            if(ball != 0){
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
            else{
                System.out.println(strike + "스트라이크");
            }
        }
        else if(ball != 0){
            System.out.println(ball + "볼");
        }
        else{
            System.out.println("낫싱");
        }
    }
    public static void printEnd(int strike){
        System.out.println(strike + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

package View;

public class GameResult {
    //수정
    public static void PrintResult(int strike,int ball,boolean judge){
        if(judge){
            System.out.println("낫띵");
            return;
        }
        System.out.println(strike+" 스트라이크 "+ball+" 볼");
    }
}

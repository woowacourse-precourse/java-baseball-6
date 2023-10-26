package baseball.view;

public class SystemMessage {
    public static void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다");
    }

    public static void pintResult(int[] result){
        if(result[0]==0&&result[1]!=0){
            System.out.println(result[1]+"스트라이크");
        }
        if(result[0]!=0&&result[1]==0){
            System.out.println(result[0]+"볼");
        }
        if(result[0]!=0&&result[1]!=0){
            System.out.println(result[0]+"볼 "+result[1]+"스트라이크");
        }
        if(result[0]==0&&result[1]==0){
            System.out.println("낫싱");
        }
    }


    public static void printGameSetMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

package baseball.view;

public class OutputView {

    public static void printStartGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void Alertball(){
        System.out.println("볼");
    }

    public static void AlertballStrike(){
        System.out.print("볼 ");
    }

    public static void AlertStrike(){
        System.out.println("스트라이크");
    }

    public static void AlertNothing(){
        System.out.println("낫싱");
    }

    public static void AlertCount(int count){
        System.out.print(count);
    }

    public static void AlertSuccess(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}

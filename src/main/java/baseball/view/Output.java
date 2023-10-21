package baseball.view;

public class Output {
    public static void startMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void ballMessage(){
        System.out.println("볼 ");
    }

    public static void strikeMessage(){
        System.out.println("스트라이크");
    }
    public static void nothingMessage(){
        System.out.println("낫싱");
    }

    public static void numberCount(int count){
        System.out.println(count);
    }
    
    public static void gameOverMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

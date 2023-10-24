package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int restart=1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        do{
            BaseballGame baseballGame=new BaseballGame();
            restart=baseballGame.startBaseballGame();
        }while(restart==1);
    }
}
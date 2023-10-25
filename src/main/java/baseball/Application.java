package baseball;

public class Application {
    private static String firstMent = "숫자 야구 게임을 시작합니다.";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //Singleton pattern으로 gameManager 객체 생성
        GameManager gameManager = GameManager.getInstance();

        //게임 시작
        System.out.println(firstMent);

        try {
            gameManager.gameStart();
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


    }
}

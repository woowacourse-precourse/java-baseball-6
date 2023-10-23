package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final gameManage gameManage = new gameManage();
        try {
            gameManage.init();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }


}

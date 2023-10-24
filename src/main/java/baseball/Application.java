package baseball;


public class Application {
    public static void main(String[] args) {
        //게임 시작
        boolean flag = true;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (flag) {
            NumberBaseball p = new NumberBaseball();
            flag = p.run();
        }
    }
}

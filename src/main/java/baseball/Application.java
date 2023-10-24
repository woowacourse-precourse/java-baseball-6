package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game baseball = new Game();
        int game = 1;
        while(game==1){ // 게임 재시작 할 수 있는 반복문 , 안한다고 하면 탈출
            game= baseball.run();
        }
    }
}

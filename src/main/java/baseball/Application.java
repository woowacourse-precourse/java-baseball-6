package baseball;

public class Application {
    public static void main(String[] args){

        System.out.println("숫자 야구 게임을 시작합니다.");

        Baseball baseball = new Baseball();
        baseball.playBaseball(3); // 매개변수는 컴퓨터가 생성할 숫자의 길이

    }
}

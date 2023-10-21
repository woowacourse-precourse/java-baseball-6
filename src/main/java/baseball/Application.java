package baseball;

public class Application {
    public static boolean onProcess = false;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 프로그램 시작
        Init.initialize();

        // 질답 페이즈
        while (onProcess){
            Guess.GuessInput();
        }

    }
}

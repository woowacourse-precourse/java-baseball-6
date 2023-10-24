package baseball;

public class Application {
    public static boolean onProcess;
    public static boolean playGame;

    public static void main(String[] args) {
        playGame = true;
        // TODO: 프로그램 구현
        while (playGame) {
            // 프로그램 시작
            Init.initialize();

            // 질답 페이즈
            while (onProcess){
                Guess.guess();
            }

            // 종료 페이즈
            EndPhase.ending();
        }
        System.out.println(Text.endText);
    }
}
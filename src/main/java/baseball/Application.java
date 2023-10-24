package baseball;

public class Application {
    public static void main(String[] args) {

        Constant constant = new Constant(); // 상수 클래스 생성
        CheckForm checkForm = new CheckForm(constant.getGAME_RESTART(), constant.getGAME_END()); // 인증용 클래스 객체 생성
        IO io = new IO(); // 입출력 객체 생성
        Game game = new Game(io); // 게임 객체 생성

        GameConfiguration gameConfiguration = new GameConfiguration(constant, checkForm, game); //의존성 주입 클래스(게임 관련만)
        Runner runner = new Runner(gameConfiguration, io);

        runner.run(); //게임 실행
    }
}

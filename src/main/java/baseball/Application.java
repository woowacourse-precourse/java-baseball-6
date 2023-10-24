package baseball;

public class Application {
    public static void main(String[] args) {
        AppConfigure appConfigure = new AppConfigure();

        BaseballApp baseballApp = new BaseballApp(
                appConfigure.randomNum(),
                appConfigure.inputNum(),
                appConfigure.checkNum()
        );

        baseballApp.start();
    }
}

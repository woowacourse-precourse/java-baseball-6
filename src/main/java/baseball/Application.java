package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    private static boolean askContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = readLine();
        Utils.validateRestartOrExitInput(userInput);
        return isContinue(userInput);
    }

    private static boolean isContinue(String userInput) {
        return !userInput.equals("2");
    }
}

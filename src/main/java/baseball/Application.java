package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 랜덤숫자 생성
        R_numGenerate rnum = new R_numGenerate();
        // 사용자가 숫자를 입력할 수 있게 구현
        Input_user userInput = new Input_user();
        try {
            userInput.player();
        } catch (Exception e) {
            System.out.println("옳지 않은 형식입니다.");
            userInput.player();
        }

    }
}

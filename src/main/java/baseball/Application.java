package baseball;

public class Application {
    public static void main(String[] args) {

        String theAnswer = AnswerController.makeAnswer();
        System.out.println("answer: " + theAnswer);    // 테스트용
    }
}
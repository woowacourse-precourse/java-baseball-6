package baseball;

public class Application {
    public static void main(String[] args) {
        CreatingAnswer answerMachine = new CreatingAnswer();
        int randomAnswer = answerMachine.getRandomNumber();
        System.out.println(randomAnswer);
    }
}

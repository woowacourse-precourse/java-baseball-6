package baseball;

public class Game {
    Computer computer = new Computer();
    Input input = new Input();
    String hint;
    int myNumber;

    public void playGame() throws IllegalArgumentException {
        do {
            myNumber = input.GameInput();
            hint = computer.CompareNumber(myNumber);
            System.out.println(hint);

        } while (!hint.equals("3스트라이크"));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

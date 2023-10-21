package baseball;

public class Game {
    Computer computer;
    String hint;
    int myNumber;

    Game() {
        PutComputer(new Computer());
    }

    void PutComputer(Computer computer) {
        this.computer = computer;
    }

    void InitData() {
        computer.InitNumber();
    }

    public void PlayGame() throws IllegalArgumentException {
        do {
            myNumber = Input.GameInput();
            hint = computer.CompareNumber(myNumber);
            System.out.println(hint);
        } while (!hint.equals("3스트라이크"));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

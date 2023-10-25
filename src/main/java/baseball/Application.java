package baseball;

public class Application {
    public static void main(String[] args) {
 
        boolean start = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (start) {

            Player computer = new ComputerPlayer();
            Player human = new HumanPlayer();
            Judge judge = new Judge(computer, human);

            start = judge.startGame();
        }
    }
}

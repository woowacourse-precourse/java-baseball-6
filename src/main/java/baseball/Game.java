package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private boolean gameFinished;
    private List<Integer> numbers;
    private Referee referee;
    private Player player;

    public Game(){
        this.numbers = generateRandomNumbers();
        this.gameFinished = false;
        this.referee = new Referee();
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> generatedNumbers = new ArrayList<>();
        while (generatedNumbers.size() < 3) generatedNumbers.add(Randoms.pickNumberInRange(1, 9));
        return generatedNumbers;
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void gameRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String command = Console.readLine();
        this.gameFinished = isGameEndCommand(command);
    }

    private boolean isGameEndCommand(String command) {
        return "2".equals(command);
    }

    public void gameClear(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public Player createPlayer() {
        return this.player = new Player();
    }
    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public Player getPlayer(){
        return this.player;
    }

    public Referee getReferee(){
        return this.referee;
    }

    public boolean isGameFinished() {
        return this.gameFinished;
    }
}
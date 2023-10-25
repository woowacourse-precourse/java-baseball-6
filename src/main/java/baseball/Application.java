package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

class Game {
    static class Computer{
        private List<Integer> computerNumList;
        public List<Integer> getComputerNumList(){
            return computerNumList;
        }
        public void setComputerNumList(List<Integer> computerNumList){
            computerNumList = new ArrayList<>();
            while (computerNumList.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerNumList.contains(randomNumber)) {
                    computerNumList.add(randomNumber);
                }
            }
            this.computerNumList = computerNumList;
        }
    }
    static class Player{
        private List<Integer> playerNumList;
        public List<Integer> getPlayerNumList(){
            return playerNumList;
        }
        public void setPlayerNumList(List<Integer> playerNumList){
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            playerNumList = new ArrayList<>();

            if(input.length() != 3) {
                throw new IllegalArgumentException("3자리의 정수를 입력하세요");
            }
            for (int i = 0; i < input.length(); i++) {
                int num = input.charAt(i) - '0';
                if(num == 0) {
                    throw new IllegalArgumentException("1부터 9까지의 수를 입력하세요");
                }
                if(playerNumList.contains(num)) {
                    throw new IllegalArgumentException("서로 다른 정수를 입력하세요");
                }
                playerNumList.add(num);
            }
            this.playerNumList = playerNumList;
        }
    }
    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }
    public void playGame(){
        Computer computer = new Computer();
        List<Integer> computerNumList = new ArrayList<>();
        computer.setComputerNumList(computerNumList);
        computerNumList = computer.getComputerNumList();
        while (true) {
            Player player = new Player();
            List<Integer> playerNumList = new ArrayList<>();
            player.setPlayerNumList(playerNumList);
            playerNumList = player.getPlayerNumList();
            int strike = 0;
            int ball = 0;
            for (int i = 0; i < playerNumList.size(); i++) {
                int playerNum = playerNumList.get(i);
                if(computerNumList.contains(playerNum)){
                    if(computerNumList.indexOf(playerNum) == i){
                        strike += 1;
                    }else{
                        ball += 1;
                    }
                }
            }
            hint(ball, strike);
            if(strike == 3){
                break;
            }
        }
        endGame();
    }
    public void endGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String opr = Console.readLine();
        if(opr.equals("1")){
            playGame();
        }else{
            System.out.println("게임을 종료합니다");
        }
    }
    public void hint(int ball, int strike){
        if(ball == 0 && strike == 0){
            System.out.println("낫싱");
        }else{
            if(ball == 0) System.out.println(strike + "스트라이크 ");
            else if (strike == 0) System.out.println(ball + "볼 ");
            else System.out.println(ball + "볼 " + strike + "스트라이크 ");
        }
    }

}
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        game.startGame();
    }
}

package baseball;
import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.List;

public class Application {


    public static void main(String[] args) {
        int strike = 0;
        int ball = 0;
        Application app = new Application();
        ArrayList<Integer> computerNumbers = ComputerNumbers();

        while(strike < 3) {
            strike = 0;
            ball = 0;
            ArrayList<Integer> playerNumbers = PlayerNumbers();
            for(int i=0; i<computerNumbers.size(); i++) {
                if(computerNumbers.get(i) == playerNumbers.get(i)) {
                    strike += 1;
                } else if (
                        (computerNumbers.contains(playerNumbers.get(i))) && (computerNumbers.get(i) != playerNumbers.get(i))
                ) {
                    ball += 1;
                }
            }
            if(strike != 0 && ball != 0) {
                System.out.println(ball+"볼 "+strike+"스트라이크");
            } else if (strike == 0 && ball != 0) {
                System.out.println(ball+"볼");
            } else if(strike != 0 && ball == 0) {
                System.out.println(strike+"스트라이크");
            } else {
                System.out.println("낫싱");
            }
            if(strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            }
        }
    }

    public static ArrayList<Integer> ComputerNumbers() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static ArrayList<Integer> PlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerNumber = Console.readLine();
        String[] playerNumberArray = playerNumber.split("");

        ArrayList<Integer> playerNumbers = new ArrayList<>();
        for(int i=0; i<playerNumberArray.length; i++) {
            playerNumbers.add(Integer.parseInt(playerNumberArray[i]));
        }
        return playerNumbers;
    }
}

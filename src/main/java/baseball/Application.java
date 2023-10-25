package baseball;
import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        try {
            Game();
            StopOrRestart();
        } catch(PlayerNumbersException e) {
            System.out.println("!!서로 다른 세자리 수를 공백 없이 입력해주세요.!!");
        } catch(StopOrRestartException se) {
            System.out.println("!!1,2 중 하나의 숫자를 입력해주세요.!!");
        }

    }

    public static void Game() throws PlayerNumbersException {
        int strike = 0;
        int ball = 0;
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
            }
        }
    }

    public static void StopOrRestart() throws PlayerNumbersException, StopOrRestartException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String menuNumber = Console.readLine();
        if(menuNumber.trim().equals("2")) {
            return;
        } else if (menuNumber.trim().equals("1")) {
            Game();
        } else {
            throw new StopOrRestartException("잘못된 메뉴 형식을 입력하셨습니다.");
        }
    }
    public static ArrayList<Integer> ComputerNumbers() {

        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static ArrayList<Integer> PlayerNumbers() throws PlayerNumbersException {
        System.out.print("숫자를 입력해주세요 : ");
        String playerNumber = Console.readLine();
        String[] playerNumberArray = playerNumber.split("");

        if(!threeLetters(playerNumberArray))
            throw new PlayerNumbersException("잘못된 숫자 형식을 입력하셨습니다.");

        ArrayList<Integer> playerNumbers = new ArrayList<>();
        for(int i=0; i<playerNumberArray.length; i++) {
            playerNumbers.add(Integer.parseInt(playerNumberArray[i]));
        }
        return playerNumbers;
    }

    static boolean threeLetters(String[] arr) {
        if(arr.length == 3) {
            return true;
        } else {
            return false;
        }
    }

}

class PlayerNumbersException extends Exception {
    PlayerNumbersException(String msg) { super(msg); }
}

class StopOrRestartException extends Exception {
    StopOrRestartException(String msg) { super(msg); }
}

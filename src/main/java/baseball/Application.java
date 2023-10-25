package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}
	
	class ComputerNum {
	    List<Integer> computerNum;

	    public ComputerNum() {
	        computerNum = pickRandomNum();
	    }

	    private List<Integer> pickRandomNum() {
	        List<Integer> numList = new ArrayList<>();
	        
	        while(numList.size() <3) {
	        	int newNum = Randoms.pickNumberInRange(1, 9);
	        	if(numList.contains(newNum)) continue;
	        	numList.add(newNum);
	        }
	        return numList;
	    }
	}
	
	class PlayerNum{
	    List<Integer> playerNum;

	    public PlayerNum(){
	        System.out.print("숫자를 입력해주세요 : ");
	        playerNum = playerInput();
	    }

	    private List<Integer> playerInput(){
	        String playerInputString = Console.readLine();
	        checkInput(playerInputString);
	        return integerListConversion(playerInputString);
	    }

	    private void checkInput(String playerInputString) {
	    	if (!isOneToNineNum(playerInputString))
	    		throw new IllegalArgumentException();
	        if (playerInputString.length() != 3)
	            throw new IllegalArgumentException();
	        if (!allDifferentNum(playerInputString))
	            throw new IllegalArgumentException();
	    }

	    private List<Integer> integerListConversion(String playerInputString) {
	        List<Integer> playerInput = new ArrayList<>();
	        for (int i = 0; i < 3; i++) {
	            char charNum = playerInputString.charAt(i);
	            int intNum = charNum - '0';
	            playerInput.add(intNum);
	        }
	        return playerInput;
	    }
	    private boolean isOneToNineNum(String playerInputString) {
	        String numbers = "123456789";
	        for (int i = 0; i < 3; i++) {
	            char check = playerInputString.charAt(i);
	            if (numbers.indexOf(check) == -1)
	                return false;
	        }
	        return true;
	    }

	    private boolean allDifferentNum(String playerInputString) {
	        char first = playerInputString.charAt(0);
	        char second = playerInputString.charAt(1);
	        char third = playerInputString.charAt(2);
	        return ((first != second) && (second != third) && (third != first));
	    }
	}
}
class GameSet{
    List<Integer> ComputerNum;
    List<Integer> PlayerNum;
    public GameSet() {
        ComputerNum = new ComputerNum().computerNum;
        PlayerNum = new PlayerNum().playerNum;
        GamePlay gamePlay = new GamePlay(ComputerNum, PlayerNum);
        while (!gamePlay.numCheck) {
            PlayerNum = new PlayerNum().playerNum;
            gamePlay = new GamePlay(ComputerNum, PlayerNum);
        }
        new GameEnd();
    }
}

class GamePlay {
    boolean numCheck;
    GamePlay(List<Integer> ComputerNum, List<Integer> PlayerNum) {
    	getResult(ComputerNum, PlayerNum);
        numCheck = numCheck(ComputerNum, PlayerNum);
    }

    private boolean numCheck(List<Integer> ComputerNum, List<Integer> PlayerNum) {
        int n = ComputerNum.size();
        for (int i = 0; i < n; i++)
            if (ComputerNum.get(i) != PlayerNum.get(i))
                return false;
        return true;
    }

    private void getResult(List<Integer> ComputerNum, List<Integer> PlayerNum) {
        int strike = checkStrike(ComputerNum, PlayerNum);
        int ball = checkBall(ComputerNum,PlayerNum);
        printResult(strike, ball);
    }

    private int checkStrike(List<Integer> ComputerNum, List<Integer> PlayerNum) {
        int strike = 0;
        int n = ComputerNum.size();
        for (int i = 0; i < n; i++) {
            if (PlayerNum.get(i) == ComputerNum.get(i))
                strike++;
        }
        return strike;
    }

    private int checkBall(List<Integer> ComputerNum, List<Integer> PlayerNum) {
        int ball = 0;
        int n = ComputerNum.size();
        for (int i = 0; i < n; i++) {
            if (ComputerNum.contains(PlayerNum.get(i)))
                ball++;
        }
        int strike = checkStrike(ComputerNum, PlayerNum);
        return ball - strike;
    }

    private void printResult(int strike, int ball) {
        if ((strike == 0) && (ball == 0)) {
            System.out.println("낫싱");
            return;
        }
        if ((strike == 0) && (ball != 0)) {
            System.out.println(ball + "볼");
            return;
        }
        if ((strike != 0) && (ball == 0)) {
            System.out.println(strike + "스트라이크");
            return;
        }
        if ((strike != 0) && (ball != 0)) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}



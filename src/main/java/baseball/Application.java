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



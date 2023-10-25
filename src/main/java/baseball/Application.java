package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

class MyIO {
    public static String reInputStr() {
        String inputStr = null;
        try {
            inputStr = Console.readLine();      
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        if (!inputStr.equals("1") && !inputStr.equals("2")) {
            throw new IllegalArgumentException();
        }
		return inputStr;
    }
    public static String getInputStr() {
        String inputStr = null;
        try {
            inputStr = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        MyIO.checkInputValue(inputStr);
        return inputStr;
    }
    static void checkInputValue(final String str){
        if (!checkInputLength(str)) {
            throw new IllegalArgumentException();
        }
        if (!checkValidNumberRange(str)) {
            throw new IllegalArgumentException();
        }
    }
    static boolean checkInputLength(final String str) {
		return str.length() == 3;
	}
    static boolean checkValidNumberRange(final String str) {
    char[] chars = str.toCharArray();
    for (char c : chars) {
        int num = Character.getNumericValue(c);
        if (num >= 1 && num <= 9) {
            continue;
        }
        else {
            return false;
        }
    }
    return true;
}
}

class NumberBaseballGame {
    private boolean gamming;    // 게임중인지 판별

    // 생성자
    public NumberBaseballGame() {
        this.gamming = false;
    }

    // utils
    private int toInt(char ch) {
        return ch - '0';
    }

    // 숫자 입력 및 상대방 숫자 생성
    private List<Integer> getPlayerNumList() {
        List<Integer> player = new ArrayList<>();

        System.out.print("숫자를 입력해 주세요 : ");
        
        String numStr = MyIO.getInputStr();

        for(int i = 0; i < numStr.length(); i++) {
            int number = toInt(numStr.charAt(i));
            player.add(number);
        }

        return player;
    }

    private List<Integer> getComputerNumList() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    // 볼, 스트라이크 개수 판단
    private boolean judgement(List<Integer> player, List<Integer> computer) {
        int ballCount = 0;
        int strikeCount = 0;
        StringBuilder gameResultStr = new StringBuilder();

        for(int i = 0; i < 3; i++) {
            int playerNum = player.get(i).intValue();
            int computerNum = computer.get(i).intValue();

            if(playerNum == computerNum) {
                strikeCount++;
                continue;
            }
            
            if(computer.contains(playerNum) == true) {
                ballCount++;
            }
        }

        if(ballCount == 0 && strikeCount == 0) {
            gameResultStr.append("낫싱");
        }
        else {
            if(ballCount > 0) {
                gameResultStr.append(ballCount + "볼");
            }
            if(strikeCount > 0) {
                if(gameResultStr.isEmpty() == false) {
                    gameResultStr.append(" ");
                }

                gameResultStr.append(strikeCount + "스트라이크");
            }
        }
        
        System.out.println(gameResultStr);

        return (strikeCount == 3 ? true : false);
    }

    // 리겜 요청
    private boolean ReqReGame() {
        String inputStr = MyIO.reInputStr();
        
        return (Integer.parseInt(inputStr) == 1 ? true : false);
    }

    // 게임 시작
    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        gamming = true;
        List<Integer> computer = getComputerNumList();
        while(gamming == true) {
            //System.out.println(computer);
            List<Integer> player = getPlayerNumList();
            boolean gameResult = judgement(player, computer);
            if(gameResult == true) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                gamming = ReqReGame();
                if (gamming) {
                    computer = getComputerNumList(); // 새로운 computer 리스트를 받음
                }
            }
        }
        
    }
}

public class Application {
    public static void main(String[] args) {
        NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
        numberBaseballGame.gameStart();
    }
}



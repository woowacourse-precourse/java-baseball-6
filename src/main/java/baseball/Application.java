package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private final static int BALL = 0;
    private final static int STRIKE = 1;
    public static void main(String[] args) {
        gameStart();
    }
    private static void gameStart() {
        boolean gameChoice = true;
        List<Integer> computerNum = new ArrayList<>();
        String gameString = "";

        makeComputerNum(computerNum);
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameChoice) {
            System.out.println("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            gameString = printBallCount(checkBall(userInput, computerNum));
            System.out.println(gameString);

            if (gameString.equals("3스트라이크")) {
                gameChoice = checkRestartGame();
            }
        }
    }
    /**
     * 컴퓨터의 3자리 숫자를 만드는 메소드
     */
    private static void makeComputerNum(List<Integer> computerNum) {
        while (computerNum.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(num)) {
                computerNum.add(num);
            }
        }
    }

    /**
     * 게임이 끝난 후 사용자에게 다시 시작할 것인지 물어보는 메소드
     */
    public static boolean checkRestartGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String gameChoiceNum = Console.readLine();

        if (gameChoiceNum.equals("1"))
            return true;
        else if (gameChoiceNum.equals("2"))
            return false;
        //else를 사용하지않고 잘못 입력시 예외처리 하기
        throw new IllegalArgumentException("1과 2중에 입력하셔야 합니다. ");
    }

    private static List<Integer> checkBall(String userInput, List<Integer> computerNum) {
        List<Integer> listBS = new ArrayList<>();
        int totalCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < computerNum.size(); i++) {
            if (userInput.contains(computerNum.get(i).toString())) {
                totalCount++;
            }
            if (userInput.charAt(i) - 48 == computerNum.get(i)) {
                strikeCount++;
            }
        }
        listBS.add(totalCount-strikeCount);
        listBS.add(strikeCount);
        return listBS;
    }

    private static String printBallCount(List<Integer> listBS){
        String returnString = "";
        if(listBS.get(BALL) != 0)
            returnString = listBS.get(BALL)+"볼 ";
        if (listBS.get(STRIKE) != 0)
            returnString += listBS.get(STRIKE)+"스트라이크";
        if(listBS.get(BALL)==0 && listBS.get(STRIKE)==0)
            returnString = "낫씽";
        return returnString;
    }
}
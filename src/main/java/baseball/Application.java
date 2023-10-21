package baseball;

import baseball.Controller.GameController;
import baseball.Model.BaseBallGame;
import baseball.Model.NumberGenerator;
import baseball.View.GameView;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int BALL = 0;
    private static final int STRIKE = 1;
    private static final int BASEBALL_NUM_SIZE = 3;
    private static List<Integer> COMPUTER_NUM = new ArrayList<>();

    public static void main(String[] args) {
        GameController gameController = new GameController();

        gameController.startGame();
//        gameStart(); // 곧 삭제될 코드
    }

    private static void gameStart() {

//        makeComputerNum();
        playingGame();

        if (checkRestartGame())
            gameStart();
    }

    /**
     * 컴퓨터의 3자리 숫자를 만드는 메소드 [기능분리]
     */
//    private static void makeComputerNum() {
//        COMPUTER_NUM.clear();
//        while (COMPUTER_NUM.size() < BASEBALL_NUM_SIZE) {
//            int num = Randoms.pickNumberInRange(1, 9);
//            if (!COMPUTER_NUM.contains(num)) {
//                COMPUTER_NUM.add(num);
//            }
//        }
//    }

    /**
     * 게임을 실제로 플레이하는 구간 숫자를 계속 추측함.
     */
    private static void playingGame() {
        String gameString = "";
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (!gameString.equals("3스트라이크")) {
            System.out.println("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            isValidLength(userInput);

            //볼 카운트를 checkBallCount 메소드를 통하여 산출해 낸 다음 PrintBallCount를 통하여 적절한 String 으로 변환한다.
            gameString = printBallCount(checkBallCount(userInput));
            System.out.println(gameString);
        }
    }

    /**
     * ballCount와 StrikeCount를 체크해서 List형태로 반환해준다.
     */
    private static List<Integer> checkBallCount(String userInput) {
        List<Integer> listBS = new ArrayList<>();
        int totalCount = 0;
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < BASEBALL_NUM_SIZE; i++) {
            if (userInput.contains(COMPUTER_NUM.get(i).toString())) {
                totalCount++;
            }
            if (Character.getNumericValue(userInput.charAt(i)) == COMPUTER_NUM.get(i)) {
                strikeCount++;
            }
        }
        ballCount = totalCount - strikeCount;
        listBS.add(ballCount);
        listBS.add(strikeCount);
        return listBS;
    }

    /**
     * BALL Count 와 STRIKE Count를 문자열로 변환하여 출력하여줌
     */
    private static String printBallCount(List<Integer> listBS) {
        String returnString = "";
        if (listBS.get(BALL) != 0)
            returnString = listBS.get(BALL) + "볼 ";
        if (listBS.get(STRIKE) != 0)
            returnString += listBS.get(STRIKE) + "스트라이크";
        if (listBS.get(BALL) == 0 && listBS.get(STRIKE) == 0)
            returnString = "낫싱";
        return returnString;
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

    /**
     * 입력한 수의 길이가 일치하는지 판별해주는 메소드
     */
    public static void isValidLength(String inputNum){
        if(inputNum.length() != BASEBALL_NUM_SIZE)
            throw new IllegalArgumentException("입력 자릿 수 오류");
    }

}
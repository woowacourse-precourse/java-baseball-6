package baseball;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.stream.Collectors;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Application {
    public static void main(String[] args) {
        baseballGame baseballgame = new baseballGame();
        baseballgame.playGame();
    }
}
class baseballGame{

    private final static String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final static String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String ASK_CONTINUE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final static String REQUIRE_NUMBER = "숫자를 입력해주세요";
    private final static int INPUT_LENGTH = 3;
    private final static int STRIKE_FOR_ENDGAME = 3;



    private static List<Integer> getPlayerNumber(){ // 플레이어가 3개의 번호를 입력받아 Integer List로 반환하게 해주는 메서드
        List<Integer> playerNumber = new ArrayList<>();
        System.out.println(REQUIRE_NUMBER); // 숫자를 입력해주세요
        String playerNumberString = camp.nextstep.edu.missionutils.Console.readLine();

        playerNumber = Arrays.stream(playerNumberString.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (validatePlayerNumber(playerNumber)) {
            throw new IllegalArgumentException("잘못된 입력값이에요.");
        }
        return playerNumber;
    }

    private static List<Integer> getCpuRandomNumber(){ // cpu가 랜덤으로 3개의 번호를 생성해서 Integer List로 반환하게 해주는 메서드
        List<Integer> cpuNumber = new ArrayList<>();
        while (cpuNumber.size() < 3) {
            int randomNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 9);
            if (!cpuNumber.contains(randomNumber)) {
                cpuNumber.add(randomNumber);
            }
        }
        return cpuNumber;
    }

    private static boolean validatePlayerNumber(List<Integer> input){ // 플레이어가 입력한 값이 옳은지 검증하는 메서드
        if (input.size() != INPUT_LENGTH) {
            return true; // 입력된 숫자가 3자리가 아닐 경우에 false 반환
        }

        if (input.get(1) == input.get(2) || input.get(1) == input.get(3) || input.get(3) == input.get(2)){
            return true; // 입력된 값에 중복된 숫자가 있을 경우 false 반환
        }

        return false;
    }

    private static boolean checkEndGame(int strikes){ // strikes 가 3 일 경우에 게임을 종료시키는 메서드
        if (strikes == STRIKE_FOR_ENDGAME) {
            return true;
        }
        return false;
    }

    private static int checkStrike(List<Integer> playerInput,List<Integer> cpuInput){ // 스트라이크를 체크
        int strikes = 0;
        for (int i = 0; i < INPUT_LENGTH; i++) {
            if(playerInput.get(i) == cpuInput.get(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    private static int checkBall(List<Integer> playerInput,List<Integer> cpuInput){ // 볼을 체크
        int balls = 0;
        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (playerInput.get(i) != cpuInput.get(i) && cpuInput.contains(playerInput.get(i))) {
                balls++;
            }
        }
        return balls;
    }

    private static String checkNothing(List<Integer> playerInput,List<Integer> cpuInput){ // 낫싱인지 체크
        int nothingCount = 0;
        String nothing = "낫싱";
        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (cpuInput.contains(playerInput.get(i)) == false) {
                nothingCount++;
            }
        }
        if (nothingCount == 3){
            return nothing;
        }
        return "낫싱 아님";
    }

    private static boolean playGameAgain(){ // 게임을 다시 시작하는지 물어보는 메서드 1이 입력되면 다시시작(true) 2가 입력되면 종료(false)
        String gameContinue;
        boolean check = true;
        gameContinue = camp.nextstep.edu.missionutils.Console.readLine();
        if (gameContinue == "1"){
            check = true;
        }
        if (gameContinue == "2"){
            check = false;
        }
        return check;
    }

    public static void playGame(){
        int balls = 0;
        int strikes = 0;
        String nothing;
        boolean gameAgainCheck = true;

        System.out.println(START_MESSAGE);
        List<Integer> playerGameNumber= getPlayerNumber();
        List<Integer> cpuGameNumber = getCpuRandomNumber();

        while(gameAgainCheck){ // gameAgainCheck 가 false가 되년 경우엔 게임 종료
            strikes = checkStrike(playerGameNumber,cpuGameNumber);
            balls = checkBall(playerGameNumber,cpuGameNumber);
            nothing = checkNothing(playerGameNumber,cpuGameNumber);

            if (nothing.equals("낫싱")){ // 하나도 맞는 경우가 없는 경우
                System.out.println("낫싱");
            }
            if (strikes != 0 && balls == 0){ // 스트라이크만 있는 경우
                System.out.println(strikes + "스트라이크");
            }
            if (strikes == 0 && balls != 0){ // 볼만 있는 경우
                System.out.println(balls + "볼");
            }
            if (strikes != 0 && balls != 0){ // 볼과 스트라이크 모두 있는 경우
                System.out.println(balls + "볼" + strikes + "스트라이크");
            }
            if (checkEndGame(strikes)){ // 게임이 끝났는지 안끝났는지 확인함. strikes = 3 이면 진입
                System.out.println(END_MESSAGE);
                gameAgainCheck = playGameAgain(); // 게임을 다시 시작할지 말지 물어봄 1이면 true, 2면 false
            }
        }
    }
}

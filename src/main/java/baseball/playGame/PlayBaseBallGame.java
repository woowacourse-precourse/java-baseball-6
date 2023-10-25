package baseball.playGame;

import baseball.player.Attacker;
import baseball.player.Defender;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PlayBaseBallGame {

    private static boolean treeStrike;

    public static PlayBaseBallGame create(){
        return new PlayBaseBallGame();
    }

    public void runGame(Defender defender, Attacker attacker)  {
        treeStrike =false;
        while (!treeStrike){
            DefenderNumbersInput(attacker);
            printResult(defender,attacker);

        }
    }

    // 숫자 입력
    private void DefenderNumbersInput(Attacker attacker) {
        System.out.print("숫자를 입력해 주세요: ");

        List<Integer> defendNums = new ArrayList<>();

        String balls = readLine();

        validateType(balls);
        validLength(balls);
        validateDuplication(balls);

        System.out.println(balls);
        for(int i=0; i<balls.length(); i++){
            defendNums.add(Integer.parseInt(String.valueOf(balls.charAt(i))));
        }

        attacker.inputDefendNums(defendNums);

    }

    // 입력 따른 결과 출력
    private void printResult(Defender defender, Attacker attacker){

        int strikeCount =0;
        int ballCount = 0;
        for(int i=0; i<defender.getDefendNums().size(); i++){
            if(defender.getDefendNums().get(i) == attacker.getAttackerNums().get(i)){
                strikeCount++;
            }else{
                if(defender.getDefendNums().contains(attacker.getAttackerNums().get(i))){
                    ballCount++;
                }
            }
        }

        if(strikeCount == 3){
            treeStrike = true;
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }else if(strikeCount == 0 && ballCount == 0){
            System.out.println("낫싱");
        }else{
            System.out.println(ballCount + "볼 " + strikeCount +"스트라이크");
        }

    }

    // 입력 길이 검증
    public void validLength(String s){
        if(s.length() != 3) {
            throw new IllegalArgumentException("입력값의 길이가 잘못 되었습니다.");
        }
    }

    // 입력 타입 검증
    public void validateType(String balls){
        for(int i=0; i<balls.length(); i++){
            if(balls.charAt(i) <48 || balls.charAt(i)>57){
                throw new IllegalArgumentException("정수가 들어가야 합니다.");
            }
        }
    }

    // 입력 중복 검증
    private void validateDuplication(String balls) {
        Set<Integer> ballSet = new HashSet<>();
        for(int i=0; i<balls.length(); i++){
            ballSet.add(Integer.parseInt(String.valueOf(balls.charAt(i))));
        }
        if (ballSet.size() != balls.length()) {
            throw new IllegalArgumentException("공의 숫자가 중복 됩니다.");
        }
    }


}

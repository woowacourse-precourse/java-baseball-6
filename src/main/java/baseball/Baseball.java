package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import baseball.models.Score;
import baseball.rule.Rule;

public class Baseball {
    //규칙
    Rule rule = new Rule();
    public void start() {

        //점수
        Score score = new Score();

        /* --- 컴퓨터 정답 생성 --- */
        List<Integer> computer = getComputerNum();

        /* --- 유저 입력값 받기 --- */
        while (score.strikeCount() < 3){
            /* --- 유저 입력값 확인 --- */
            List<Integer> user = getUserNum();

            /* --- 야구 게임 진행 --- */
            countScore(computer, user, score);
            printFinal(score);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");



    }


    /* --- 컴퓨터 정답 생성 --- */
    public static List<Integer> getComputerNum(){
        List<Integer> newRandom = new ArrayList<>();
        while (newRandom.size() < 3){
            // 1~9 사이 숫자만 (0 불가)
            int num = Randoms.pickNumberInRange(1,9);
            // 중복 숫자 들어가지 않게끔
            if (!newRandom.contains(num)){
                newRandom.add(num);
            }

        }

        return newRandom;
    }

    /* --- 유저 입력값 받기 --- */
    public List<Integer> getUserNum(){
        System.out.println("숫자를 입력해주세요 : ");
        String userNumInput = readLine();
        isUserNum(userNumInput);
        List<Integer> userNum = new ArrayList<>();
        for (String s : userNumInput.split("")){
            userNum.add(Integer.parseInt(s));
        }
        return userNum;
    }


    /* --- 유저 입력값 확인 --- */
    public static void isUserNum(String input){
        // 세 자리 수인지
        if (input.length() != 3){
            throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        }

        // 서로 다른 세 숫자인지
        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(2);

        if (first == second || second == third || first == third){
            throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        }


        // 0이 들어갔는지
        for (char c : input.toCharArray()){
            if (!Character.isDigit(c) || c == '0'){
                throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
            }
        }

    }

    /* --- 야구 게임 진행 --- */
    public void countScore(List<Integer> computer,List<Integer>  user, Score s){
        int strikes = rule.numStrike(computer, user);
        int balls = rule.numBall(computer, user);
        s.updateScore(strikes, balls);
    }

    public void printFinal(Score score){
        rule.printResult(score.strikeCount(), score.ballCount());
    }

}

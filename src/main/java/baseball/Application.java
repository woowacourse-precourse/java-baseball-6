package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.lang.String;


public class Application {
    final static int gamenumslen = 3;
    public static boolean confirmUserCorrectAnswer(String nums){//컴퓨터에 값을 맞추기 위한 사용자의 값이 올바른지 확인
        boolean[] userNumsBucket = {false, false, false, false, false, false, false, false, false, false};
        if(nums.length() != gamenumslen){
            return false;
        }
        else{
            for(int i = 0; i<gamenumslen; i++){
                int numsCheck = nums.charAt(i) -'0';
                if(numsCheck<1&&9<numsCheck){
                    return false;
                }
                if(!userNumsBucket[numsCheck]){
                    userNumsBucket[numsCheck] = true;
                }
                else return false;
            }
            return true;
        }
    }
    public static boolean gameResultPrint(CompareNums compareNums, String playerNums){
        int[] ball_strike = compareNums.compareNums(Integer.parseInt(playerNums));
        if(ball_strike[0]>0&&ball_strike[1]>0){
            System.out.println(ball_strike[0]+"볼 "+ball_strike[1]+"스트라이크");
        }
        else if(ball_strike[0]>0){
            System.out.println(ball_strike[0]+"볼");
        }
        else if(ball_strike[1]>0){
            System.out.println(ball_strike[1]+"스트라이크");
            if(ball_strike[1] == gamenumslen){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return false;
            }
        }
        else{
            System.out.println("낫싱");
        }
        return true;
    }
    public static boolean confirmUserRetryAnswer(String nums){//게임을 재진행하는지 확인하기 위한 사용자의 값이 올바른지 확인
        if(nums.length() != 1){
            return false;
        }
        else{
            if(nums.equals("1") && nums.equals("2")){
                return false;
            }
            return true;
        }
    }
    public static void main(String[] args) {
        boolean confirmUserCorrectAnswer = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        String playerNums;
        while(confirmUserCorrectAnswer){
            CompareNums compareNums = new CompareNums();
            boolean gameSuccessCheck = true;
            while(gameSuccessCheck){
                System.out.printf("숫자를 입력해주세요 : ");
                playerNums = readLine();
                if(!confirmUserCorrectAnswer(playerNums)){
                    throw new IllegalArgumentException();
                }
                else{
                    gameSuccessCheck = gameResultPrint(compareNums, playerNums);
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String retrychecknnum = readLine();
            if(!confirmUserRetryAnswer(retrychecknnum)){
                throw new IllegalArgumentException();
            }
            else{
                if(retrychecknnum.equals("2")){
                    confirmUserCorrectAnswer = false;
                }
            }
        }
    }
}

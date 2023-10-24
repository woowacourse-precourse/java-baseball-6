package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static String[] randomNum = new String[4];

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        start();
    }

    public static void start(){
        randomNum = createRandomNumber();
        judgingBallOrStrike(randomNum, getNumber());
    }

    public static void startAgain(){
        judgingBallOrStrike(randomNum, getNumber());
    }

    public static String[] createRandomNumber(){
        int intRandomNum1 = Randoms.pickNumberInRange(1, 9);
        int intRandomNum2 = Randoms.pickNumberInRange(1, 9);
        int intRandomNum3 = Randoms.pickNumberInRange(1, 9);
        String stringRandomNum1 = Integer.toString(intRandomNum1);
        String stringRandomNum2 = Integer.toString(intRandomNum2);
        String stringRandomNum3 = Integer.toString(intRandomNum3);
        String[] arrRandomNum = new String[3];
        arrRandomNum[0] = stringRandomNum1;
        arrRandomNum[1] = stringRandomNum2;
        arrRandomNum[2] = stringRandomNum3;
        return arrRandomNum;
    }

    public static String[] getNumber(){
        String givenNum;
        System.out.println("숫자를 입력해주세요 : ");
        givenNum = Console.readLine();
        //if(givenNum)
        String[] arrGivenNum = new String[givenNum.length()];
        for(int i = 0; i < givenNum.length(); i++){
            arrGivenNum[i] = String.valueOf(givenNum.charAt(i));
        }
        return arrGivenNum;
    }

    public static void judgingBallOrStrike(String[] comNum, String[] userNum){
        int[][] recording = new int[2][9];
        int num = 0;

        for(int i = 1; i < 4; i++){
            for(int j = 1; j < 4; j++){
                if(comNum[i-1].equals(userNum[j-1])){
                    recording[0][num] = i;
                    recording[1][num] = j;
                    num++;
                }
            }
        }
        successOrNot(countingBall(recording), countingStrike(recording));
    }

    public static int countingBall(int[][] recording){
        int ballCnt = 0;

        for(int i = 0; i < recording[0].length; i++){
            if((recording[0][i] != 0) && (recording[1][i] != 0) && recording[0][i] != recording[1][i]){
                ballCnt++;
            }
        }

        return ballCnt;
    }

    public static int countingStrike(int[][] recording){
        int strikeCnt = 0;

        for(int i = 0; i < recording[0].length; i++){
            if((recording[0][i] != 0) && (recording[1][i] != 0) && recording[0][i] == recording[1][i]){
                strikeCnt++;
            }
        }

        return strikeCnt;
    }

    public static void successOrNot(int ballCnt, int strikeCnt){
        if(strikeCnt == 3){
            print3Strike();
        }
        else if((strikeCnt == 0) && (ballCnt == 0)){
            printNothing();
        }
        else{
            printNotSuccess(ballCnt,strikeCnt);
        }
    }

    public static void printNothing(){
        System.out.println("낫싱");
        Application.startAgain();
    }

    public static void printNotSuccess(int ballCnt, int strikeCnt){
        System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        Application.startAgain();
    }

    public static void print3Strike(){

        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String stringNum = Console.readLine();
        int num = Integer.valueOf(stringNum);

        if(num == 1){
            Application.start();
        }
        if(num == 2){
            return;
        }

    }

}

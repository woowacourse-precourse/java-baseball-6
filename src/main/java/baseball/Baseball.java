package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Baseball {
    private String computerNum;

    // 생성자
    public Baseball(){
        initGame();
    }

    public void initGame(){
        // 게임 시작 알림
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터 수 세팅
        this.computerNum=makeRandomNum();
    }

    public String makeRandomNum(){
        String randomStr = "";

        while(randomStr.length()<3) {

            // 서로 다른 세자리 수 생성
            int randomNum = Randoms.pickNumberInRange(1, 9);
            String numToString=Integer.toString(randomNum);

            if (!randomStr.contains(numToString)) {
                randomStr = randomStr.concat(numToString);
            }
        }

        return randomStr;
    }

    // 콘솔에 게임 결과를 출력하는 함수
    public void printResult(int[] result){
        int ballNum = result[0];
        int strikeNum = result[1];

        if(ballNum==0 && strikeNum==0) {
            System.out.println("낫싱");
            return;
        }

        if(ballNum!=0) System.out.print(ballNum+"볼 ");
        if(strikeNum!=0) System.out.print(strikeNum+"스트라이크");
        System.out.print("\n");
    }

    // 볼과 스트라이크 갯수를 세는 함수
    public int[] countResult(String input){
        int ballNum=0;
        int strikeNum=0;

        for(int i=0;i<3;i++){
            if(input.charAt(i) == computerNum.charAt(i)) strikeNum++;
            else if(computerNum.contains(String.valueOf(input.charAt(i)))){
                ballNum++;
            }
        }

        return new int[] {ballNum,strikeNum};
    }

    public boolean isCorrect(int strikeNum){
        return strikeNum == 3;
    }

    public void playGame(){

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input=Console.readLine();

            if(input.length()!=3){
                throw new IllegalArgumentException();
            }
            for(int i=0;i<3;i++){
                for(int j=i+1;j<3;j++){
                    if(input.charAt(i)==input.charAt(j)) throw new IllegalArgumentException();
                }
            }
            int[] result=countResult(input);
            printResult(result);

            if(isCorrect(result[1])) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input=Console.readLine();

        if(input.equals("1")){
//            initBaseball();
            this.computerNum=makeRandomNum();
            playGame();
        }else if(!input.equals("2")){
            throw new IllegalArgumentException();
        }
    }
}

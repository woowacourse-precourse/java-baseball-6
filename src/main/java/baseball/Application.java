package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    static int[] createNewArray(){

        System.out.println("숫자 야구 게임을 시작합니다.");

        //정답이 될 3개의 숫자를 만들기
        int[] answer = new int[3];
        for(int i=0;i<3;i++){
            answer[i] = Randoms.pickNumberInRange(1, 9);
            for(int j=0; j < i; j++){
                if(answer[j] == answer[i]) {
                    answer[i] = Randoms.pickNumberInRange(1, 9);
                    j = -1;
                }
            }
        }
        return answer;
    }

    static int[] receiveNewArray() {

        int[] arr = new int[3];

        System.out.print("숫자를 입력해주세요 : ");

        //사용자로부터 3개의 숫자 입력받기
        String readLine = Console.readLine();
        if(readLine.length()!=3) throw new IllegalArgumentException(); //길이가 3이 아니면 오류
        for (int i = 0; i < 3; i++) {
            int temp = readLine.charAt(i) - '0';
            if (temp < 1 || 9 < temp) throw new IllegalArgumentException(); //정수 1~9 사이의 값이 아니면 오류
            arr[i] = temp;
            for(int j=0; j < i; j++){
                if(arr[j] == arr[i]) throw new IllegalArgumentException(); //중복 숫자가 있으면 오류
            }
        }
        return arr;
    }

    static boolean judge(int[] answer, int[] ask){

        int strike=0;
        int ball=0;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                if (answer[j] == ask[i]) {
                    if(i==j) strike++;
                    else ball++;
                }
            }
        }

        if(ball==0 && strike==0) System.out.print("낫싱");
        if(ball!=0) System.out.print(ball + "볼 ");
        if(strike!=0) System.out.print(strike + "스트라이크");
        System.out.println();
        if(strike==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    static int endGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String readLine = Console.readLine();
        if(readLine.length()!=1) throw new IllegalArgumentException(); //길이가 1이 아니면 오류
        int temp = readLine.charAt(0) - '0';
        if(temp < 1 || 2 < temp) throw new IllegalArgumentException(); //정수 1 또는 2가 아니면 오류
        return temp;
    }

    public static void main(String[] args) {
        int key;
        do {

            int[] answer = createNewArray();
            int[] ask;

            try {

                do {
                    ask = receiveNewArray();
                } while (!judge(answer, ask));

                key = endGame();

            } catch (IllegalArgumentException e) {
                break;
            }

        } while (key==1);
    }
}

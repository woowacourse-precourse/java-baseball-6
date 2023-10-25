package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    private static final int ANSWER_LENGTH = 3;
    private static final int RESTART_GAME = 1;
    private static final int END_GAME = 2;

    static int[] createNewArray(){

        System.out.println("숫자 야구 게임을 시작합니다.");

        //정답이 될 3개의 숫자를 만들기
        int[] answer = new int[ANSWER_LENGTH];
        for(int i=0; i < ANSWER_LENGTH; i++){
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

        int[] arr = new int[ANSWER_LENGTH];
        System.out.print("숫자를 입력해주세요 : ");

        //사용자로부터 3개의 숫자 입력받기
        String readLine = Console.readLine();
        if(readLine.length() != ANSWER_LENGTH) {
            throw new IllegalArgumentException("입력은 공백 없이 한자릿수 숫자 3개여야 합니다.");
        }
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            int temp = readLine.charAt(i) - '0';
            if (temp < 1 || 9 < temp) {
                throw new IllegalArgumentException("세 숫자는 정수 1~9 사이여야 합니다.");
            }
            arr[i] = temp;
            for(int j=0; j < i; j++){
                if(arr[j] == arr[i]) {
                    throw new IllegalArgumentException("세 숫자는 서로 달라야 합니다.");
                }
            }
        }
        return arr;
    }

    static boolean testInput(int[] answer, int[] ask){

        int strike = 0;
        int ball = 0;

        for(int i = 0; i < ANSWER_LENGTH; i++){
            for(int j=0; j < ANSWER_LENGTH; j++) {
                if (answer[j] == ask[i]) {
                    if(i == j) strike++;
                    else ball++;
                }
            }
        }

        if(ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        if(ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if(strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
        if(strike == ANSWER_LENGTH){
            System.out.println(ANSWER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    static int endGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String readLine = Console.readLine();
        if(readLine.length() != 1) {
            throw new IllegalArgumentException("입력은 한자리 숫자 하나여야 합니다.");
        }
        int temp = readLine.charAt(0) - '0';
        if(temp < RESTART_GAME || END_GAME < temp) {
            throw new IllegalArgumentException("입력은 " + RESTART_GAME + " 또는 " + END_GAME + "여야 합니다.");
        }
        return temp;
    }

    public static void main(String[] args) {
        int key;
        do {

            int[] answer = createNewArray();
            try {

                int[] userInput;
                do {
                    userInput = receiveNewArray();
                } while (!testInput(answer, userInput));

                key = endGame();

            } catch (IllegalArgumentException e) {
                break;
            }

        } while (key == 1);
    }
}

package baseball;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.lang.Math;
public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        Application app = new Application();
        app.run();
    }

    public void run() throws IllegalArgumentException{
        int strike = 0;
        int restart = 1;

        while(restart == 1){
            play();

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = reStart();
        }
        if(restart != 2){
            throw new IllegalArgumentException();
        }
    }

    private void play() throws IllegalArgumentException {
        int settingNumber = init();
        int strike = 0;
        while (strike != 3) {
            int start = 1;
            System.out.print("숫자를 입력해주세요 : ");
            String tempNumber = Console.readLine();
            int length = tempNumber.length();
            if (length != 3) {
                throw new IllegalArgumentException();
            }
            for (int i=0;i<3;i++){
                if (tempNumber.charAt(i) == '0'){
                    throw new IllegalArgumentException();
                }
            }
            int nowNumber = Integer.valueOf(tempNumber);
            int[] result = strikeAndBall(settingNumber, nowNumber);
            strike = result[0];
            int ball = result[1];
            if (ball != 0) {
                if (strike != 0) {
                    System.out.printf("%d볼 %d스트라이크\n", ball, strike);
                } else { // strike == 0
                    System.out.printf("%d볼\n", ball);
                }
            } else {
                if (strike != 0) {
                    System.out.printf("%d스트라이크\n", strike);
                } else {
                    System.out.printf("낫싱\n");
                }
            }
        }
    }


    private int[] strikeAndBall(int setting,int now){
        String settingStr = String.valueOf(setting);
        String nowStr = String.valueOf(now);
        int strike = 0;
        int ball = 0;
        int[] check = {0,0,0};
        for(int i=0;i<3;i++){
            char settingDigit = settingStr.charAt(i);
            char nowDigit = nowStr.charAt(i);

            if (settingDigit == nowDigit) {
                strike += 1;
                check[i] = 1;
            }
        }
        for(int i=0;i<3;i++){
            if(check[i] == 0){
                int index = nowStr.charAt(i);
                for(int j=0;j<3;j++){
                    if(i==j){
                        continue;
                    }
                    int tempIndex = settingStr.charAt(j);
                    if (tempIndex == index){
                        ball += 1;
                    }
                }
            }
        }
        return new int[]{strike, ball};
    }
    private int reStart() {
        String restart = Console.readLine();
        int restartNum = Integer.valueOf(restart);
        return restartNum;
    }

    private int init() {
        int[] list = {0,0,0};
        int index = 0;
        while(index != 3) {
            int num = Randoms.pickNumberInRange(1, 9); // 1~9까지
            if (list[(index+1) % 3] != num && list[(index+2) % 3] != num) {
                list[index] = num;
                index += 1;
            }
        }
        int number = 0;
        for(int i=0; i<3;i++){
            number += Math.pow(10,(2-i))*list[i];
        }
        return number;
    }
}

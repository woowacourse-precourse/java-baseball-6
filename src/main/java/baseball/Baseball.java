package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Baseball {
    private int[] user_input;
    private int[] answer;
    int ball;
    int strike;

    public Baseball() {
        this.ball =0;
        this.strike = 0;
        this.answer = new int[] {0,0,0};

        for(int i=0; i<3; i++) {
            this.answer[i] = Randoms.pickNumberInRange(1, 9);
        }
        while(answer[0] == answer[1]) {
            answer[1] = Randoms.pickNumberInRange(1,9);
        }
        while((answer[2] == answer[0])|| (answer[2] == answer[1])) {
            answer[2] = Randoms.pickNumberInRange(1,9);
        }
        this.user_input = new int[] {0,0,0};
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            if(userInput.length() != 3 || userInput.contains("0")) {
                throw new IllegalArgumentException();
            }
            int input = Integer.parseInt(userInput);
            for(int j=0; j<3; j++) {
                user_input[2-j] = input % 10;
                input = input / 10;
            }

            for(int k=0; k<3; k++) {
                for(int z=0; z<3; z++) {
                    if(user_input[k] == answer[z]) {
                        if(k==z) {
                            strike++;
                            break;
                        }
                        else {
                            ball++;
                            break;
                        }

                    }
                }
            }

            if( ball==0 && strike ==0) {
                System.out.println("낫싱");
            }else if(ball != 0 && strike ==0) {
                System.out.println(ball+"볼");
            }else if(ball ==0 && strike !=0) {
                System.out.println(strike+"스트라이크");
            }else {
                System.out.println(ball+"볼 "+strike+"스트라이크");
            }
            if(strike ==3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            } else{
                ball = 0;
                strike =0;
            }
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String lastinput = Console.readLine();
        int lastInput = Integer.parseInt(lastinput);
        try {
            if(lastInput ==1) {
                Baseball newBaseBall = new Baseball();
                newBaseBall.start();
            }
            else if(lastInput ==2){
                return;
            }
        }catch (IllegalArgumentException e){
            return;
        }
    }
}

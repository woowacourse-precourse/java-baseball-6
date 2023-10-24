package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean quitgame = false;
        boolean wingame = false;
        while(true){
            int randomArr[];
            int userArr[];

            randomArr = getRandomNumber();

            while(true){
                int strike = 0;
                int ball = 0;

                try {
                    userArr = getUserNumber();
                    for(int i=0; i<userArr.length; i++){
                        System.out.print(userArr[i]);
                    }
                    System.out.println();
                }catch(IllegalArgumentException e){
                    System.out.println(e);
                    break;
                }

                for(int i=0;i<randomArr.length;i++){
                    if(randomArr[i]==userArr[i]){
                        strike ++;
                    }else{
                        for(int j=0; j<randomArr.length;j++){
                            if(i==j) continue;
                            if(randomArr[i]==userArr[j]){
                                ball ++;
                            }
                        }
                    }
                }

                for(int i=0; i<randomArr.length; i++){
                    System.out.print(randomArr[i]);
                }

                System.out.println();

                String gameresult="";

                if(ball!=0) gameresult+=ball+"볼 ";
                if(strike!=0) gameresult+=strike+"스트라이크";
                if(strike==0 && ball==0){
                    System.out.println("낫싱");
                }else{
                    System.out.println(gameresult);
                }

                if(strike==3) {
                    wingame = true;
                    break;
                }
            }

            if(wingame){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                try{
                    while(true){
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        int userQuit = Integer.parseInt(readLine());
                        if(userQuit==1){
                            quitgame=false;
                            break;
                        } else if (userQuit==2) {
                            quitgame=true;
                            break;
                        }else{
                            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
                        }
                    }
                } catch (IllegalArgumentException e){
                    System.out.println(e);
                    break;
                }
            }

            if(quitgame) break;
        }
        System.out.println("숫자 야구 게임을 종료합니다.");
    }


    static int[] getUserNumber() throws IllegalArgumentException {
        int result[] = new int[3];
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = String.valueOf(readLine());
        if(!isInteger(userInput)) throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        if(userInput.length()!=3) throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");

        for(int i=0; i<userInput.length(); i++){
            result[i] = Integer.parseInt(String.valueOf(userInput.charAt(i)));
        }

        return result;
    }
    static int[] getRandomNumber(){
        int arr[] = new int[3];
        for(int i=0; i<arr.length; i++){
            arr[i] = Randoms.pickNumberInRange(1,9);
            for(int j=0; j<i; j++){
                if(arr[i]==arr[j]){
                    i--;
                    break;
                }
            }
        }
        return arr;
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}

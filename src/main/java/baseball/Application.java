package baseball;
import camp.nextstep.edu.missionutils.*;

public class Application {
    public static boolean play;
    public static int Size = 3;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        play = true;
        String answer = makeAnswer();
        System.out.println(answer);

        while(play){
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            if(!check(answer, input)){                  // Input 유효성 검사
                throw new IllegalArgumentException();
            }

            int strike = 0;
            int ball = 0;

            for(int i = 0; i < Size; i++){
                for(int j = 0; j < Size; j++){
                    if(answer.charAt(i) == input.charAt(j)){
                        if(i == j){
                            strike++;
                        }
                        else{
                            ball++;
                        }
                    }
                }
            }
            if(strike + ball == 0){
                System.out.println("낫싱");
            }
            else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }

            if(strike == Size){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                String check = Console.readLine();
                if(check.equals("1")){
                    answer = makeAnswer();
                }
                else if(check.equals("2")){
                    play = false;
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
        }

    }

    // 정답 생성
    public static String makeAnswer(){
        String answer = "";
        while(answer.length() < Size){
            String temp = Integer.toString(Randoms.pickNumberInRange(1,9));
            if(!answer.contains(temp)){
                answer = answer + temp;
            }
        }
        return answer;
    }

    public static boolean check(String answer, String input){
        if(input.length() != 3) {
            return false;
        }
        for(int i = 0; i < Size; i++){
            if(0 > input.charAt(i)-'0' || input.charAt(i) - '0' > 9){
                return false;
            }
            else if(input.charAt(i) == input.charAt((i+1)%3) || input.charAt(i) == input.charAt((i+2)%3)){
                return false;
            }
        }
        return true;
    }
}

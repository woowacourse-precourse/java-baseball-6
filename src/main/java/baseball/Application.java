package baseball;
import java.util.*;
public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.gameStart();
//        Scanner sc = new Scanner(System.in);
//        int[] my_answer = new int[3];
//        int[] answer = new int[3];
//        Random rand = new Random();
//        int start = 1;
//
//        while(start == 1) {
//
//            for (int i = 0; i < answer.length; i++){
//                answer[i] = rand.nextInt(9) + 1;
//                for(int j = 0; j < i; j++){
//                    if (answer[i] == answer[j]){
//                        i--;
//                    }
//                }
//            }
//
//            System.out.println("숫자 야구 게임을 시작합니다.");
//
//            while(true){
//
//                System.out.print("숫자를 입력해주세요 : ");
//
//                int my_input = sc.nextInt();
//                for(int i = 2; i >= 0; i--){
//                    my_answer[i] = my_input % 10;
//                    my_input /= 10;
//                }
//                int strike = 0, ball = 0;
//
//                for(int i = 0; i < answer.length; i++){
//                    for(int j = 0; j < my_answer.length; j++){
//                        if(my_answer[i] == answer [j]){
//                            if(i == j){
//                                strike++;
//                            }
//                            else{
//                                ball++;
//                            }
//                        }
//                    }
//                }
//
//                if (strike == 3) {
//                    System.out.println(strike + "스트라이크");
//                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//                    break;
//                }
//                else{
//                    if(strike == 0){
//                        System.out.println(ball + "볼 ");
//                    }
//                    else if (ball == 0){
//                        System.out.println(strike + "스트라이크");
//                    }
//                    else{
//                        System.out.println(ball + "볼 " + strike + "스트라이크");
//                    }
//                }
//            }
//
//            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//            start = sc.nextInt();
//        }
    }
}

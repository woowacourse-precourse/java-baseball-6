package baseball;
import camp.nextstep.edu.missionutils.*;


public class Application {
    public static void main(String[] args) {
        Judge judge = new Judge();
        String exit; // 종료
        String number; // 유저가 입력한 숫자

        System.out.println("숫자 야구 게임을 시작합니다.");
        do{
            do {
                System.out.print("숫자를 입력해주세요 : ");
                 number = Console.readLine();
            } while(!judge.isStrike(number).equals("3스트라이크"));

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            exit = Console.readLine();
            if(!exit.equals("1") && !exit.equals("2")){
                throw new IllegalArgumentException();
            }
        } while (!exit.equals("2"));
    }
}



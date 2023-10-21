package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) 
    {
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	System.out.println("숫자 야구 게임을 시작합니다.");
        // TODO: 프로그램 구현
        startGame();
    }
    public static void startGame() 
    {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String answer = generateRandomNumber();

        while (true) 
        {
            String input = Console.readLine("서로 다른 3자리 숫자를 입력하세요: ");
            
            if (!isValidInput(input)) 
            {
                System.out.println("유효하지 않은 입력입니다. 1부터 9까지의 서로 다른 3자리 숫자를 입력하세요.");
                continue;
            }

            String result = playGame(input, answer);
            System.out.println(result);

            if ("3스트라이크".equals(result)) 
            {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        int choice = Console.readInt("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요: ");
        if (choice == 1) {startGame();} 
        else {System.out.println("게임 종료. 감사합니다!");}
    }

    public static String generateRandomNumber() 
    {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 3) 
        {
            int num = Randoms.pickNumberInRange(1, 9);
            if (sb.indexOf(String.valueOf(num)) == -1) { sb.append(num); }
        }
        return sb.toString();
    }

    public static boolean isValidInput(String input) 
    {
        return input.matches("^[1-9]{3}$") && input.charAt(0) != input.charAt(1) && input.charAt(0) != input.charAt(2) && input.charAt(1) != input.charAt(2);
    }

    public static String playGame(String input, String answer) 
    {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) 
        {
            if (input.charAt(i) == answer.charAt(i)) {strikes++;} 
            else if (answer.contains(String.valueOf(input.charAt(i)))) {balls++;}
        }
        
        if (strikes == 3) {return "3스트라이크";}

        return (strikes > 0 ? strikes + "스트라이크 " : "") + (balls > 0 ? balls + "볼" : "") + (strikes + balls == 0 ? "낫싱" : "");
    }
}

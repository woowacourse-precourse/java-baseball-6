package baseball;

import java.io.IOException;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {
	
	static int[] player= new int[3];
	static ArrayList<Integer> computer = new ArrayList<>();
	static int ball=0;
	static int strike=0;
	static int input=0;

	static String s;
	
    public static void main(String[] args){
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	com_turn();
    	System.out.println("Finish");
    	return;
    }
    
    static void com_turn()
    {
    	while (computer.size() < 3) {
    	    int randomNumber = Randoms.pickNumberInRange(1, 9);
    	    if (!computer.contains(randomNumber)) {
    	        computer.add(randomNumber);
    	    }
    	}
    	player_turn();
    	return;
    }
    
    static void runException(String s) throws IllegalArgumentException {
        if (s.length() != 3 ) {
        	throw new IllegalArgumentException();
        }
        for(int i=0; i<3; i++)
        {
        	if(s.charAt(i)-'0'>9||s.charAt(i)-'0'<1)
            	throw new IllegalArgumentException();    	
        	for(int j=i-1; j>=0; j--)
        	{
        		if(player[j]==s.charAt(i)-'0')
                	throw new IllegalArgumentException();    	

        	}
        	player[i]=s.charAt(i)-'0';
        }
        
    }
    
    
    static void player_turn() {
        do {
            strike = 0;
            ball = 0;

            System.out.print("숫자를 입력해 주세요 : ");
            s = Console.readLine();

            runException(s);

            input = Integer.parseInt(s);

            for (int i = 2; i >= 0; i--) {
                if (computer.contains(input % 10)) {
                    if (computer.get(i) == input % 10) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
                input = input / 10;
            }
            if (strike == 0 && ball == 0)
                System.out.println("낫싱");
            else
                System.out.println(ball + "볼 " + strike + "스트라이크");
        } while (strike != 3);

        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        input = Integer.parseInt(Console.readLine());
        if (input == 1) {
            computer.clear();
            com_turn();
        } else if (input == 2) {
            return;
        }
    }

    
}


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
	static int x=0;
	static int y=0;

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
    	        //System.out.print(randomNumber);
    	    }
    	}
    	player_turn();
    	return;
    }
    
    static void runException(String s) throws IllegalArgumentException
    {
    	y=0/1234-Integer.parseInt(s);
    }
    
    static void player_turn()
    {

    	
    	do{
    		strike=0;
    		ball=0;
			s=Console.readLine();

    		System.out.print("숫자를 입력해 주세요 : ");   
    		try {
    			runException(s);
    		}
    		catch(IllegalArgumentException e)
    		{
    			return;
    		}
            x=Integer.parseInt(s);
    		for(int i=2; i>=0; i--) 
    		{
    			System.out.println(computer.get(i));
    			if(computer.contains(x%10))
    			{
    				if(computer.get(i)==x%10)
    				{
    					strike++;
    				}
    				else
    				{
    					ball++;
    				}
    			}
    			x=x/10;
    		}
    		if(strike==0&&ball==0)
    			System.out.println("낫싱");
    		else
    			System.out.println(ball+"볼 "+strike+"스트라이크");
    	}while(strike!=3);
    	System.out.println("3스트라이크");
    	System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    	x=Integer.parseInt(Console.readLine());	
    	if(x==1)
    	{
    		computer.clear();
    		com_turn();
    	}
    	else
    	{
    		if(x==2)
    		{
    			return;
    		}
    			
    	}
    }
    
}


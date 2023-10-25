package baseball;
import camp.nextstep.edu.missionutils.Randoms;//Random
import camp.nextstep.edu.missionutils.Console;//Scanner




public class Application {
	public void check1(String value)
	
	{
		if(!value.equals("1")||!value.equals("2"))
		{
			throw new IllegalArgumentException("1 아니면 2만 선택하시오.");
		}
	}
public void check2(String value)
	
	{
		int len=value.length();
		if(len!=3)
		{
			throw new IllegalArgumentException("세 자리수여야 합니다.");
		}
		for(int i=0; i<len; i++)
		{
			if(i!=len-1)
			{
				if(value.charAt(i)==value.charAt(i+1))
				{
					throw new IllegalArgumentException("세 숫자가 같아야합니다.");
				}
				
			}
		}
		
	}
	public static void start_game()
	{
		int rand;
		String temp;
		Application except=new Application();
		while(true)
		{
			 rand=Randoms.pickNumberInRange(123,988);
			 temp=Integer.toString(rand);
			if(temp.contains(String.valueOf('0')))
				{
					continue;
				}
			else
			{
				
				break;
			}
		}
		int flag=0;
		int ball=0;
		int strike=0;
		while(true)
		{
			System.out.println("숫자를 입력해주세요 : ");
			String number=Console.readLine();
			try {
				except.check2(number);
			}catch(IllegalArgumentException e) {
				System.out.println( e.getMessage());
				break;
				
			}
			flag=0;
			strike=0;
			ball=0;
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
				{
					if(temp.charAt(i)==number.charAt(j))
					{
						flag=1;
						if(i==j)
						{
							strike++;
						}
						else
						{
							ball++;
						}
					}
				}
			}
			if(strike==0&&ball!=0)
			{
				System.out.println(ball+"볼");
			}
			if(ball==0&&strike!=0)
			{
				System.out.println(strike+"스트라이크");
				if(strike==3)
				{
					System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
					break;
				}
			}
			if(ball!=0&&strike!=0)
			{
				System.out.println(ball+"볼 "+strike+"스트라이크");
			}
			
			if(flag==0)
			{
				System.out.println("낫싱");
				
			}
			
		}
	}
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	Application except=new Application();
    	
    	start_game();
    	while(true)
    	{
    		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    		String choice=Console.readLine();
    		if(choice.charAt(0)=='1')
    		{
    			start_game();
    		}
    		else if(choice.charAt(0)=='2')
    		{
    			break;
    		}
    		else
    		{
    			try {
    				except.check1(choice);
    			}catch(IllegalArgumentException e) {
    				System.out.println(e.getMessage());
    				break;
    			}
    			
    		}
    	}
    }
}

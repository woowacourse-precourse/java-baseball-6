package baseball;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.*;

public class Application 
{
    private static int strike;
	private static int ball;

	public static void main(String[] args) 
    {
        while(true) 
        {
	    	System.out.println("숫자 야구 게임을 시작합니다.");
	    	List<Integer> computer = makeThreeRandomNum();
	    	
	    	strike = 0;
	    	ball = 0;
	    	
	    	while(strike < 3) 
	    	{
		    	System.out.print("숫자를 입력해주세요 : ");
		    	String userInput = Console.readLine();
		    	if(inputLengthThree(userInput) && inputNumberOnly(userInput) && inputAllDistinct(userInput)) 
		    	{
		    		howManyBallStrike(userInput, computer);
		    		printHint();
		    	}
	    	}
	    	
	    	System.out.println(strike+"스트라이크"
	    			+ "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
	    			+ "\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	    	
	    	String restartcheck = Console.readLine();
			inputNumberOneOrTwo(restartcheck);
			if(restartcheck.equals("2"))
				break;
        } 
        Console.close();
    }
	public static void printHint() 
	{
		if ((strike == 0) && (ball == 0)) 
		{
			System.out.println("낫싱");
		} 
		else if ((strike == 0) && (ball > 0))
		{
			System.out.println(ball+"볼");
		}
		else if ((strike > 0) && (strike < 3) && (ball == 0))
		{
			System.out.println(strike+"스트라이크");
		}
		else if ((strike > 0) && (ball > 0)) {
			System.out.println(ball+"볼 "+strike+"스트라이크");
		}
	}
	
    public static void howManyBallStrike(String userInput, List<Integer> computer) 
    {
    	strike = 0;
    	ball = 0;
    	for (int i = 0; i < 3; i++) 
    	{
    		char currentNum = userInput.charAt(i);
    		int num = Character.getNumericValue(currentNum);
    		correctNumCheck(computer, i, num);
    	}
    }
    
	public static void correctNumCheck(List<Integer> computer, int i, int num) 
	{
		if(computer.contains(num)) 
		{
			if(num == computer.get(i)) 
			{
				strike = strike + 1;
			} 
			else 
			{
				ball = ball + 1;
			}
		}
	}
    
	public static boolean inputAllDistinct(String userInput) 
	{
		Set<Character> set = new HashSet<>();

        for (int i = 0; i < userInput.length(); i++) // 중복된 값을 제외하고 입력값 전부를 배열에 추가 
        {
            set.add(userInput.charAt(i));
        }
        if (set.size() != userInput.length()) // 입력값의 길이와 배열의 크기가 다르다면 중복값이 있다는 의미
        {
            throw new IllegalArgumentException();
        }
        return true;
	}

	public static boolean inputNumberOnly(String userInput) 
	{
		if (!userInput.matches("\\d+"))
    	{
            throw new IllegalArgumentException();
        }
		return true;
	}
	
	public static void inputNumberOneOrTwo(String restartcheck) 
	{
		if (!restartcheck.equals("1") && !restartcheck.equals("2"))
    	{
            throw new IllegalArgumentException();
        }
	}

	public static boolean inputLengthThree(String userInput) 
	{
		if (userInput.length() != 3)
    	{
            throw new IllegalArgumentException();
        }
		return true;
	}
	
	public static List<Integer> makeThreeRandomNum() 
	{
		List<Integer> RandomNumbers = new ArrayList<>();
    	while (RandomNumbers.size() < 3) 
    	{
    	    int Num = Randoms.pickNumberInRange(1, 9);
    	    if (!RandomNumbers.contains(Num)) 
    	    {
    	    	RandomNumbers.add(Num);
    	    }
    	}
    	return RandomNumbers;
	}

}
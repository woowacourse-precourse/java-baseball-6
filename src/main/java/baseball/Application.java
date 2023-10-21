package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.*;

public class Application 
{
    public static void main(String[] args) 
    {
        
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	
    	
    	List<Integer> computer = makeThreeRandomNum();
    	System.out.println(computer);
    	
    	System.out.print("숫자를 입력해주세요 : ");
    	String userInput = Console.readLine();
    	Console.close();
    	inputLengthThree(userInput);
    	inputNumberOnly(userInput);
    	inputAllDistinct(userInput);
    	
		int strike = 0;
    	int ball = 0;
    	for (int i = 0; i < 3; i++) 
    	{
    		char currentNum = userInput.charAt(i);
    		int num = Character.getNumericValue(currentNum);
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
    	
    	if ((strike == 0) && (ball == 0)) 
    	{
    		System.out.println("낫싱");
    	} 
    	else if ((strike == 0) && (ball > 0))
    	{
    		System.out.println(ball+"볼");
    	}
    	else if ((strike > 0) && (ball == 0))
    	{
    		System.out.println(strike+"스트라이크");
    	}
    	else
    	{
    		System.out.println(ball+"볼 "+strike+"스트라이크");
    	}
    }

	public static void inputAllDistinct(String userInput) {
		Set<Character> set = new HashSet<>();

        for (int i = 0; i < userInput.length(); i++) // 중복된 값을 제외하고 입력값 전부를 배열에 추가 
        {
            set.add(userInput.charAt(i));
        }
        if (set.size() != userInput.length()) // 입력값의 길이와 배열의 크기가 다르다면 중복값이 있다는 의미
        {
            throw new IllegalArgumentException();
        }
	}

	public static void inputNumberOnly(String userInput) 
	{
		if (!userInput.matches("\\d{3}")) // 입력값에 숫자가 아닌 문자가 포함된 경우
    	{
            throw new IllegalArgumentException();
        }
	}

	public static void inputLengthThree(String userInput) 
	{
		if (userInput.length() != 3)
    	{
            throw new IllegalArgumentException();
        }
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
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
    	
    	List<Integer> computer = new ArrayList<>();
    	while (computer.size() < 3) 
    	{
    	    int randomNumber = Randoms.pickNumberInRange(1, 9);
    	    if (!computer.contains(randomNumber)) 
    	    {
    	        computer.add(randomNumber);
    	    }
    	}
    	
    	System.out.print("숫자를 입력해주세요 : ");
    	String userInput = Console.readLine();
    	Console.close();
    	
    	if (userInput.length() != 3)
    	{
            throw new IllegalArgumentException();
        }
    	
    	if (!userInput.matches("\\d{3}")) 
    	{
            throw new IllegalArgumentException();
        }
    	
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

}
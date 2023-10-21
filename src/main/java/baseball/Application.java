package baseball;

import java.util.ArrayList;
import java.util.List;

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
    }
}

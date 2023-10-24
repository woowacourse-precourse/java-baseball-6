package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) 
    {
        // TODO: 프로그램 구현
		// 게임 시작
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	
    	while(true)
    	{
    		int que[] = pickANumber();
 
    		while(true)
    		{
    			System.out.print("숫자를 입력해주세요 : ");
    			int ans[] = readAnswer();
        		int findS = findStrike(que, ans);
        		int findB = findBall(que, ans);
        		if(findB != 0)
        		{
        			System.out.print(findB + "볼 ");
        		}
        		if(findS != 0)
        		{
        			System.out.print(findS + "스트라이크");
        		}
        		if(findB == 0 && findS == 0)
        		{
        			System.out.print("낫싱");
        		}
        		System.out.println();
        		if(findS == 3)
        		{
        			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        			break;
        		}
    		}
    		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    		int re = reOrNot();
    		if(re == 2)
    		{break;}
    	}
    }
    private static int reOrNot()
    {
    	String re = Console.readLine();
    	if(re.equals("1"))
    	{
    		return 1;
    	}
    	else if(re.equals("2"))
    	{
    		return 2;
    	}
    	throw new IllegalArgumentException();
    }
    private static int[] pickANumber()
    {
    	int first = Randoms.pickNumberInRange(1, 9);
    	int second = Randoms.pickNumberInRange(1, 9);
    	while(first == second)
    	{
    		second = Randoms.pickNumberInRange(1, 9);
    	}
    	int third = Randoms.pickNumberInRange(1, 9);
    	while(first == third || second == third)
    	{
    		third = Randoms.pickNumberInRange(1, 9);
    	}
    	int[] value = {first, second, third};
    	return value;
    }
    private static int[] readAnswer()
    {
    	String ans = Console.readLine();
    	if(ans.length() !=3)
    	{
    		throw new IllegalArgumentException();
    	}
    	for(int i = 0; i < 3; i++)
    	{
    		if(!Character.isDigit(ans.charAt(i)))
        	{
        		throw new IllegalArgumentException();
        	}
    	}
    	if(ans.charAt(0)==ans.charAt(1) || ans.charAt(0)== ans.charAt(2) 
    			|| ans.charAt(1) == ans.charAt(2))
    	{
    		throw new IllegalArgumentException();
    	}
    	int[] value = {Character.getNumericValue(ans.charAt(0)),
    			Character.getNumericValue(ans.charAt(1)),Character.getNumericValue(ans.charAt(2))};
    	return value;
    }
    private static int findBall(int[] que, int[] ans)
    {
    	int cnt = 0;
    	for(int i =0; i < 3; i++)
    	{
    		for(int j = 0; j < 3; j++)
    		{
    			if(i == j) {continue;}
    			if(que[i] == ans[j])
    			{
    				cnt++;
    			}
    		}
    	}
    	return cnt;
    }
    private static int findStrike(int[] que, int[] ans)
    {
    	int cnt = 0;
    	for(int i =0; i < 3; i++)
    	{
    		if(que[i] == ans[i])
    		{
    			cnt++;
    		}
    	}
    	return cnt;
    }
}
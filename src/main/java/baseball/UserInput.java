
package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
	
	private List<Integer> user = new ArrayList<Integer>();
	
	public UserInput() {
		
	}
	
	public List<Integer> setUser(){
		System.out.print("숫자를 입력해 주세요 : ");
		user.clear();
		String num = Console.readLine();
		for(int i = 0; i < num.length(); i++) {
			user.add(Character.getNumericValue(num.charAt(i)));
		}
		if (user.size() != 3) {
			printError();
		}
		return user;
	}


	
	public void printError() {
		throw new IllegalArgumentException();
	}


} 
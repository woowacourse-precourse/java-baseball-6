package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.platform.commons.util.StringUtils;

public class Exception {

	public List<Integer> InputException(String input) {
		InputRangeException(input);
		List<Integer> InputNum = StrToList(input);
		InputNumException(InputNum);
		InputDuplicateException(InputNum);
		
		return InputNum;
	}
	
	//입력받은 값이 3개가 아닐 때
	public void InputRangeException(String InputNum) {
      if(InputNum.length() != 3) {
    	throw new IllegalArgumentException("3개의 수를 입력하십시오.");
    	}
	}
	
	//입력받은 값을 List로 변환하는 메소드	
	private List<Integer> StrToList(String num) {
		
	  return Arrays.stream(num.split(""))
		.map(Integer::parseInt)
		.collect(Collectors.toList());
	}
	
	//입력받은 값이 1~9의 숫자가 아닐 때 노출하는 오류 메세지
	public void InputNumException(List<Integer> InputNum) {
	  boolean check = InputNum.stream()
		.allMatch(num -> 1 <= num && num <= 9);
		
	  if(!check) {
		throw new IllegalArgumentException("1~9 사이의 수를 입력하십시오.");
		}
	}
	
	
	//입력받은 값이 중복되었을 때 나오는 오류 메세지
	public void InputDuplicateException(List<Integer> InputNum) {
	  boolean duplicate = InputNum.stream()
		.distinct()
       	.count() != InputNum.size();
	  
	  if(duplicate == true) {
		  throw new IllegalArgumentException("중복된 값입니다.");
	  }
		
	}
	
	//재시작 입력값 오류
	
	public Integer RestartException(String input) {
		int restart = StrToInteger(input);
		RestartRangeException(input);
		RestartNumException(restart);
		
		return restart;
	}
	
	private Integer StrToInteger(String num) {
		
		  return Integer.parseInt(num);
		}
	
	public void RestartRangeException(String InputNum) {
	      if(InputNum.length() != 1) {
	    	throw new IllegalArgumentException("1개의 수를 입력하세요.");
	    	}
		}
	
	public void RestartNumException(int InputNum) {
		boolean check = InputNum == 1 || InputNum == 2 ;
		
		if(!check) {
	      throw new IllegalArgumentException("1 혹은 2를 입력하십시오.");
		}
	}

}

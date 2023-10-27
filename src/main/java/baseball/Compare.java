package baseball;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Compare {
    public Integer CompareNum(List<Integer> Player, List<Integer> Computer) {
	 List<Integer> matchList = Player.stream().filter(o -> Computer.stream()
		.anyMatch(Predicate.isEqual(o))).collect(Collectors.toList());
	 int strike = 0;
	 int ball = 0;
	 

		 
	  for(int i=0; i <= 2; i++) {
	   if(matchList.size() == 0) {
		  break;
	   }
	  
	   if(Player.get(i) == Computer.get(i)) {
	   strike++;
	   }	  
	  }
	 
	  if(matchList.size() != 0) {
	   ball = matchList.size() - strike;
	  
	   System.out.println(ball + "볼 " + strike + "스트라이크");
	  
	   ball = 0;
	  }
	 
	  if(matchList.size() == 0) {
	   System.out.println("낫싱");
	  } 

	return strike;	
   }
}

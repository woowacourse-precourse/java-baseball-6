package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
	
	public int[] CreateRanNum() {
				
		int num[]= new int[3];
			for(int i=0;i<num.length;i++) {
				
				num[i] =Randoms.pickNumberInRange(1, 9);
				if(i>0) {
					for(int j=i-1;j>=0;j--) {
						if (num[i]==num[j]) {
							i--;
							break;
						}
					}
				}
			}
			for(int i=0;i<3;i++) {
				System.out.println(num[i]);
			}
		return num;
	}
}

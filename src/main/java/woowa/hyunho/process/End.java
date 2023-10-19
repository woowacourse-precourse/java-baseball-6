package woowa.hyunho.process;

import woowa.hyunho.messages.Messages;
import woowa.hyunho.utilities.Parse;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class End {
	List<Integer> selector;
	
	public int endProcess() {
		printEndMessages();
		getSelector();
		return selector.get(0);
	}
	
	private void printEndMessages() {
		Messages.askRestart();
	}
	
	private void getSelector() {
		String num = Console.readLine();
		selector = Parse.parseString(num);
	}
	
}
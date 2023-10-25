# 기능 구현 목록

## 어떻게 분리할 것인가.
1. 숫자 야구 게임은 크게 입출력 화면과 컴퓨터로 나눌 수 있다.
2. 입출력에서 입력과 출력, 즉 io를 담당하는 클래스를 분리한다. ConsoleInput, ConsoleOutput
3. 컴퓨터는 전반적인 동작을 조율하는 클래스(BaseballGame)와 게임의 로직을 담고있는 BaseballGameComputer로 분리한다.
4. BaseballGameComputer는 정답을 담은 리스트를 필드로 갖는다. 
5. BaesballGameComputer에는 사용자의 입력에 맞춰 결과인 Score를 반환하는 메서드를 작성한다.

고민: ConsoleOutput 클래스는 어쩔수없이 고정된 문자열과 동적으로 바뀌는 실행결과를 출력해야 한다.
그렇다면, 사용자가 정답을 맞추거나 틀렸을 경우 알맞은 응답을 결정하는 것은 어느 클래스에서 행해야할까(BaseballGame, ConsoleOutput)  
또한, 클래스간 의존성을 어떻게 해결해야할까. BaseballGame을 위해서는 ConsoleInput/Output, BaseballGameComputer가 모두 필요하다.
이들을 인스턴스 필드로 가질 것인지, run 메소드 내에서 지역변수로 생성할 것인지.
BaseballGameComputer를 싱글톤 패턴으로 만들어도 될까? -> 단일 유저 게임이라면 객체를 계속해서 생성, 삭제할 필요가 없지않나
-> but 싱글톤패턴을 써서 얻는 장점도 없다. 싱글톤패턴은 다중 환경에서 stateless 할 때 강하다.

## 기능 

### ConsoleInput
field:  
method: guessAnswer, askTermination

### ConsoleOutput
field:   
method: printResult, printStart, printFail, printSuccess

### BaseballGame
field : 
method : run  

### BaseballGameComputer
field : List<Integer> answer  
method : generateAnswer, scoring  

### Score
field : Integer strike, Integer ball  
method : getStrike, getBall   

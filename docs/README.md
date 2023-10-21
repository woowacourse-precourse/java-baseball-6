baseball 게임을 진행할 클래스를 하나 생성한다. 
굳이 클래스를 생성하는 이유는 한 번 만들어두면 main 외에도 다른 곳에서 사용할 수 있기 때문이다.

**기능 구현 목록**
1. BaseBallGame 클래스 구현
- 컴퓨터가 무작위로 작성한 숫자열과 사용자가 입력한 숫자열을 각각 ArrayList로 저장한다
- 컴퓨터가 무작위로 숫자를 생성할 때는 resetComputerNumber, 입력한 유저의 숫자를 다시 리스트로 넣는 과정은 resetUserNumber로 진행한다. 이때 resetUserNumber에서 IllegalArgumentException를 체크한다.
- 스트라이크를 판정하는 메소드는 checkStrike, 볼을 판정하는 메소드는 checkBall로 확인한다. 이들의 실행 결과로 클래스의 필드에 있는 strike, ball에 저장한다.
- 최종적인 판단을 출력하는 메소드는 printResult이다.
- 전체적인 게임 흐름은 playBaseballGame에서 구현한다.

2. Application
- 여기서는 값을 입력받고, BaseBallGame 클래스 객체를 생성해서 게임을 진행하는 것을 반복한다.
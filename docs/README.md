### 기획 목표

baseball 게임을 진행할 클래스를 하나 생성한다. 
굳이 클래스를 생성하는 이유는 한 번 만들어두면 main 외에도 다른 곳에서 사용할 수 있기 때문이다.

---

### 기능 구현 목록
1. Baseball 클래스 구현
   - 컴퓨터가 무작위로 작성한 숫자열과 사용자가 입력한 숫자열을 각각 *ArrayList*로 저장한다
   - 컴퓨터가 무작위로 숫자를 생성할 때는 *resetComputerNumber*, 입력한 유저의 숫자를 다시 리스트로 넣는 과정은 *resetUserNumber*로 진행한다. 이때 *resetUserNumber*에서 *IllegalArgumentException*를 체크한다.
   - 스트라이크를 판정하는 메소드는 *checkStrike*, 볼을 판정하는 메소드는 *checkBall*로 확인한다. 이들의 실행 결과로 클래스의 필드에 있는 *strike*, *ball*에 저장한다.
   - 최종적인 판단을 출력하는 메소드는 *printResult*이다.
   - 전체적인 게임 흐름은 *playBaseballGame*에서 구현한다.
   - **(231022일 추가)** *checkStrike*와 *checkBall*은 *playGame* 메소드에 통합해서 사용한다.
   - **(231025수 추가)** *Baseball* 생성자에서 *ArrayList* 객체를 생성한다.

2. Application
   - 여기서는 값을 입력받고, *Baseball* 클래스 객체를 생성해서 게임을 진행하는 것을 반복한다.
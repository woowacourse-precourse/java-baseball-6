## [구현할 기능 목록]

------------------------------

### 기능 설명
 - 1 ~ 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임

### 입력 조건
 - 서로 다른 3자리의 수
 - 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

### Class
#### BaseballGame

- 변수
  - answer : makeRandomAnswer 메서드를 통한 자체적인 answer 생성하여 저장하는 변수
    
- 메서드
  - void start() : 게임을 시작하는 최초의 메서드
  - int makeRandomAnswer() : random으로 서로 다른 3자리의 수를 생성해주는 메서드
  - int getUserAnswer() : user에게 서로 다른 3자리의 수를 입력받아 반환하는 메서드
  - boolean checkUserAnswer(int userAnswer) : user의 입력값과 random 생성된 게임의 answer를 비교해주는 메서드
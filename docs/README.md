# 구현할 기능 목록

- [ ]  게임 시작 전 문구 출력
- [ ]  게임이 시작되면, 컴퓨터의 숫자를 생성한다
- 이 때 생성되는 숫자는 3자리의 서로 다른 숫자가 되어야 한다.
- [ ]  플레이어가 3 자리의 숫자를 순서대로 맞출 때까지 계속 게임을 진행한다
- [ ]  플레이어가 숫자를 입력하면, 볼(숫자 일치, 위치 불일치)과 스트라이크(숫자와 위치 모두 일치)의 개수를 판단한다.
- [ ]  플레이어가 조건에 맞지 않는 숫자를 입력했다면 IllegalArgumentException 를 발생시키고 애플리케이션을 종료한다.
- 이 때, 입력 조건은 서로 다른 3개의 1~9까지의 숫자로 이루어진 3자리의 숫자이다.
- [ ]  만약, 스트라이크의 개수가 3개라면, 게임이 끝이 난다
- [ ]  게임이 끝났다면, 재시작 여부를 물어본다.

# 어떤 클래스가 필요할까?
## Application
### 변수
### 함수
- printStartMessage(): 게임 시작 메시지 출력한다.
- loop(): 플레이어가 원하는 한에서 게임을 계속 반복한다.
- readRestartIntent(): 게임을 계속 할지 입력을 받는다.
-
## Game
### 생성자
- createRandomTarget()를 호출한다.
### 변수
- NUMBER_OF_TARGET : 플레이어가 맞춰야 할 공의 개수를 저장한 상수
- targetMap: 공의 숫자가 Key 값으로, 순서가 Value 로 저장된 HashMap
### 함수
- createRandomTarget()
    - 플레이어가 맞춰야 할 컴퓨터의 공, 타겟을 targetMap에 설정한다.
- start(): 하나의 게임을 시작하는 함수
    - roundStart()
        - readPrediction()
            - convertToList()
        - gradePrediction()
        - printGrade()

# 더 발전시킬 것은 없을까?
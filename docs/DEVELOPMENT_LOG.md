# 1. 첫 클래스 구상 (어떤 클래스가 필요할까?)
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

# 2. 디벨롭 아이디어 (더 발전시킬 것은 없을까?)
- 변수, 함수, 클래스에 더 어울리는 접근제어자로 수정하자
- ~~Game 인터페이스를 만들고 Game을 상속받는 BaseballGame 을 만들자~~
  - 상위 패키지 명이 baseball 이므로 다른 게임으로 바꿔서 애플리케이션을 실행하는 경우를 제외
- Application 은 생성자에서 Game 을 받아서 실행하자
- gradePrediction이 strikeCount 만을 반환하고 있으니, Score 클래스를 만들자
- BaseballGame 클래스를 BaseballGame, Player, Computer 로 나누어 클래스를 작게 유지하자
- 의미를 가지거나 변경될 수 있는 상수를 BaseballConstant 에 저장하자

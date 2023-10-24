## ✅ What to do?!

### 1. 역할 분리

+ Model
    + ```컴퓨터```와 ```사용자```로 구분
+ View
    + 게임 결과 ```메시지```를 표시
+ Controller
    + 게임 ```진행```
+ Service
    + 게임 진행 관련 ```비즈니스 로직``` 구현
+ Util
    + Service 단의 비즈니스 로직 구현에 필요한 validation check, exception 등의 기능 모아두기

### 2. 구현 흐름

1) model package 안에 Computer, User class 생성
   ~~~
    Computer는 숫자 랜덤 값을 생성하고 User는 숫자를 입력 받는다.
   ~~~

2) controller package 안에 게임 진행 관련 작업을 담당할 GameController 생성
   ~~~
    게임 흐름에 맞춰 가시적으로 구현한다. 복잡한 로직은 service에서 구현 하기로 함.
   ~~~

3) service package 안에 GamePlayService 생성
   ~~~
   흐름대로 로직을 한 줄 한 줄 써내려가기. 일단 만들자!! 🙃
   ~~~

4) 구현 조건 체크하며 코드를 짭니다. 중간중간 ```디버깅```은 필수!! & ```구글링``` 만세! 🙌
   ~~~
    ✅ camp.nextstep.edu.missionutils 라이브러리 사용
    ✅ 서로 다른 3자리의 수를 입력 받음
        - 입력 받은 숫자가 3개를 초과하지 않는가?
        - 입력 받은 숫자가 1에서 9사이 범위 안에 있는가?
        - 숫자가 중복되지 않는가?
    ✅ 스트라이크, 볼 계산을 해보자
        - 카운트 코드 추가
    ✅ 게임이 끝난 후 재시작/종료 구분하는 1과 2 중 하나의 수
        - 입력 받은 숫자가 하나인가?
        - 입력 받은 숫자가 1 또는 2가 맞는가?
    ~~~

5) sysout으로 ```컴퓨터 입력 값을 확인```하여 3스트라이크일 때 재시작 여부를 테스트 👉 확인! <br><br>
6) 코드 살펴보며 오류나 불필요한 부분 정리
    ~~~
    ✅ 3스트라이크 메시지 중복 적용 확인
        - 중복 코드 삭제
    ✅ 구현 하고 보니, GamePlayService의 로직이 처음 생각했던 GameController의 역할을 대체하고 있음을 확인 
        - GamePlayService의 코드를 GameController로 이전하여 테스트 진행
        - 정상 동작 확인 후, GamePlayService 삭제
   ~~~
7) Application Test 실행 👉 BUILD SUCCESSFUL!!

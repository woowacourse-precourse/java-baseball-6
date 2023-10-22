## 기능 목록
* 입력값을 받는다
* 입력값을 검증한다
* 입력값에 대한 결과를 평가한다
* 결과를 출력한다
* 새 게임을 생성한다
* 게임을 종료한다

## 설계
### 도메인 모델
![domain_model](./images/DomainModelv1.png)
* Console Input : 사용자에게 입력을 받음  
* Console Logger :  사용자에게 게임 시도 결과를 출력
* Game Executor : 게임을 실행
* Game : 게임 로직을 수행하는 역할
* GameTrial : 게임의 한 턴

### 도메인 상태 모델
![state_model](./images/StateDiagramv1.png)
1. 상태
   * Wait For Input : 새로운 게임을 시작하고 사용자의 입력을 기다리는 상태
   * Game Over : 게임을 종료시키고, 새개임을 시작할지, 프로그램을 종료할지 입력을 기다리는 상태
2. 트리거
    * Wrong Answer : 사용자가 유효하지만 틀린 답을 입력한다  
    * Correct Answer : 사용자가 정답을 입력한다
    * Restart : 사용자가 게임을 다시 시작하는 것을 선택한다
    * End : 사용자가 종료를 선택
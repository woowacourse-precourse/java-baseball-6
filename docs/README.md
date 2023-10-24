# 게임 진행

1. 프로그램 실행 시 컴퓨터는 서로 다른 임의의 수 3자리를 선택
2. 플레이어는 컴퓨터가 선택한 서로 다른 3개의 숫자를 유추하여 입력
3. 컴퓨터는 플레이어가 입력한 숫자에 대한 결과를 출력
4. 입력한 숫자가 컴퓨터의 숫자와 같지 않으면 프로그램 재실행
5. 입력한 숫자가 컴퓨터의 숫자와 같으면 게임 종료
6. 게임이 끝나면 게임 재시작 또는 완전 종료 이중택일

# 기능 목록
- 컴퓨터 숫자 생성 기능
- 사용자 숫자 입력 기능
    - 입력 값 예외 검증 기능
- 컴퓨터 및 사용자 숫자 비교 기능
    - 스트라이크 카운트 및 볼 카운트
    - 스트라이크, 볼, 낫싱 메세지 반환
- 게임 종료 조건 검증 기능
    - 조건에 따른 재시작 및 게임 종료

# 순서도
<img src="./baseball.png">

# 디렉토리 구조 설계

## service
    - 사용자에게 전달 받은 데이터를 가공 및 처리한다.
    - 사용자 입력에 대한 처리를 담당한다.

## controller
    - 모델이나 뷰를 알고 있어야 한다.
    - 모델과 뷰의 변경을 모니터하고 있어야 한다.
    - 입력을 받아 service로 전달

## view
    - 모델이 가지고 있는 정보를 뷰가 갖고 있어선 안된다.
    - 모델이나 컨트롤러와 같은 구성요소들을 몰라야 한다.
    - 변경이 일어나면, 변경 통지에 대한 처리방법을 구현해야한다.

## util
    - 프로젝트 전역에서 사용되어야 한다.
    - 특정 로직이나 독립적인 기능이어야 한다.
    - 가능하면 어떤 상태를 가지지 않는 기능이어야 한다.

# 디렉토리 구조
```
baseball
    │  Application.java
    │  
    ├─ controller
    │      GameController.java
    │      
    ├─ service
    │      ComputerService.java
    │      UmpireService.java
    │      UserService.java
    │      
    ├─ util
    │   │  Constants.java
    │   │  Messages.java
    │   │  
    │   └─validation
    │          InputNumbersValidation.java
    │          restartNumberValidation.java
    │          
    └─ view
         InputView.java
         OutputView.java
```
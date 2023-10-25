# 미션 -숫자 야구 게임

## 🚀🚀 기능 목록

-----

> #### 🎮Domain

Domain에서는 비지니스 도메인의 객체 관리

- Game : 게임 관련 도메인 저장 관리
- User : 사용자 관련 도메인 저장 관리

> #### 🏭Service

Service에서는 게임에 필요한 비지니스 로직들을 구현하고 기능별로 독립적으로 구현하여 기능 별 유지보수에 이점 기대

###### 주요 메소드

- ``playGame()``  : 실행 시 숫자 야구 게임 전체 사이클 진행(재시작 여부 포함)

- ``setGame()``  : 실행 시 게임 필드 값 초기화 및 랜덤 숫자 생성 메소드 호출

- ``getRandomNumbers()``  :실행 시 랜덤 숫자 생성

- ``requestUserNumbers()``  :실행 시 사용자 입력값 요청

- ``compare()``  : 실행 시 숫자야구 게임 결과 판단

- ``requestRetry()``  : 실행 시 게임 재시작 여부 요청

> #### 🧮 Utils

Util에서는 전역에서 사용되는 특정 로직이나 랜덤값 생성
paramater만 갖고 단순한 처리만 하는 메소드를 만들고자 노력함

- CompareUtils : 볼 스트라이크 여부 판단

- ParseUserInput : 사용자에게 입력 받는 값의 유효성 검사

- RandomUtils : 게임에 사용 될 랜덤값 생성 및 유효성 검사

> #### ⚙ Controller
Controller 에서는 GameService 에서 구현 된 비지니스 로직을 호출하여 트랜잭션 처리와 응답에 집중하도록 코드를 구성하고자 한다.
이를 통해 중복되는 코드를 최소화 하고 기능 유지보수에 이점이 있을 것을 기대.

GameController :

- ``run()``  : 실행 시 숫자야구 게임의 모든 과정 실행 (게임 세팅, 게임 시작, 재시작 여부)
- ``setGame()`` :
- ``playGame()`` :
- ``requestRetry()``: 실행 시 게임 재시작 여부 입력 요청

> #### 💬 View

View 에서는 화면에 출력될 문자열 처리

- PrintGameResult : 숫자 야구 게임 결과를 출력  (ex 1볼 1스트라이크)

- SystemMessage : 게임에 필요한 문구 출력
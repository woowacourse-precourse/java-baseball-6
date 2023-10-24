<div align="center">

# 숫자 야구 미션 ⚾️
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"/>
<img src="https://img.shields.io/badge/junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white"/><br>

</div>

## 👩🏻‍💻 구현할 기능 목록

1. 게임을 시작할 때 상대방(컴퓨터)의 수를 생성해서 저장한다.<br>
   ✦ 조건: 1부터 9까지 _서로 다른_ 수로 이루어진 _3자리의_ 수 <br><br>
2. 게임 플레이어가 입력한 값을 예외 처리한다. <br><br>
3. 입력 값과 컴퓨터의 수를 비교하여 결과를 출력한다.<br>
   ✦ 같은 수가 같은 자리에 있으면 `스트라이크`<br>
   ✦ 같은 수가 다른 자리에 있으면 `볼`<br>
   ✦ 같은 수가 전혀 없으면 `낫싱`<br><br>
4. 숫자를 모두 맞추면(`3스트라이크`) 게임을 종료한다.<br><br>
5. 게임을 재시작 혹은 종료한다.<br><br>


## 🏛️ 프로젝트 패키지 구조

```bash
├── main
│   ├── Application.java
│   ├── AppConfig.java
│   ├── GameController.java
│   ├── GameService.java
│   ├── CodeRepository.java
│   ├── Code.java
│   └── Grade.java
│
└── test
    ├── ApplicationTest.java
    ├── CodeRepositoryTest.java
    └── GameServiceTest.java

```

1. <b>Application</b><br>
   프로그램을 실행하고 게임 플레이어로부터 입력 받아 요청을 전달한다. 게임 진행 안내와 결과를 출력한다.<br><br>

2. <b>Controller</b><br>
   가장 먼저 Application의 요청을 받는다. 입력된 값의 validation 예외는 이곳에서 처리한다. <br><br>

3. <b>Service</b><br>
   핵심 로직을 담당한다. Controller에서 받은 확인된 요청을 처리한다.<br><br>

4. <b>Repository</b><br>
   데이터 저장소이다. 데이터를 삽입하거나 삭제, 조회하는 등 데이터 처리 메서드를 정의한다.<br><br>

5. <b>Entity</b><br>
   프로그램에서 다룰 데이터들을 객체화 한 것이다. 같은 엔티티끼리는 같은 속성을 가진다.<br><br>


## 🚨 입력 예외 처리
`camp.nextstep.edu.missionutils.Console`의 `readLine()`을 통해 `String`으로 입력 받은 값은 아래의 형식을 지켜야 한다.

1. 입력 값의 길이는 3이어야 한다.<br><br>
2. 파싱한 각 문자는 정수로 변환 가능해야 한다.<br><br>
3. 각 숫자의 범위는 1부터 9이다.<br><br>
4. 각 숫자는 서로 다르다.<br><br>


## 📑 로그
1. **첫 번째 구현 (2023.10.21)** <br><br>
    1. 프로젝트 구조 <br>
       스프링의 계층적 설계를 생각하며 프로그램의 구조를 설계하였다. 단순한 프로그램이기에 불필요한 계층이 있지는 않은지 추후 생각해야 한다. 계층 간의 역할 분리를 하여 <b>책임이 최대한 분명하게 구분되도록</b> 노력하였다. 이를테면 처음에는 출력을 Controller에서 하였지만 Application이 가장 상위 계층이기에 모든 출력을 담당하였다. 대신 Controller에서는 입력 값(요청)에 대한 validation을 진행한다. <br><br>
    2. Indent와 가독성
       ```java
       // Application.java 변경 전 코드
       boolean pass = false;
       while(!pass) {
             /* 중략 */
             if(pass) {
                 /* 중략 */
                 pass = gameController.determineRestarting(command);
                 /* 중략 */
                 if(!pass)
                   computerCodeId = gameController.gameStart();
             }
         }
       
       // Application.java 변경 후 코드
       boolean pass = false;
       boolean restart = false;
       while(!pass) {
             /* 중략 */
             if(pass) {
                 /* 중략 */
                 restart = gameController.determineRestarting(command);
             }
 
             if(restart) {
                 computerCodeId = gameController.gameStart();
             }
         }
       ```
       indent를 줄이고 게임 통과와 재시작은 다른 기능이기 때문에 다른 boolean 변수에 담았다.(pass와 restart) 변경 전의 경우, 각 코드의 역할을 한 눈에 파악하기 어렵다. <br><br>
1. **두 번째 구현 (2023.10.24)** <br><br>
   1. 클린 코드<br>
      우테코와 구글의 자바 코드를 꼼꼼히 읽어 본 후 들여쓰기, 공백부터 살펴보며 리팩토링을 하였다. 메서드명을 기능을 이해하기 쉽게 고치거나 변경되지 않을 메서드 매개변수에 final을 붙이는 증 추가적인 리팩토링도 진행하였다.
   2. Dependency Injection 도입<br>
      처음에는 아래와 같이 의존관계가 있는 클래스들을 클래스 내부에서 직접 인스턴스를 생성하여 사용하였다.
      ```java
      class GameController {
        private final GameService gameService = new GameService();
      }
      ```
      하지만 이는 확장성 측면에서도 좋지 않은 코드이고 DIP에도 어긋난다. 따라서 생성자 주입으로 각 클래스의 의존성을 주입하고 설정 파일(AppConfig)에서 의존성을 설정하도록 하였다.
      ```java
      class GameController {
        private final GameService gameService;
        public GameController(final GameService gameService) {
            this.gameService = gameService;
        }
        // 생략
      }
      ```
      ```java
      class AppConfig {
        // 생략
        public GameController gameController() {
          return new GameController(gameService());
        }
      }
      ```
# :beginner: 우아한테크코스 프리코스 1주차 : 숫자 야구

## 목차

- [1. 구현 기능 목록](#ballotboxwithcheck-구현-기능-목록) <br/>
- [2. 문제 해결 과정](#bookmark_tabs-문제-해결-과정)
- [3. 다음 미션에 적용할 학습 내용](#ledger-다음-미션에-적용할-학습-내용) <br/>

# :ballot_box_with_check: 구현 기능 목록
- [ ] controller Package
  - [ ] BaseballGameController
    - view Package와 domain Package의 데이터를 전달하며 값을 출력하는 클래스
- [ ] domain Package
  - [ ] BaseballNumber
    - 게임을 위해 입력한 숫자에 대해서 유효성 검사와 값의 반환을 담당하는 클래스
- [ ] handler Package
  - [ ] InputHandler, OutputHandler  
    - view Package의 ConsoleInput과 ConsoleOutput의 확장성과 변경 용이성을 위한 인터페이스 
  - [ ] ErrorHandler
    - Enum 클래스를 활용하여 프로그램에서 발생하는 에러 코드들을 관리하는 클래스
- [ ] service Package
  - [ ] BaseballGameService
    - 숫자 야구 게임에 대한 비즈니스 로직을 담당하는 클래스
- [ ] view Package
  - [ ] ConsoleInput, ConsoleOutput
    - 입력과 출력을 담당하는 클래스

# :bookmark_tabs: 문제 해결 과정

## 🤔 MVC 패턴을 사용한 이유

🔹 객체 지향적인 코드를 작성하기 위해 학습을 하며 객체 지향 프로그래밍은 코드를 객체로 모델링하고, 캡슐화, 상속, 다형성 등의 원칙을 적용하여 객체 간의 상호작용을 설계하는 방법이라고 생각했다. 이러한 객체지향의 4가지 특징을 잘 나타내기 위한 구조에는 어떤 방법이 있을까 찾아본 결과 MVC 패턴을 활용하기로 했다. 

controller는 비즈니스 로직이 들어가지 않고 domain과 view 사이의 정보를 전달하기 위해 service 혹은 domain을 호출하는 역할로 구조를 생각했다. 또한 Application 클래스를 활용한다면 객체들 간의 직접적인 결합을 피하고, 느슨한 관계 설정을 통해 보다 유연하고 변경이 용이한 프로그램을 설계할 수 있다고 생각했다.

domain의 경우 본래는 비즈니스 로직과 데이터를 관리하고 제어하는 역할을 하지만, 이번 경우에는 domain 부분의 역할을 분담하기 위해 service에서 비즈니스 로직을 담당하고 domain은 데이터의 유효성 검사, 저장 등을 처리하도록 했다.

-> 🔹 이 부분은 아직까지 고민 중인 부분이다. domain에서 로직과 유효성 검사 등 모든 부분을 담당할지 service Package를 둬야 할지는 코드를 작성해 보면서 고민을 해보고 미션이 끝난 후에는 피어 리뷰 시스템을 통해서 다른 분들의 의견을 듣고 다음 미션에 적용해야겠다고 생각했다.  

service는 domain 객체와 엔티티를 활용하여 비즈니스 로직을 구현하고 제공하는 역할로 구조를 생각했다.

handler를 통해서는 여러 가지 예외 상황 혹은 요청을 처리할 수 있도록 구현했다.

view 역시 input의 경우 값을 입력받는 역할만 할 수 있도록 구현하고, output도 출력만 구현할 수 있도록 구현했다.

## 🤔 인터페이스를 사용한 이유

🔹 인터페이스는 확장성과 변경 용이성의 이유로 사용했다. 하지만, 매번 추상화와 확장성을 고민하며 관리하다 보면 오버엔지니어링이 될 수 있다는 말에 다른 분들과 피드백을 주고받으며 더 생각해 봐야 하는 문제인 것 같다.

# :ledger: 다음 미션에 적용할 학습 내용
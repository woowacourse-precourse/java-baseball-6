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

---

# :bookmark_tabs: 문제 해결 과정

---

# :ledger: 다음 미션에 적용할 학습 내용
# ⚒️ 개발 구현 목록

## 📌 구현목표
**1. 프로젝트 상황에 맞는 코드 짜기**

- 하나의 메서드에서는 한가지 역할만 수행하기
- 기능별 역할별 분담에 집중하기
- 이유있는 코드 작성하기

**2. 미션내용을 서비스 구현이라 생각하기**

- 앞으로 기능 추가 및 수정에 용의한 패턴 사용하기(MVC 패턴)
- 접근 제한자 고민하며 개발하기
- spring boot 실행 과정을 기반으로 개발하기

**3. 미션제한 사항**

- Random, Console -> 제공하는 라이브러리 사용하기
- javaDoc 기반 클린코드 구현
- read.me 작성하기

---

## 📂 기능 구현 명세서

- Controller
  - startBaseBall() : 입력한 유저 정답 확인 후 REFEREE 객체 view 레이어에 반환


- Service
  - BaseballService()
    - scoreReset() : strike, ball 객체를 리셋하는 서비스 입니다.
    - userAnswerCheck() : controller에서 받은 사용자 입력 답을 심사하는 서비스입니다.
      - baseballReferee() : 파라미터로 들어온 입력값을 판단하여 strike, ball 카운트하는 서비스입니다.
    - decision() : 카운트가 끝난 Strike, Ball 객체를 Referee 객체로 반환하는 서비스 입니다.

- Repository
  - BaseBallRepository
    - createAnswer() : AnswerFactory 에서 Answer(랜덤 배열) 객체를 생성합니다.
    - getAnswer() : Answer 객체의 Int[] 타입으로 랜덤 배열을 리턴합니다.
    - getNumberVisit() : Answer 객체의 랜덤 배열 요소의 출력 유무를 boolean[] 타입으로 리턴합니다.


- View
  - startView() : 게임 시작 문구 출력
  - initView() : 사용자 입력 텍스트 및 입력 view
  - resultTextView() : Referee 결과를 받아 결과 출력,
  - restartView() :  정답시 선택 창 출력 view
  - endView() : 게임 종료 문구 출력


- Domain
  - AnswerFactory : Answer 객체를 생성하는 객체 입니다.
    - Answer :  랜덤 배열과 배열의 유무를 boolean[]로 갖고 있는 객체입니다.
  - Ball : 볼 결과를 갖고 있는 객체 입니다.
  - Strike : 스트라이크 결과를 갖고 있는 객체 입니다.
  - Referee : 심판 객체로 Ball, Strike 객체를 갖고 결과 객체로 사용됩니다.
  - convert
    - BaseballConverter
      - 타입을 변화는 역할을 담당하는 class 입니다.


- Setting
  - ReadyGame
    - injection() : controller, service, repository 객체를 생성자 주입으로 싱글톤을 유지하기위한 기초 setting 메서드


- resolver
  - ViewResolver.class : controller 과 view 영역을 연결하는 클래스 입니다.

---
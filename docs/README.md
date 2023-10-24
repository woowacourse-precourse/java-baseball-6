야구 게임 프로젝트


프로젝트 소개
   본 프로젝트는 간단한 야구 게임을 Java로 구현한 것입니다. 
   사용자는 플레이어로서 게임에 참여하며, 컴퓨터의 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임입니다.


구현 기능 목록
1. baseball
   - Application.java: 게임 실행을 위한 메인 뷰 클래스

2. domain
   - Baseball.java: 야구 게임의 주요 로직 처리
   - Computer.java: 컴퓨터의 로직 처리
   - GameResult.java: 게임 결과 상태와 관련된 로직 처리
   - Player.java: 사용자의 로직 처리

3. view
   - InputView.java: 사용자 입력 처리 뷰 클래스
   - OutputView.java: 게임 출력 뷰 클래스
   
4. controller
   - Controller.java: 야구 게임의 주요 로직 제어

5. util
   - InputValidator : 입력에 대한 유효성 검사

6. constants
   - Constant.java: 상수값 저장
   - Message.java: 사용자에게 보여줄 메시지 저장
   - Regex.java: 프로젝트에서 사용되는 정규표현식 저장

7. test
   - ApplicationTest.java: 게임 테스트 클래스
   - GameResultTest.java: 게임 결과 테스트 클래스
   - PlayerTest.java: 사용자 입력 테스트 클래스
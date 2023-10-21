## 프로젝트 구조설계
<hr>

**MVC 패턴 적용**
- Domain: 비즈니스 도메인 객체
  - User
  - Computer
- Service: 컨트롤러에 필요한 핵심 비즈니스로직 구현
  - ...
- View: 사용자에게 보일 user interface담당, 데이터나 로직 처리는 없어야하며 오직 '출력'만 담당.
  - InputView
  - OutputView (최종)
- Controller: model과 view의 연결
  - BaseballController

- 예외처리도 따로 빼줘야될지
## 기능 명세 작성
<hr>


- [ ] 컴퓨터 숫자 생성
- [ ] 유저 숫자 입력 받기
- [ ] 유저 입력과 컴퓨터의 숫자 비교후 정답 return
- [ ] 게임 종료 조건 판단
  - [ ] 1이 들어온다면 게임 재시작.
  - [ ] 2가 들어왔다면 게임 종료.
- [ ] view(input, output) 구현
- [ ] 예외처리

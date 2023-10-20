# Model
- [x] 볼의 숫자 위치 정보 비교 - BallPosition
- [x] 볼의 숫자 정보 비교 - BallNumber
- [x] 숫자 정보, 위치 정보를 가지고 볼을 비교 - Ball
- [x] 볼을 비교한 결과를 (스트라이크> 볼 > 낫띵) 우선순위로 비교하기 - BallResult
- [x] BALL 결과를 저장, 업데이트 하고 String 으로 결과 반환  - BallNum
- [x] STRIKE 결과를 저장, 업데이트 하고 String 으로 결과 반환 - StrikeNum
- [x] Ball 3개를 가져 서로 비교하며 볼, 스트라이크 수 계산 - Balls
- [x] 게임 결과를 저장 - GameResult
- [x] 랜덤한 볼을 생성 - RandomBallGenerator
- [x] 숫자를 Balls 로 변환 - BallConvertor
- [x] 랜덤한 Balls 를 갖는 컴퓨터 - Computer
- [x] 입력한 Balls 를 갖는 Player - Player
- [x] Computer 와 Player 가 Extends 하는 abstract class - Playable 
- [x] 게임 제시작 여부를 저장 맟 판단하는 트리거 - RetryTrigger
- ### 추가사항
- [x] Balls 생성 시 입력 숫자가 세자리 수가 아니면 IllegalArgumentException 발생시키기 - Balls
- [x] 3스트라이크 게임 종료 여부 파악하기 - GameResult
- [ ] Ball 생성 시 입력 숫자가 1~9 가 아니라면 IllegalArgumentException 발생시키기 - BallNumber
- [ ] 입력한 숫자에 중복 숫자가 있으면 IllegalArgumentException 발생시키기 - BallConvertor

# View
- [x] 숫자 입력하기 - InputView
- [x] 게임 결과 출력하기 - OutputView
- [x] 3 스트라이크시 게임 종료 문구 출력하기 - OutputView
- [x] 게임 새로 시작 여부 입력하기 - InputView

# Controller
- [x] 3 스트라이크 전 까지 숫자 입력, 결과 출력 반복하기
- [x] 게임 새트로 시작 여부 입력값에 따라 게임 다시 시작하기
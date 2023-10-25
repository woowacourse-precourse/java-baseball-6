<h1>구현 기능 목록</h1>
<hr/>

<h3>전광판(Console출력) 관련기능</h3>
<h4>관련 Package: baseball/game/displayboard</h4>
<h4>관련 Class, interface: DisplayBoard(interface), DisplayBoardImpl</h4>

| 번호 | 기능              | 설명                             | 관련 함수                     |
|:--:|:----------------|:-------------------------------|:--------------------------|
| 1  | 게임 시작 출력        | 게임 시작과 관련된 문구를 출력한다.           | displayGameStart()        |
| 2  | 사용자 입력 요청 출력    | 사용자의 숫자 입력을 요구하는 문구를 출력한다.     | displayRequestNum()       |
| 3  | 점수 출력           | 게임의 점수에 따라 결과 문구를 출력한다.        | displayScore(Score score) |
| 4  | 게임 재시작 여부 확인 출력 | 게임의 재시작 여부를 사용자에게 묻는 문구를 출력한다. | displayQuestionRestart()  |

<hr/>
<h3>게임 조작 관련 기능</h3>
<h4>관련 Package: baseball/game/gamesetter</h4>
<h4>관련 Class, interface: GameSetting(interface), GameSettingImpl</h4>

| 번호 | 기능            | 설명                      | 관련 함수                 |
|:--:|:--------------|:------------------------|:----------------------|
| 1  | 게임 시작         | 게임 시작에 필요한 작업을 한다.      | startGame()           |
| 2  | 게임 진행         | 게임을 진행한다.               | progressGame()        |
| 3  | 게임 재시작 여부 확인  | 게임의 재시작 여부를 사용자에게 확인한다. | questionRestartGame() |

<hr/>

<h3>타자</h3>
<h4>관련 Package: baseball/game/hitter</h4>
<h4>관련 Class, interface: Hitter(interface), PlayerHitterImpl</h4>

| 번호 | 기능    | 설명               | 관련 함수   |
|:--:|:------|:-----------------|:--------|
| 1  | 휘두르기  | 사용자의 숫자를 입력 받는다. | swing() |

<hr/>

<h3>투수</h3>
<h4>관련 Package: baseball/game/pitcher</h4>
<h4>관련 Class, interface: Pitcher(interface), ComputerRandomPitcherImpl</h4>

| 번호 | 기능   | 설명                     | 관련 함수   |
|:--:|:-----|:-----------------------|:--------|
| 1  | 던지기  | 컴퓨터가 랜덤으로 공(숫자)을 생성한다. | pitch() |

<hr/>

<h3>심판</h3>
<h4>관련 Package: baseball/game/umpire</h4>
<h4>관련 Class, interface: Umpire(interface), ComputerUmpireImpl</h4>

| 번호 | 기능       | 설명                                                     | 관련 함수   |
|:--:|:---------|:-------------------------------------------------------|:--------|
| 1  | 스트라이크 확인 | 투수의 공(숫자)과 타자의 배트(숫자)를 비교하여 스트라이크 판정을 확인한다.            | checkStrike() |
| 2  | 볼 확인     | 투수의 공(숫자)과 타자의 배트(숫자), 스트라이크 위치를 비교하여 볼 판정을 확인한다.      | checkBall() |
| 3  | 판정       | 스트라이크 판정과 볼 판정을 확인하여 스트라이크 갯수, 볼 갯수, 낫싱여부, 홈런여부를 판정한다. | judge() |

<hr/>

<h3>유틸</h3>
<h4>관련 Package: baseball/game/util</h4>
<h4>관련 Class, interface: IllegalArgumentCheck</h4>

| 번호 | 기능        | 설명                | 관련 함수            |
|:--:|:----------|:------------------|:-----------------|
| 1  | 문자열 확인    | 잘못된 문자열을 확인한다.    | checkArgument()  |
| 2  | 문자열 길이 확인 | 문자열의 길이를 확인한다.    | checkArgumentLength()  |
| 3  | 문자 확인     | 문자열의 각 문자를 확인한다.  | checkArgumentWrongChar()  |
| 4  | 잘못된 답변 확인 | 잘못된 답변(입력)을 확인한다. | checkArgumentWrongAnswer()  |

<hr/>
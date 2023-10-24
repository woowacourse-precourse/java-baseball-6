# 미션 - 숫자 야구

```mermaid
flowchart LR
    User --> App
    App --> Game
    Game --> BaseBallGame
```

메인 도메인은 `Game` 이다.<br/>
`User`는 우리의 `Application`을 통해 `Game`을 하게 된다.<br/>
`Game` 의 실제 서비스는 `BaseBallGame` 이다.<br/>

<br/>

```mermaid
flowchart LR
    BaseBallGame -- 새로운 라운드 시작 --> BaseBallStadium
    BaseBallStadium -- 새로운 라운드 결과 --> BaseBallGame
    BaseBallGame -- 게임 재시작 or 종료 유효성 검사 --> BaseBallGameExitManager
```

`BaseBallGame`

- 게임 진행을 담당한다. <br/>
- 숫자 야구 게임을 진행할 경기장에게 새로운 라운드 시작 메시지를 보낸다.<br/>

`BaseBallStadium`

- 새로운 라운드의 결과를 알려준다.<br/>

`BaseBallGameExitManager`

- 유저가 입력하는 값이 재시작인지 종료인지 판단한다.<br/>

<br/>

```mermaid
flowchart LR
    BaseBallStadium --> BaseBallTeam1
    BaseBallStadium --> BaseBallTeam2
```

`BaseBallStadium`

- 숫자 야구 게임을 매 라운드를 위해 참여하는 야구팀을 관리한다.<br/>
- 정확히 어떤 구현체가 해당 팀에 있는지 모르지만, 중간 다리 역할을 수행한다.<br/>

`BaseBallTeam1, 2`

- 게임에 참가할 팀을 추상화한 것이다.<br/>
- 수비 팀, 공격 팀으로 나뉜다.<br/>

<br/>

```mermaid
flowchart RL
    OffenseTeam --> BaseBallTeam
    User --> OffenseTeam
    UserInputValidator --> User
    DefenseTeam --> BaseBallTeam
    Computer --> DefenseTeam 
```

`OffenseTeam(User)`

- 공격 팀의 구현체이다.<br/>
- `User`가 공격 팀이 된다.<br/>
- `User`는 콘솔에 입력하는 값을 통해 번호를 생성한다.<br/>

`UserInputValidator`

- 유저가 입력하는 값의 유효성 검사를 한다.<br/>
- 유효성 검사를 통과하지 못 하면 익셉션 호출도 여기서 진행.<br/>

`DefenseTeam(Computer)`

- 수비 팀의 구현체이다.<br/>
- `Computer`가 수비 팀이 된다.<br/>
- `Computer`는 규칙에 맞게 무작위로 번호를 생성한다.<br/>

<br/>

```mermaid
flowchart LR
    BaseBallStadium -- DefenseTeam, OffenseTeam 판정 --> Referee
    Referee -- 판정 결과 --> BaseBallStadium
    Referee --> Rule
```

`Referee`

- 두 팀의 번호를 비교해 결과를 알려준다.<br/>
- `Rule`에게 판정 계산을 맡기고, 결과를 출력한다.<br/>

`Rule`

- 실제 계산을 수행한다.<br/>

<br/>
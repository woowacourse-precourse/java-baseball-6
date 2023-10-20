# 기능 요구사항 명세서

| RQ-ID  | 요구사항명 |         요구사항 내용         | 날짜 | 작성자 | 버전명 |
|--------|---------|----------------------------|-----|------|-------|
| RQ-001 | Player 입력 | Player는 서로 다른 1~9 까지의 수를 3개를 터미널을 통하여 입력 할 수 있습니다. | 10/20 | 장기환 | 0.0.1 |
| RQ-002 | Computer 정답 생성 | Computer는  서로 다른 1~9 까지의 수 3개로 이루어진 정답을 생성 할 수 있습니다. | 10/20 | 장기환 | 0.0.1 |
| RQ-003 | Referee 판정 | Referee는 Player의 질의를 받고 상태를 판단합 할 수 있습니다. | 10/20 | 장기환 | 0.0.1 |

# 클래스

```mermaid
classDiagram
    class Player{
        -int tryCount
        +query()
        +getTryCount()
    }
    class Computer{
        -int[] answer
        -boolean[] pickedMap
        -makeAnser()
        +getAnser()
        +getPickedMap()
    }
    class Referee {
        -getQueryDecoding()
        +judge()    
    }
```
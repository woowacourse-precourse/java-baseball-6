# Week1

---

# 기능 목록

1. 게임 시작 문구 출력
2. 1에서 9 사이의 서로 다른 3개 난수를 각 자릿수로 하는 숫자 생성
3. 사용자로부터 서로 다른 세 자리 수를 입력 받음
4. 사용자 입력 유효성 검사
   1. 유효하지 않은 입력을 받았다면, IllegalArgumentException 발생시키고, 프로그램 종료
5. 사용자 입력의 각 자릿수와 (2)에서 생성한 숫자의 모든 자릿수와 비교하며,
   1. 같은 수가 같은 자리에 있으면 스트라이크 개수를 증가
   2. 같은 수가 다른 자리에 있으면 볼 개수를 증가
6. 스트리이크와 볼의 값에 따라,
   1. 스트라이크가 3이라면, "3스트라이크"를 출력 후, (7)로
   2. 스트라이크와 볼이 모두 0이라면, "낫싱"을 출력 후, (3)으로
   3. 그 외에는, "{ballCount}볼 {strikeCount}스트라이크"과 같은 형식으로 투구 결과를 출력 후, (3)으로
7. 게임 종료 문구 출력
8. 시용자로부터 게임 진행 의사를 입력 받음
   1. 1: (3)으로 이동
   2. 2: 프로그램 종료

# **역할에 따른 클래스 추출**

1. ***BaseballGame*** : 볼, 스트라이크 개수 관리, 문자열 출력 등의 게임 루틴
2. ***Player*** : 사용자 입력 및 입력 데이터 관리
3. ***RandomNumber*** : 1에서 9까지 서로 다른 3개의 숫자로 구성된 난수 생성 및 사용자 입력과 비교
4. <<enum>> ***PitchingResult*** : 투구 결과를 나타내는 열거형
5. <<enum>> ***GameAction*** : 게임을 계속할 지 여부를 나타내는 열거형

# 기능 요구 변화에 대응 하기 위한 장치

1. 자릿수 변화 → 세 자리 수가 아닌 자릿수로 게임을 해야 한다면?
2. 게임 종류 후 행동 변화 → 현재는 재시작, 종료만 있지만 만약 랭킹을 보는 행위를 추가해야 한다면?
3.

---

# ***RandomNumber* 구현**

<aside>
📌 난수를 저장하는 자료구조로 정수형, 문자열, 해시테이블 세 가지를 시도한 결과 **해시테이블**로 결정

</aside>

### 1️⃣ 정수형 세 자리 난수

- 난수 생성 과정 예시
   1. 첫 번째 무작위 수

      ![Untitled](Week1%20cab8c0c4350f49aca138f40c718d4e9b/Untitled.png)

   2. 두 번째 무작위 수

      ![Untitled](Week1%20cab8c0c4350f49aca138f40c718d4e9b/Untitled%201.png)

   3. 세 번째 무작위 수

      ![Untitled](Week1%20cab8c0c4350f49aca138f40c718d4e9b/Untitled%202.png)

   4. 네 번째 무작위 수

      ![Untitled](Week1%20cab8c0c4350f49aca138f40c718d4e9b/Untitled%203.png)

- 코드

    ```java
    public String generateRandomNumber(){
            int randomNumber = 0;
    
            while (randomNumber < (int) Math.pow(10, this.digitCount - 1)){
                int randomDigit = pickNumberInRange(1, 9);
    
                if (!checkRedundancy(randomNumber, randomDigit)){
                    randomNumber = (randomNumber * 10) + randomDigit;
                }
            }
            return Integer.toString(randomNumber);
        }
    
        private boolean checkRedundancy(int randomNumber, int randomDigit){
            while (randomNumber != 0){
                if ((randomNumber % 10) == randomDigit){
                    return true;
                }
                randomNumber = randomNumber / 10;
            }
            return false;
        }
    }
    ```


### 2️⃣ 문자열 세 자리 난수

<aside>
💡 반복문으로 비교를 해야하는데 정수형보다는 문자열이 좋지 않을까?!

</aside>

- 난수 생성 과정 예시
   1. 첫 번째 무작위 수

      ![Untitled](Week1%20cab8c0c4350f49aca138f40c718d4e9b/Untitled%204.png)

   2. 두 번째 무작위 수

      ![Untitled](Week1%20cab8c0c4350f49aca138f40c718d4e9b/Untitled%205.png)

   3. 세 번째 무작위 수

      ![Untitled](Week1%20cab8c0c4350f49aca138f40c718d4e9b/Untitled%206.png)

   4. 네 번째 무작위 수

      ![Untitled](Week1%20cab8c0c4350f49aca138f40c718d4e9b/Untitled%207.png)


### 3️⃣ 해시테이블 난수

<aside>
💡 중복 제거를 해야하니 Set이나 Hash table을 써보는 건 어떨까?!

</aside>

- 난수 생성 과정 예시
   1. 첫 번째 무작위 수

      ![Untitled](Week1%20cab8c0c4350f49aca138f40c718d4e9b/Untitled%208.png)

   2. 두 번째 무작위 수

      ![Untitled](Week1%20cab8c0c4350f49aca138f40c718d4e9b/Untitled%209.png)

   3. 세 번째 무작위 수

      ![Untitled](Week1%20cab8c0c4350f49aca138f40c718d4e9b/Untitled%2010.png)

   4. 네 번째 무작위 수

      ![Untitled](Week1%20cab8c0c4350f49aca138f40c718d4e9b/Untitled%2011.png)


**해시테이블을 선택한 이유**

1. 난수 생성 시, 반복문 같은 루틴 없이 중복 체크
2. 플레이어가 입력한 숫자와 난수를 비교할 때 이중 반복문을 사용하지 않아도 된다
   - Pseudo Code

       ```java
       for i = first index of input to last index of input:
           if input[i] in keys of hashTable:
               if hashTable(input[i]) == i:
                   strike++;
               else:
                   ball++;
       ```

   - 예시
      1. strike

         ![Untitled](Week1%20cab8c0c4350f49aca138f40c718d4e9b/Untitled%2012.png)

      2. ball

         ![Untitled](Week1%20cab8c0c4350f49aca138f40c718d4e9b/Untitled%2013.png)

      3. Neither

         ![Untitled](Week1%20cab8c0c4350f49aca138f40c718d4e9b/Untitled%2014.png)


생성된 난수를 전달할 때, 해시테이블을 반환할 수도 있지만,

다른 요구사항이 추가되어 난수를 다른 자료구조로 바꾸게 되면, 전달 받는 측의 처리 로직도 바뀌어야 한다.

또한, 생성된 난수의 쓰임은 사용자 입력이 ball, strike, 또는 둘 다 아닌지를 파악하는 것 뿐이다.

그러므로, ***RandomNumber*** 클래스에서 해당 로직을 처리해 결과를 처리해주는게 바람직하다고 생각했다.

이에, PitchingResult 열거형 클래스를 만들고, 사용자 입력의 각 자릿수를 입력으로 받아,

ball, strike, 또는 nothing을 반환해주는 method를 구현했다.

# *Player* **구현**

<aside>
📌 플레이어의 행동은 두 가지 ‘**중첩되지 않은 세 자리 숫자 입력**’

또는 ‘**재시작과 종료 제어 숫자 입력**’ 이다.

</aside>

## 중첩되지 않은 세 자리 숫자 입력

1. 사용자 입력인 세 자리 숫자를 저장할 공간으로 ***ArrayList<Integer>*** 생성

   → 데이터 중간에 삽입이 예상되지 않고, 반복문을 순회하기 좋은 자료구조

2. 사용자로부터 입력 받은 문자열의 크기가 요구하는 자릿수(3)가 맞는지 확인
3. 문자열의 각 문자가 ‘1’에서 ‘9’ 사이인지 확인
4. (2)에서 확인한 문자를 정수형으로 바꾸고 중복이 없다면 (1)에서 생성한 ArrayList에 추가

> 2 ~ 4의 유효성 검사가 실패 시 요구사항에 명시된 대로
>
>
> ***IllegalArgumentException***을 발생시키고 프로그램 종료
>

설계 초기에는 사용자 입력 전달하기 위해 ***ArrayList<Integer>***를 반환.

그러나, 요구사항이 바뀌어 ***ArrayList***가 아닌 ******다른 자료구조로 변경될 수도 있다고 가정.

이러한 구현 변경이 다른 클래스에도 전달될 수 있다고 판단해,

두 개의 getter( ***getInputCount***, *******getNumberAt*** )를 두어 사용자 입력에 접근할 수 있도록 설계.

## 재시작과 종료 제어 숫자 입력

1. 사용자로부터 입력 받은 문자열의 길이가 1인지 확인

   → 1이 아니라면 ***IllegalArgumentException***을 발생시키고 프로그램 종료

2. 입력이 1이라면 ***GameAcion.CONTINUE***을 반환
3. 입력이 2라면 ***GameAcion.QUIT***을 반환
4. (2), (3)의 경우가 아니라면 ***IllegalArgumentException***을 발생시키고 프로그램 종료

제어 종류가 ‘계속 하기’와 ‘게임 종료’ 두 가지이므로 ***boolean***을 반환하는 방식으로 구현할 수도 있으나,

차후에 ‘기록 보기’와 같은 제어가 추가된다면 해당 method의 반환 형식 뿐 아니라,

method를 사용하는 측의 처리 로직도 변경되어야 한다.

이러한 변경의 전파를 최소화하고자 ***GameAction*** 열거형 클래스를 만들어 완충제로 두었다.

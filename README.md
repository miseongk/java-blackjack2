# java-blackjack

블랙잭 미션 저장소

# 요구사항 분석
## 주요 객체의 속성, 역할

### BettingMoney
- [x] 배팅 금액은 0 이상이다.
- [x] 배팅 금액의 1.5배를 받는다.
- [x] 배팅 금액만큼 받는다.

### Participants
- [x] `Dealer`와 `Players`를 가진다.
- [x] 카드를 받는다.

### Participant
- [x] `Cards`를 가진다.
- [x] `Card`를 받는다.
- [x] 총 점수를 계산한다.
- [x] 버스트인지 확인한다.

### Dealer
- [x] `Participant`를 가진다.
- [x] 초기 카드를 한 장만 보여준다.
- [x] 카드를 더 뽑을지 결정한다.

### Player
- [x] 이름을 가진다.
  - [x] 이름의 길이는 최소 1글자에서 최대 5글자이다.
- [x] `Participant`를 가진다.
- [x] 초기 카드를 두 장 모두 보여준다.
- [x] 카드를 더 뽑을지 결정한다.
- [x] `BettingMoney`를 가진다.
- [ ] 초기 카드가 블랙잭이면 배팅 금액의 1.5배를 받는다.
  - [ ] 딜러와 동시에 블랙잭이면 배팅 금액만큼 받는다.
- [ ] 딜러가 버스트이면 배팅 금액만큼 받는다. 

### Players
- [x] `Player`들을 가진다.
- [x] 입력된 이름을 가지고 `Players`를 만들어 반환한다.
  - [x] 최소 2명에서 최대 8명의 `Players`를 생성한다.

### Result (Enum)
- [x] 결과를 가진다. (승, 무, 패)

### GameResult
- [x] 플레이어 결과를 계산한다.
- [x] 플레이어 결과를 뒤집어서 반환한다.
- [x] 딜러 결과(승, 무, 패)를 카운트해서 반환한다.

### Card
- [x] `Number`와 `Pattern`을 가진다.
- [x] 카드가 ACE인 지 확인한다.
- [x] 카드 정보를 보여준다.

### Cards
- [x] `Card`들을 가진다.
- [x] 가지고 있는 `Card`로 총점을 계산한다.
- [x] ACE 카드를 갖고 있는지 확인한다.
- [x] 가지고 있는 카드가 버스트인지 확인한다.
- [x] 가지고 있는 카드가 블랙잭인지 확인한다.
- [x] 카드를 추가한다.

### Score
- [x] ACE를 11로 계산한다.
- [x] 점수가 버스트인지 확인한다.
- [x] 점수가 블랙잭인지 확인한다.
- [x] 점수를 비교한다.
  - [x] 현재 점수보다 작거나 같은지 확인한다.
  - [x] 현재 점수보다 작은지 확인한다.
  - [x] 현재 점수와 같은지 확인한다. 

### Deck
- [x] 게임에서 뽑히지 않은 랜덤한 카드를 뽑아준다.
- [x] 뽑힌 카드를 가진다.

### Number (Enum)
- [x] 숫자를 가진다. (A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K)
- [x] 숫자를 점수로 변환해준다.

### Pattern (Enum)
- [x] 문양을 가진다. (하트, 스페이드, 클로버, 다이아몬드)
  - [x] 문양에 맞는 이름을 가진다.

## 입출력 요구사항
### 입력 요구사항
- [x] 참가자의 이름을 입력받는다. (','로 구분짓는다.)
  - [x] 공백을 입력했는지 검증한다.
- [x] 카드를 더 받을지 입력받는다.
  - [x] 'y' 또는 'n' 을 입력했는지 검증한다.
- [x] 배팅 금액을 입력받는다.
  - [x] 정수를 입력했는지 검증한다.
  - [x] 공백을 입력했는지 검증한다.

### 출력 요구사항
- [x] 딜러와 참가자들에게 나누어준 카드를 출력한다.
  - [x] 딜러는 한 장의 카드만 출력한다.
- [x] 참가자의 현재 가진 카드들을 출력한다.
- [x] 딜러의 점수가 16점 이하인 경우, 딜러가 한 장의 카드를 더 받았다고 출력한다.
- [x] 참가자와 딜러가 가진 카드들을 모두 출력하고, 총점도 같이 출력한다.
- [ ] 최종 수익을 출력한다. 
- ~~- 최종 승패를 출력한다.~~

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)


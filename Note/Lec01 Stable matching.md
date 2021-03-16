# Lec01: Stable matching

Goal: a self-reinforcing matching process

*Stable assignment*: Individual self-interest will prevent any applicant/target deal from
being made. 大家都对自己的结果很满意就是最好的情况。

monogamously adv. 一夫一妻制地

*Stable matching*: perfect matching with no unstable pairs.

- *Perfect matching*: everyone is matched monogamously. 每个人都有唯一的伴侣。
- *Unstable pairs*: In a matching M, an unmatched pair m-w is *unstable* if man m and woman w prefer each other to current partners. 有两个人没被匹配在一块却愿意私奔。

Stable matching may not exist and may not be unique if existing. 稳定匹配不总存在，存在时不总是唯一的。

### Propose-and-reject algorithm (Gale-Shapley algorithm)

#### Process

```pseudocode
INITIALIZE S to empty matching.
WHILE (a man m1 is unmatched and hasn't proposed to every woman):
	w ← 1st woman not proposed in m1's list;
	IF (w is unmatched):
		Add pair m1-w to S;
	ELSE IF (w prefers m to her current partner m2):
		Remove pair m2-w from S;
		Add pair m1-w to S;
	ELSE:
		w rejects m1;
```

通俗的解释就是，每个循环挑一个还没有配对并且没有向所有异性求婚的男人，按他的喜好依次求婚；每次男人求婚，被求婚的女人如果是单身则配对成功并continue，如果有对象但更喜欢这个男人则出轨并continue，如果有对象且不喜欢这个男的则男的配对失败（然后男的继续找备胎）。最多产生n²次循环，n是男人的数量。

#### Proof

- for complexity O(n^2): Each time a man proposes to a woman. There are n men and n women so there are at most n^2 proposal.

- for correctness -- all men and women would get matched: If there is one man left then there is one woman left, so the woman is never proposed, but the man must have proposed to every woman -> contradiction.

- for stability: assuming M-W is an unstable pair.
  - Case 1: M never proposed to W -> M must prefer his current partner to W;
  - Case 2: W rejected M -> W prefers her current partner to M;
  - -> contradiction
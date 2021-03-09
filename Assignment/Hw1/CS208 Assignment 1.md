# CS208 Assignment 1

> Author: 王超逸 Chaoyi WANG
>
> SID: 11811014
>
> Content: Answers of q1, q2, q3 and q8 of chapter 1 of the textbook.



### 1.1

Q: Decide whether you think the following statement is true or false. If it is
true, give a short explanation. If it is false, give a counterexample.

> True or false? In every instance of the Stable Matching Problem, there is a
> stable matching containing a pair (m, w) such that m is ranked first on the
> preference list of w and w is ranked first on the preference list of m.

A: False. 

Counterexample: consider two men and two women with their preference lists as below:

| Name | #1   | #2   |
| ---- | ---- | ---- |
| m1   | w1   | w2   |
| m2   | w2   | w1   |
| w1   | m2   | m1   |
| w2   | m1   | m2   |

In this case, no matter which man we begin the matching from, the matching result would be S = {m1-w1, m2-w2}, while w1 prefers m2 and w2 prefers m1.

The question asked whether a pair of people who like each other best would match. We can simply give counterexamples by make such pairs not exist at all (and that is life).



### 1.2

Q: Decide whether you think the following statement is true or false. If it is
true, give a short explanation. If it is false, give a counterexample.

> True or false? Consider an instance of the Stable Matching Problem in which
> there exists a man m and a woman w such that m is ranked first on the
> preference list of w and w is ranked first on the preference list of m. Then in
> every stable matching S for this instance, the pair (m, w) belongs to S.

A: True.

Explanation: We prove this conclusion by contradiction, assuming that such a pair (m, w) exists but they would not match finally. Therefore, m and w would be involved in two match (m, w') and (m', w) for certain. Since we know that m and w like each other best, the result is **unstable**, which is opposite to our assumption that all matches are stable. Thus, if such pairs like (m, w) exist, they would be a match in any stable matching case. Love will find out the way.



### 1.3 

Q:  There are many other settings in which we can ask questions related
to some type of “stability” principle. Here’s one, involving competition
between two enterprises.

​	Suppose we have two television networks, whom we’ll call A and B. There are n prime-time programming slots, and each network has n TV shows. Each network wants to devise a schedule—an assignment of each show to a distinct slot—so as to attract as much market share as possible.

​	Here is the way we determine how well the two networks perform relative to each other, given their schedules. Each show has a fixed rating, which is based on the number of people who watched it last year; we’ll assume that no two shows have exactly the same rating. A network wins a given time slot if the show that it schedules for the time slot has a larger rating than the show the other network schedules for that time slot. The goal of each network is to win as many time slots as possible. 

​	Suppose in the opening week of the fall season, Network A reveals a schedule S and Network B reveals a schedule T. On the basis of this pair of schedules, each network wins certain time slots, according to the rule above. We’ll say that the pair of schedules (S, T) is stable if neither network can unilaterally change its own schedule and win more time slots. That is, there is no schedule S such that Network A wins more slots with the pair (S, T) than it did with the pair (S, T); and symmetrically, there is no schedule T such that Network B wins more slots with the pair (S, T) than it did with the pair (S, T).

​	The analogue of Gale and Shapley’s question for this kind of stability
is the following: For every set of TV shows and ratings, is there always
a stable pair of schedules? Resolve this question by doing one of the
following two things:

​	(a) give an algorithm that, for any set of TV shows and associated ratings, produces a stable pair of schedules; or

​	(b) give an example of a set of TV shows and associated ratings for
which there is no stable pair of schedules.

A: I would answer this question by doing (b) because there is not always a stable pair of schedules.

​	Let n = 2, A has two shows, A1 and A2, with their corresponding rating a1 and a2. Also, B has B1 with b1 and B2 with b2. There are only two cases for their comparison:

​	Case 1: a1 > a2 > b1 > b2; Case 2: a1 > b1 > a2 > b2.

​	For case 2, there are only two situations for the schedule (S, T) which are (a1-b1, a2-b2) and (a1-b2, a2-b1). If the final schedule were (a1-b1, a2-b2), A would switch its two slots and make the schedule be (a1-b2, a2-b1) to win one more slot. If, in the contrary, the final schedule turned out to be (a1-b2, a2-b1), B would also switch the slots to take one wining back.

​	When n >= 2, for the same reason, if we can find two programs from A and two programs from B to form a 'a1 > b1 > a2 > b2', the schedule would never be stable.

​	To make the conclusion less abstract, I would take Tianji’s horse racing strategy (田忌赛马) as an example. In that story, by changing the order of the racing horse, Tianji managed to beat the king. However, if the king was able to see the pairing and adjust the order before the race, he would also change the order and win.



### 1.8

Q: For this problem, we will explore the issue of truthfulness in the Stable Matching Problem and specifically in the Gale-Shapley algorithm. The basic question is: Can a man or a woman end up better off by lying about his or her preferences? More concretely, we suppose each participant has a true preference order. Now consider a woman w. Suppose w prefers man m to m', but both m and m' are low on her list of preferences. Can it be the case that by switching the order of m and m' on her list of preferences (i.e., by falsely claiming that she prefers m' to m) and running the algorithm with this false preference list, w will end up with a man m'' that she truly prefers to both m and m'? (We can ask the same question for men, but will focus on the case of women for purposes of this question.) Resolve this question by doing one of the following two things:

​	(a) Give a proof that, for any set of preference lists, switching the order of a pair on the list cannot improve a woman’s partner in the Gale-Shapley algorithm; or

​	(b) Give an example of a set of preference lists for which there is a switch that would improve the partner of a woman who switched preferences

A: I am going to answer the question by doing (b). A counterexample is like below:

True table:

| Man  | #1   | #2   | #3   |
| ---- | ---- | ---- | ---- |
| m1   | w3   | w1   | w2   |
| m2   | w1   | w3   | w2   |
| m3   | w3   | w1   | w2   |

| Woman | #1   | #2   | #3   |
| ----- | ---- | ---- | ---- |
| w1    | m1   | m2   | m3   |
| w2    | m1   | m2   | m3   |
| w3    | m2   | m1   | m3   |

Concealed table:

| Woman | #1   | #2     | #3     |
| ----- | ---- | ------ | ------ |
| w1    | m1   | m2     | m3     |
| w2    | m1   | m2     | m3     |
| w3    | m2   | **m3** | **m1** |

Men begin choosing from m1.

In this case, when w3 is honest on her preference list, she would be with m1. However, if she concealed her list as the table showed, she would be with m2. The idea is she yield m1 to w1 by concealing her preference.
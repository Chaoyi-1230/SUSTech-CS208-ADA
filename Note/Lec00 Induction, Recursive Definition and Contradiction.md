# Lec00: Induction, Recursive Definition and Contradiction

### Induction 

数学归纳法

- Claim 重申命题、声明要证明的内容
- Base 基础情况，例如计算foo(1)
- Induction 归纳，如果知道foo(n)成立，试图归纳foo(n+1)

Domino Theory (intuitively) 用多米诺骨牌的原理来感性证明归纳法

### Recursive Definition

递归定义

- Base case(s) 基本情况，比如斐波那契数列的前两项
- Recursive formula 递推公式

#### Finding closed forms

闭型：对任一自变量，都可以代入解析函数求得正确的因变量

Techniques for finding closed forms:

- unrolling 循环展开
- induction

### Proof by Contradiction

反证法

Showing ¬P is false to indicate P is true.

Example: proving 2^(1/2) is irrational (let it be a/b where a is prime to b...)
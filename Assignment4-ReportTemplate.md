**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:       |   |
|-----------------|---|
| Student Names:  |   |
|                 |   |
|                 |   |
|                 |   |

# Introduction


# Analysis of 10 Mutants of the Range class 

| Line | Mutation                                                                    | Initial   | New     | Code                                                                      |
| ---- | --------------------------------------------------------------------------- | --------- | ------- | ------------------------------------------------------------------------- |
| 91   | 3\. <init> : Negated double local variable number 1                         |  SURVIVED |  KILLED |             String msg = "Range(double, double): require lower (" + lower |
| 91   | 4\. <init> : Incremented (a++) double local variable number 1               |  SURVIVED |  KILLED |             String msg = "Range(double, double): require lower (" + lower |
| 91   | 5\. <init> : Decremented (a--) double local variable number 1               |  SURVIVED |  KILLED |             String msg = "Range(double, double): require lower (" + lower |
| 91   | 6\. <init> : Incremented (++a) double local variable number 1               |  SURVIVED |  KILLED |             String msg = "Range(double, double): require lower (" + lower |
| 91   | 7\. <init> : Decremented (--a) double local variable number 1               |  SURVIVED |  KILLED |             String msg = "Range(double, double): require lower (" + lower |
| 92   | 3\. <init> : replaced call to java/lang/StringBuilder::append with receiver |  SURVIVED |  KILLED |                 + ") <= upper (" + upper + ").";                          |
| 92   | 4\. <init> : Negated double local variable number 3                         |  SURVIVED |  KILLED |                 + ") <= upper (" + upper + ").";                          |
| 92   | 5\. <init> : Incremented (a++) double local variable number 3               |  SURVIVED |  KILLED |                 + ") <= upper (" + upper + ").";                          |
| 92   | 6\. <init> : Decremented (a--) double local variable number 3               |  SURVIVED |  KILLED |                 + ") <= upper (" + upper + ").";                          |
| 92   | 7\. <init> : Incremented (++a) double local variable number 3               |  SURVIVED |  KILLED |                 + ") <= upper (" + upper + ").";                          |
| 92   | 8\. <init> : Decremented (--a) double local variable number 3               |  SURVIVED |  KILLED |                 + ") <= upper (" + upper + ").";                          |
| 132  | 5\. getCentralValue : Decremented (a--) double field lower                  |  SURVIVED |  KILLED |         return this.lower / 2.0 + this.upper / 2.0;                       |
| 132  | 6\. getCentralValue : Decremented (a--) double field upper                  |  SURVIVED |  KILLED |         return this.lower / 2.0 + this.upper / 2.0;                       |
| 165  | 3\. intersects : Incremented (a++) double field lower                       |  SURVIVED |  KILLED |         if (b0 <= this.lower) {                                           |
| 165  | 4\. intersects : Incremented (++a) double field lower                       |  SURVIVED |  KILLED |         if (b0 <= this.lower) {                                           |
| 166  | 9\. intersects : Incremented (++a) double field lower                       |  SURVIVED |  KILLED |             return (b1 > this.lower);                                     |
| 166  | 10\. intersects : Decremented (--a) double local variable number 3          |  SURVIVED |  KILLED |             return (b1 > this.lower);                                     |
  
# Report all the statistics and the mutation score for each test class

### DataUtilitiesTest
Initial Mutation Score

![image](https://user-images.githubusercontent.com/48339672/158462349-e56d9df1-becf-40b7-8d6e-d75e6f537ab8.png)

Updated Mutation Score

![image](https://user-images.githubusercontent.com/48339672/158471901-46e880e0-a083-4112-86ba-0623632f8892.png)

Mutations at [DataUtilities Results](https://github.com/seng438-winter-2022/seng438-a4-bjaron/blob/Angeloo01-mutation-testing/PitestResultDataUtilitites.csv)

### RangeTest

Initial Mutation Score

![image](https://user-images.githubusercontent.com/48339672/158476820-e2482157-84d3-4f37-b6a7-964cc0d675ea.png)

Updated Mutation Score

![image](https://user-images.githubusercontent.com/48339672/158483914-49a58453-aae7-4aec-8cd7-0801bf208d81.png)

Mutations at [RangeTest results](https://github.com/seng438-winter-2022/seng438-a4-bjaron/blob/Angeloo01-mutation-testing/PitestResultRange.csv)


# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

Example Equivalent Mutants for Range (getLength() Method)

12. Incremented (a++) double field upper → SURVIVED
13. Incremented (a++) double field lower → SURVIVED
14. Decremented (a--) double field upper → SURVIVED
15. Decremented (a--) double field lower → SURVIVED

These Mutants are never accessed since the values are used and returned before the increment/decrement are applied.
  
Equivalent mutants reduce the mutation score of the tests because the tool counts these tests as SURVIVED mutations even though they do not affect the behaviour of the SUT. Thus, equivalent tests reduce the accuracy of the tests' mutation scores because they reduce the scores even though the SUT behaves the same and as required.
  
Equivalent mutations can be detected by determining possible code paths. Additionally, from our tests, it is apparent that equivalent mutations occur most commonly when a variable is used in a condition or as a return value and the mutation is a post increment/decrement.
  
# A discussion of what could have been done to improve the mutation score of the test suites
  
To increase the mutation score of the test suites, we can remove equivalent mutations, increase code coverage, and create new test cases to kill the remaining surviving mutants.
  
Our strategy for designing our test cases for mutation testing is as follows:
<ol>
  <li>Run pitest on our current test suite</li>
  <li>Measure and analyze mutation score</li>
  <li>Review mutations and determine which suriving mutations can be killed</li>
  <li>Design new tests and run pitest</li>
  <li>Repeat if criteria has not been met</li>
</ol>

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself

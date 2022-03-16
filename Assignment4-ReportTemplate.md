**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:       |   |
|-----------------|---|
| Student Names:  | Angelo Gonzales  |
|                 | Jaron Baldazo |
|                 | Manjot Singh  |
|                 | Dave Sharma  |

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
Mutation testing tests the strength of the test cases themseleves rather than the SUT. The mutation testing is a form of white-boxing testing that allows the test creators to test whether the test suite iteself will detect changes to the original SUT. Mutants are injected into the SUT to determine whether the test cases will pass or fail. Test cases that survive the mutation are weaker tests as they do not differ from the desired output when mutants are injected in the original SUT. Mutation testing is advantageous in determining the strength of the test cases, and whether the tests themselves are strong. The disadvantages of using mutation testing is that it can take a long time to create the mutations if created manually, or if using a automated testing mechanism like Pitest, the creation and execution of the mutation tests can take time, and have high CPU usage.
  
# Explain your SELENUIM test case design process
The GUI testings using Selenium was done through exploratory testing and black box testing on the website sportchek.ca. Some functionalities that were tested includes the search function and viewing the cart. Our test case design process consisted of individual group members going through the site and finding important functionalities that should be tested. Since Selenium captures and replays user actions through the execution of scripts, a semi-automated approach was used. After finding a functionality that we want to test, we use the Selenium record feature to record our actions while asserting/verifying components of the page. We then run the test through the script which allows us to see if the asserts/verify passes.

# Explain the use of assertions and checkpoints
Assertions were used in the Selenium web testing in order to determine whether the element values were the same, or present when you capture and playback occured. Assertions verified the veracity of the playback from the website to ensure that the correct values, text elements, and titles were present. We used assertions to for the correct text element to be present in the playback when capturing the steps in the web-driver. An example of the use of assertions was in while navigating the website, we used assertions to determine the presence of a text element. Checkpoints were used to break while walking through the tests after capturing the steps in the web driver. During the playback the checkpoints were used to stop the playback and ensure the assertions were correctly tested.
  
# how did you test each functionaity with different test data
Each group member had to handle two different functionalities, each following through different steps in order to gather the test data on the specific functionalities. When creating the test data for each functionality, wherever there was editable fields, we tested different inputs in order to make sure the functionality worked as intended.
 
# Discuss advantages and disadvantages of Selenium vs. Sikulix
A main advantage that Selenium has over Sikulix is the ease of use on web browsers. This is because Selenium can be downloaded as a chrome extension rather than downloading a jar file which contains the Sikulix IDE. A disadvantage that Selenium has is that it only works on web browsers whereas Sikulix can run tests on GUI applications. 

# How the team work/effort was divided and managed
Team work was divided equally, as all team members worked together one each part of the lab. Each member of the team went through the familirization of mutation testing, and were responsible on checking the coverage of the tests. For the Selenium and Siklux testing, each group member created two tests for each, testing the functionality of the sportchek website. Finally, the lab report writeup, was split equally between members. hroughout the lab, each member was responsible for keeping each other accountable, and make sure that the work was done in time.
  
# Difficulties encountered, challenges overcome, and lessons learned
The main lessons that our group leaned throughout this assignment was the usage of mutation and GUI testingg. In this assignment, we were introduced with testing tools such as Pitest, Selenium and Siklux to further improve our understanding with the different forms of testing. 

A difficulty that we encountered was the usage of Pitest, as two members of our group did not manage to get the pitest running due to errors with JDK versions. This led us to use the test results from the other members while the rest of the team worked on unit tests together. When using Selenium and Siklux for the first time, a learning process was undertaken in order to get used to the tools.
  
# Comments/feedback on the lab itself
This assignment was helpful in familiarizing ourselves with mutation and user interface testing through the use of Pitest, Selenium, and Siklux. The handout was easy to follow allowing us to understand the usefulness of mutation and GUI testing.

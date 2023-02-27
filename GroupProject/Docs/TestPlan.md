# Test Plan

**Author**: Team 074

## 1 Testing Strategy

### 1.1 Overall strategy

Our test plan utilizes unit, integration, system, and manual strategies to cover testing across multiple granularity levels. We will unit test our two classes, ComparisonSettings and Job. Unit tests for ComparisonSettings will test the validity of the class attributes and the correctness of the logic used in the setWeight() method. Our testing will include cases in which the user is assigning weights for the first time, and the user is modifying existing weights. Separately, the attributes of the Job class will be tested (for example, checking for an empty input in the job title.) Our Job unit tests will also test the calculation methods of the Job class to verify that scores, adjusted salaries, and adjusted bonuses are correctly calculated. Lastly, we will test for cases in which the user is entering a new job offer, or modifying the details of a current job. Any external dependencies will be mocked for the unit tests.
Our integration testing will further increase our test coverage, and we expect the number of integration tests to be materially smaller than the number of unit tests. Our integration tests will test the interactions between our own classes (ComparisonSettings and Job) and any external modules or dependencies. Of note, at this point in development, we have not yet determined which dependencies will be used. Based on our current design, we anticipate that integration tests will be necessary to test certain app functionality, such as comparing two jobs. We also anticipate that a database may be necessary to implement our design, and our integration tests will include any CRUD operations needed for the database.
After we have completed our unit and integration testing, we will proceed with system testing. Test cases will reflect user behavior and will encompass both functional and non-functional testing. Margaret will handle the bulk of the integration and system testing, with each developer writing their own unit tests.

### 1.2 Test Selection

Our test cases will be driven by the defined business requirements. We will use white-box testing in the unit and integration testing phases. The white-box testing will be focused on branch and condition coverage. Black-box testing techniques (such as partitioning, decision table testing, and graph-based testing) will be used at the integration, system, and regression levels.

### 1.3 Adequacy Criterion

The quality of our white-box testing will be measured by metrics including branch coverage and condition coverage. We will assess our code coverage to identify any gaps in testing, and the results of our code coverage will help determine if additional unit tests need to be written. We will assess the quality of our black-box testing by revisiting the business requirements and evaluating what percentage of the requirements have been covered. We will use different testing techniques and compare the results of each to verify that our system is working as intended.

### 1.4 Bug Tracking

We will use GitHub’s issues feature to track bugs and enhancement requests.

### 1.5 Technology

We will use the Espresso framework for UI and integration testing. We will use JUnit and Mockito (as needed) for writing unit tests. We may also perform manual testing to support these efforts.


## 2 Test Cases

| Purpose                                                               | Steps                                                                                                                                                                 | Expected Result           | Actual Result | P/F Information | Notes                                                                                  |
|-----------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------|---------------|-----------------|----------------------------------------------------------------------------------------|
| Test individual functionality of Job class with JUnit.                | Compile all Job-related test class files (i.e., javac UnitTest1.java TestSuite.java TestRunner.java). Run the TestRunner class (i.e., java TestRunner)                | All test cases will pass. | TBD           | TBD             | The tests comprising the automated test suite will be specified in D3 of this project. |
| Test individual functionality of comparisonSettings class with JUnit. | Compile all comparisonSettings-related test class files (i.e., javac UnitTest1.java TestSuite.java TestRunner.java). Run the TestRunner class (i.e., java TestRunner) | All test cases will pass. | TBD           | TBD             | The tests comprising the automated test suite will be specified in D3 of this project. |
| Test UI functionality with Espresso.                                  | Run a local unit test (i.e., ./gradlew test). Run an instrumented test (i.e., ./gradlew connectedAndroidTest)                                                         | All test cases will pass. | TBD           | TBD             | The tests comprising the automated test suite will be specified in D3 of this project. |
| Test the enter job details function.                                  | Run an instrumented test (i.e., ./gradlew connectedAndroidTest)                                                                                                       | All test cases will pass. | TBD           | TBD             | The tests comprising the automated test suite will be specified in D3 of this project. |
| Test the edit details of the current job function.                    | Run an instrumented test (i.e., ./gradlew connectedAndroidTest)                                                                                                       | All test cases will pass. | TBD           | TBD             | The tests comprising the automated test suite will be specified in D3 of this project. |
| Test the enter job offer details function.                            | Run an instrumented test (i.e., ./gradlew connectedAndroidTest)                                                                                                       | All test cases will pass. | TBD           | TBD             | The tests comprising the automated test suite will be specified in D3 of this project. |
| Test the adjust comparison settings function.                         | Run an instrumented test (i.e., ./gradlew connectedAndroidTest)                                                                                                       | All test cases will pass. | TBD           | TBD             | The tests comprising the automated test suite will be specified in D3 of this project. |
| Test the compare job offers function.                                 | Run an instrumented test (i.e., ./gradlew connectedAndroidTest)                                                                                                       | All test cases will pass. | TBD           | TBD             | The tests comprising the automated test suite will be specified in D3 of this project. |
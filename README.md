# YandexMarketTesting
**Note**: 
---
This case doesn't support on the latest Google Chrome version 74 by reason: https://twitter.com/jselenide/status/1105734134633127938/

You must use Google Chrome version not more newer than 73. If you use 74 version, you need to do next steps:  https://twitter.com/Anton94569401/status/1105807763043692547 

**Desciption**:
---
This test suite get a number of models from brends as: Apple, Lenovo, Xiaomi with processors Core i7 and Core i5.

**How to use**:
---
Run RunnerTest.class and to check a result in the Result.txt file that should be created in root folder. 

**Architecture**:
---
The test architecture consists of **two main part**:

**I**. /src/test/java/YandexMarket <- there is contains test scenario(features), definition of steps, runner and hooks.

**II**. /src/main/java/YandexMarket/pageobjects/ <- there is contains pageobjects classes.

**I part** has 3 folders:

features <- there is contains test scenario.

runner < - there is contains configuration for run test cases.

steps <- there is contains test steps and hooks.

**II part** consists of next typical classes and intarfaces:

NameOfElement <- custom annotation of web elemets;

AbstractPage <- class there is nameOfElements definited. This class is inherited by classes which describe web elements.

And several classes with definition web elements for each web page which are using in the test.


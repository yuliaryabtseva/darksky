$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("darksky.feature");
formatter.feature({
  "line": 2,
  "name": "Darksky Feature",
  "description": "",
  "id": "darksky-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 1,
      "name": "@darksky"
    }
  ]
});
formatter.before({
  "duration": 3293476401,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Verify Credit Card section",
  "description": "",
  "id": "darksky-feature;verify-credit-card-section",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 20,
      "name": "@darksky-4"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "I am on Darksky home page",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "I sign up in Darksky API",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "I verify my account by clicking on the link in Gmail account",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "I go to Account Setting in Darksky Account",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkskyHomePageSD.iAmOnDarkskyHomePage()"
});
formatter.result({
  "duration": 337472759,
  "status": "passed"
});
formatter.match({
  "location": "DarkskyHomePageSD.signUpInDarkskyApi()"
});
formatter.result({
  "duration": 1799844746,
  "status": "passed"
});
formatter.match({
  "location": "GmailPageSD.verifyDarkskyRegistration()"
});
formatter.result({
  "duration": 10016735115,
  "status": "passed"
});
formatter.match({
  "location": "DarkskyApiPageSD.goToAccountSettings()"
});
formatter.result({
  "duration": 2919318983,
  "status": "passed"
});
});
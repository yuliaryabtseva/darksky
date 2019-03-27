@regression @messenger
Feature: Messenger Feature

  Background:
    Given I am on home page

  @messenger-1
  Scenario: Verify invalid login message on signup page
    Given I am on messenger facebook
    When I enter  mohammad@technosoft.io into username field on messenger page
    And I enter  test1234 into password field on messenger page
    And I click on sign in button on messenger page
    Then I verify invalid login message on signup page
@regression @darksky
Feature: Darksky Feature

  @darksky-1
  Scenario: Verify timeline is displayed in correct format
    Given I am on Darksky home page
    Then I verify timeline is displayed with two hours incremented

  @darksky-2
  Scenario: Verify individual day temp timeline
    Given I am on Darksky home page
    When I expand todays timeline
    Then I verify lowest and highest temp is displayed correctly

  @darksky-3
  Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
    Given I am on Darksky home page
    Then I verify current temp is not greater or less then temps from daily timeline

  @darksky-4
  Scenario: Verify Credit Card section
    Given I am on Darksky home page
    When I sign up in Darksky API
    And I verify my account by clicking on the link in Gmail account
    Then I go to Account Setting in Darksky Account








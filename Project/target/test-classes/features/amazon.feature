@regression @amazon
Feature: Amazon Feature

  Background:
    Given I am on Amazon home page

  @amazon-1
  Scenario: Verify I can't create an account if name is not entered
    Given I am on Create Account page
    When I enter  mohammad@technosoft.io into email field on amazon register page
    And I enter  test1234 into password field on amazon register page
    And I enter test1234 into re-enter password field on amazon register page
    And I click on Create your Amazon account button on amazon register page
    Then I verify "Enter your name" error on amazon register page

  @amazon-2
  Scenario: Verify I can't create an account if email is not entered
    Given I am on Create Account page
    When I enter  Yulia into name field on amazon register page
    And I enter  test1234 into password field on amazon register page
    And I enter test1234 into re-enter password field on amazon register page
    And I click on Create your Amazon account button on amazon register page
    Then I verify "Enter your email" error on amazon register page

  @amazon-3
  Scenario: Verify I can't create an account if entered email is not an email
    Given I am on Create Account page
    When I enter  Yulia into name field on amazon register page
    And I enter thisIsMyEmail into email field on amazon register page
    And I enter  test1234 into password field on amazon register page
    And I enter test1234 into re-enter password field on amazon register page
    And I click on Create your Amazon account button on amazon register page
    Then I verify "Enter a valid email address" error on amazon register page

  @amazon-4
  Scenario: Verify I can't create an account if passwords don't match
    Given I am on Create Account page
    When I enter  Yulia into name field on amazon register page
    And I enter test@technosoft.io into email field on amazon register page
    And I enter  test1234 into password field on amazon register page
    And I enter test into re-enter password field on amazon register page
    And I click on Create your Amazon account button on amazon register page
    Then I verify "Passwords must match" error on amazon register page

  @amazon-5
  Scenario: Verify I can't create an account if password is less than 6 characters
    Given I am on Create Account page
    When I enter  Yulia into name field on amazon register page
    And I enter test@technosoft.io into email field on amazon register page
    And I enter  12345 into password field on amazon register page
    And I enter 12345 into re-enter password field on amazon register page
    And I click on Create your Amazon account button on amazon register page
    Then I verify "Passwords must be at least 6 characters." error on amazon register page

Feature: As a user I want to be able to sign in or see an error if something went wrong. After sign in my account (need to re-check) page is seen.
   @Signin01
  Scenario: I sign in with valid sighin details
    Given I am on homepage
    And I navigate to "sign in page"
    When I type valid e-mail and password in correct fields
    And I click "sign in button"
    Then I am redirected to "my account page"
    And I can see "MY ACCOUNT" header
    
    @Signin02
  Scenario Outline: I try to sign in not filling one or both fields or entering incorrect data and see an error message
    Given I am on homepage
    And I navigate to "sign in page"
    When I enter "<email>" and "<password>"
    And I click "sign in button"
    Then I see the appropriate "<error>" message
    Examples:
    | email                    | password | error                      |
    | mytestingemail@inbox.lv  |          | Password is required.      |
    |                          | Test151  | An email address required. |
    |                          |          | An email address required. |
    | incorrectemail@email.com | password | Authentication failed.     |
    
  
    @Signin03
  Scenario Outline: I click on Forgot your passsword link on sigh in page and im taken to forgot your password page where
            I can provide the email and retrieve password, and see an error if enter incorrect email or no email at all.
    Given I am on homepage
    And I navigate to "sign in page"
    When I click "forgot your password"
    Then I am redirected to "forgot your password page"
    And can see back to login button
    And there is a field to type my email
    And if I enter incorrect or no "<email>" and press retrieve password button I see an "<error>"
    Examples:
    | email                    | error                                                 |
    | incorrectemail@email.com | There is no account registered for this email address.|
    |                          | Invalid email address.                                |
    | invaliadEmailAdress      | Invalid email address.                                |

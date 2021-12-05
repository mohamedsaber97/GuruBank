Feature: Test the login functionality

  Scenario: verify the login section
    Given User open login page
    When enter valid userId and password
    Then User see success message and home title

  Scenario Outline: verify the login section
    Given User open login page
    When enter invalid "<userId>" and "<password>"
    Then User see error message
    Examples:
      | userId     | password  |
      | saber1234  | qEmUryb   |
      | mngr369906 | 123456789 |
      | saber123   | 123456    |
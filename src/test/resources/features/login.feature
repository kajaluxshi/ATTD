@Login
Feature: Login

  Scenario: verify login for valid credentials
    Given I have OrangeHRM applicaiton loaded
    When I login with username "Admin" and pasword "admin123"
    Then I should navigate to dashboard page

	@invalidcredentials
  Scenario Outline: verify login for valid credentials
    Given I have OrangeHRM applicaiton loaded
    When I login with username "<username>" and password "<password>"
    Then I should get error message "Invalid credentials"
    
    Examples:
    | username | password |
    | admin    | admin    |
    | Admin    | Admin123 |
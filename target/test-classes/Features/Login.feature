Feature: Login
  Scenario: LGN01 Login Success
    Given Open browser
    And Open ebay login page
    And Click sign on navbar
    And Input "dobutsu27@gmail.com" email
    And Click button Continue
    And Input "Test12345." password
    When Click button Sign in
    Then Login successfully

  #worst case
  Scenario: LGN02 Login Failed Wrong Email
    Given Open browser
    And Open ebay login page
    And Click sign on navbar
    And Input "wrong@gmail.com" email
    And Click button Continue
    Then Login failed wrong email

  #worst case
  Scenario: LGN03 Login Failed Wrong Password
    Given Open browser
    And Open ebay login page
    And Click sign on navbar
    And Input "dobutsu27@gmail.com" email
    And Click button Continue
    And Input "Wrong12345." password
    And Click button Sign in
    Then Login failed wrong pass
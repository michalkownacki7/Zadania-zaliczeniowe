Feature: MyStore

  Scenario Outline: Login
    Given I go to the login page
    When I enter "test992@test.com" as email
    And I enter "test123" as password
    And I click on Sign In button
    Then I am logged in
    When I click Addresses
    And I click Create new address
    Then I am in New Address form
    When I type "<alias>"
    And I type "<address>" in Address field
    And I type "<city>" in City field
    And I type "<postalCode>" in Postal Code field
    And I choose "<country>" in Country field
    And I type "<phone>" in Phone field
    And I click Save button
    Then I added Address
    And I check if address is correct
    When I click delete button
    Then I deleted address

    Examples:
      | alias  | address   | city       | postalCode | country | phone     |
      | tester | Testowa 3 | Testopolis | 12-345     | 17      | 911991992 |





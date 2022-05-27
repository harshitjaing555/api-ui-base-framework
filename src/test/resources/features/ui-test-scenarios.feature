Feature: UI test scenarios

  Background: 
    Given user is on computer database home page

  @UI @Regression
  Scenario: Verify User interface on home page and add computer page
    Then user verifies fields, buttons present on home page
    When user clicks on Add a new computer button
    Then user verifies fields, buttons present on add a computer page

  @UI @Regression
  Scenario: Verify error message is displayed on adding a computer by entering null values
    When user clicks on Add a new computer button
    And user clicks on Create this computer button
    Then following error message should be displayed
      """
      Failed to refine type : Predicate isEmpty() did not fail.
      """
    And Error message should be in red color

  @UI @Regression
  Scenario: Verify error message is displayed on adding a computer by entering invalid introduced date
    When user clicks on Add a new computer button
    And user enters computer name and invalid introduction date
    And user clicks on Create this computer button
    Then following error message should be displayed
      """
      Failed to decode date : java.time.format.DateTimeParseException: Text '06-12-2022' could not be parsed at index 0
      """
    And Error message should be in red color

  @UI @Regression
  Scenario: User should be able to delete computer
    When user selects any computer from computer name list
    Then user lands on Edit computer page
    When user click on delete this computer button
    Then following message should be displayed
      """
      Done ! Computer ARRA has been deleted
      """
    When user tries to filter the deleted computer name
    Then following page heading should be displayed
      """
      No computer 
      """

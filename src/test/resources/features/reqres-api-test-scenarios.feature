Feature: Reqres API test scenarios

  @ReqresAPI @Regression
  Scenario Outline: Post Request
    When User hits the post request using end point "<uri>" with "<name>" and "<job>"
    Then User validate response code as <code>

    Examples: -
      | uri        | code | name      | job |
      | /api/users |  201 | Siddharth | QA  |

  @ReqresAPI @Regression
  Scenario Outline: Put Request
    When User hits the put request using end point "<uri>" with "<name>" and "<job>"
    Then User validate response code as <code>

    Examples: -
      | uri          | code | name      | job        |
      | /api/users/2 |  200 | Siddharth | Automation |

  @ReqresAPI @Regression
  Scenario Outline: Patch Request
    When User hits the patch request using end point "<uri>" with "<name>" and "<job>"
    Then User validate response code as <code>

    Examples: -
      | uri          | code | name               | job                 |
      | /api/users/2 |  200 | Siddharth Bhardwaj | Automation Engineer |

  @ReqresAPI @Regression
  Scenario Outline: Delete Request
    When User hits the delete request using end point "<uri>"
    Then User validate response code as <code>

    Examples: -
      | uri          | code |
      | /api/users/2 |  204 |

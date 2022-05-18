Feature: API test scenarios

  @API @Regression
  Scenario Outline: Verify application is up and running
    When User hits the application url
    Then User validate response code as <code>
    And Response body should contain "<text>"

    Examples: -
      | code | text                |
      |  200 | 574 computers found |

  @API @Regression
  Scenario Outline: User should get 200 on hitting valid computer ID
    When User hits the get api using end point "<uri>"
    Then User validate response code as <code>
    And Response body should contain "<text>"

    Examples: 
      | uri  | code | text          |
      | /381 |  200 | Edit computer |

  @API @Regression
  Scenario Outline: User should get 404 on hitting invalid computer ID
    When User hits the get api using end point "<uri>"
    Then User validate response code as <code>

    Examples: 
      | uri  | code |
      | /999 |  404 |

  @API @Regression
  Scenario Outline: User should be able to get the list of all the computers
    When User hits the get api using end point "<uri>"
    Then User validate response code as <code>
    And Response body should contain "<text>"

    Examples: 
      | uri                     | code | text                       |
      | ?p=0&n=600&s=name&d=asc |  200 | Displaying 1 to 574 of 574 |

  @API @Regression
  Scenario Outline: Verify message in response by searching the name of computer that does not exists
    When User hits the get api using end point "<uri>"
    Then User validate response code as <code>
    And Response body should contain "<text>"

    Examples: 
      | uri    | code | text        |
      | ?f=xyz |  200 | No computer |

  @API @Regression
  Scenario Outline: Verify 200 code by searching the name of computer that exists
    When User hits the get api using end point "<uri>"
    Then User validate response code as <code>
    And Response body should contain "<text>"
    And Response body should contain "<computerLink>"

    Examples: 
      | uri          | code | text               | computerLink              |
      | ?f=PalmPilot |  200 | One computer found | href=\\"/computers/565\\" |

  @API @Regression
  Scenario Outline: Verify 400 code for adding a computer by passing null valuesr
    When user hits the post api call to add new computer with empty payload
    Then User validate response code as <code>

    Examples: 
      | code |
      |  400 |

  @API @Regression
  Scenario Outline: Verify status code by passing invalid format of dates
    Given User have invalid format of dates in payload for adding new computer
    When User hits the post api request
    Then User validate response code as <code>

    Examples: 
      | code |
      |  400 |

  @API @Regression
  Scenario Outline: Verify 404 code for fetching the data of the deleted item
    When User hits the delete api using end point "<uri>"
    Then User validate response code as <code>
    When User hits the get api using end point "<getUri>"
    Then User validate response code as <codeNotFound>

    Examples: 
      | uri         | getUri | code | codeNotFound |
      | /381/delete | /381   |  200 |          404 |

  @API @Regression
  Scenario Outline: Verify 201 status code for adding a new computer
    Given User have a payload for adding new computer
    When User hits the post api request
    Then User validate response code as <code>

    Examples: 
      | code |
      |  201 |

Feature: Swagger API Test Scenarios

  @Swagger @Get
  Scenario Outline: Verify application is up and running
    When User hits the application url
    Then User validate response code as <code>
    And Response body should contain "<text>"

    Examples: -
      | code | text       |
      |  200 | Swagger UI |

  @Swagger @Get @AA
  Scenario Outline: User should get 200 on hitting valid Activity, Author, Books, CoverPhotos, Users
    When User hits the get api using end point "<uri>"
    Then User validate response code as <code>
    And Response body should contain "<text>"

    Examples: 
      | uri                   | code | text         |
      | /api/v1/Activities/1  |  200 | Activity 1   |
      | /api/v1/Authors/1     |  200 | First Name 1 |
      | /api/v1/Books/1       |  200 | Book 1       |
      | /api/v1/CoverPhotos/1 |  200 |            1 |
      | /api/v1/Users/1       |  200 | Password1    |

  @Swagger @Get @BB
  Scenario Outline: User should get 404 on hitting invalid Activity, Author, Books, CoverPhotos, Users
    When User hits the get api using end point "<uri>"
    Then User validate response code as <code>
    And Response body should contain "<text>"

    Examples: 
      | uri                     | code | text      |
      | /api/v1/Activities/31   |  404 | Not Found |
      | /api/v1/Authors/615     |  404 | Not Found |
      | /api/v1/Books/201       |  404 | Not Found |
      | /api/v1/CoverPhotos/201 |  404 | Not Found |
      | /api/v1/Users/11        |  404 | Not Found |

  @Swagger @Get @CC
  Scenario Outline: User should be able to use parameter to hit the Activity, Author, Books, CoverPhotos, Users
    When User hits the get api with parameter "<uri>" "<parameter>"
    Then User validate response code as <code>
    And Response body should contain "<text>"

    Examples: 
      | uri                 | parameter | code | text         |
      | /api/v1/Activities  | /5        |  200 | Activity     |
      | /api/v1/Authors     | /5        |  200 | First Name 5 |
      | /api/v1/Books       | /5        |  200 | Book 5       |
      | /api/v1/CoverPhotos | /5        |  200 |            5 |
      | /api/v1/Users       | /5        |  200 | Password5    |

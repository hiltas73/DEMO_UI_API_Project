Feature: Get all the links from footer and write them in a text file
  @wip
  Scenario: Write all footer links in a text file
    Given user navigate to the url
    When user gets all the links from footer of the page
    Then write footer links as a text file
    And click on "Markalar" at the footer
    Then verify footer links with the text file
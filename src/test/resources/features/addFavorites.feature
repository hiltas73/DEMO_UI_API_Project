Feature: Add item into favorites and verify job done

  Scenario: Navigate to Perfume & Deodorant, search for 'Lacoste' brand, add 7th item into favorites
    Given user login to the url
    When user navigate to "Kozmetik & Kişisel Bakım" "Parfüm & Deodorant"
    And user search for "Lacoste"
    And clicks on the item no "7"
    And add product to the favorites
    Then verify the product in favorites is the same with the original product


Feature: To validate coin market cap functionality

  Scenario Outline: Verify the coin market cap
    Given The user should launch the browser
    When The user should load the url
    And The user should select the chart in to list of <chartValue>
    And The user should click on addfilter
    And The user should filter by <algorithmValue>
    #And The user should capture the information from table
    And The user should click on toggle mineable
    And The user should be select all Cryptocurrencies
    And The user should be select coins
    And The user should be select price and set min value
    And The user should compare price name and position
    Then The user should close the browser

    Examples: 
      | chartValue | algorithmValue | min | max   |
      | "20"       | "PoW"          | 100 | 10000 |

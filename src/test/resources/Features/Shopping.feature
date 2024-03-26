Feature: Shopping
  Scenario: SHP01 Search Product From Searchbar
    Given Open browser for shopping
    And Open ebay home page
    When Input "Laptop" product on searchbar
    Then Product successfully found

  Scenario: SHP02 Search Product From Category
    Given Open browser for shopping
    And Open ebay home page
    And Click category on the navbar
    When Click "Shoes" product on category modal
    Then Product successfully found from category

  Scenario: SHP03 Search Product From Category Hover
    Given Open browser for shopping
    And Open ebay home page
    And Hover category product
    When Click "Apple" product on category popup
    Then Product successfully found from category

  Scenario: SHP04 Add Quantity Product
    Given Open browser for shopping
    And Open ebay home page
    And Scroll down to today deals
    When Click product
    Then Input quantity product

   #worst case
  Scenario: SHP05 Add Quantity Product With String
    Given Open browser for shopping
    And Open ebay home page
    And Scroll down to today deals
    And Click product
    When Input quantity product with string
    Then Appers alert quantity

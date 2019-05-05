Meta: Hillel lesson_23 home assignment #2

Narrative:
As a user
I want to have a possibility to choose an item and add it to the shopping cart
So that I can verify selected products before making a purchase

Scenario: Verify that user can add item to a cart, and that selected item is correctly displayed in the cart
Given user opens page, by using following link: 'https://www.sportmaster.ua/ru/'
And user selects current city: 'Киев'
When user searches for next item: 'велосипед'
Then following message is displayed: 'По запросу «%s» найдено товаров:'
When user selects following product: 'Велосипед городской женский Stern Urban 1.0 Lady 28'
And user selects product size: '150-162'
And user adds product to cart
Then user gets needed text
Then user verifies that added item characteristics are correctly displayed in the shopping cart:
| title                                                | color   | size    | price     |
| Велосипед городской женский Stern Urban 1.0 Lady 28" | голубой | 150-162 | 6 399 грн |
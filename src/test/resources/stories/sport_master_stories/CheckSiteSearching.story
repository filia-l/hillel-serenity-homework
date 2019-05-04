Meta: Hillel lesson_23 home assignment #1

Narrative:
As a user
I want to input a text into search field
So that I can see if an item I search for is present on site

Scenario: Verify user is able to search item, using searchbar
Given user opens page, by using following link: 'https://www.sportmaster.ua/ru/'
And user selects current city: 'Киев'
When user searches for next item: 'ff'
Then following message is displayed: 'Поиск По запросу «%s» ничего не найдено'
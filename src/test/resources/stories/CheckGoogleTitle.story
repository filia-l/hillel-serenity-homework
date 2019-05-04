Narrative:

In order to verify Google site
As a user
I want to see Google main page opened correctly

Scenario: Verify Google main page title

Given user opens Sportchek site, using following link https://www.google.com
When register new user with next data:
| name  | mail                  | phone    | age |
| Denis | Deniss22605@gmail.com | 99-88-22 | 40  |
Then the site opened with next title <expectedUrl>
And 'Google' label should be available to display

Examples:
| siteUrl                  | expectedUrl |
| https://www.google.com   | Google      |
| https://www.google.com   | Google_1    |
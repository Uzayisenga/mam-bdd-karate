Feature: MMPI-T46-Verify and validate the country language switch functionality
    @TestCaseKey=TAT-T40
        
        Scenario Outline: Verify whether country language switch is working for different countries and languages
        
            Given user launches '<CDN url>'
        #    And user handles proxy
        #    And user click on preferred country
            And user accept cookies
            And user click on the country language switch on the bottom left corner of the page
        
            And user selects the country as Germany
            And user clicks on country save changes
            And user selects the language as German
            And user clicks language save changes
            And verify the user is redirects to page 'https://www-uat1.miles-and-more.com/de/de/static/country-language.html'
        
        
            And user selects the country as India
            And user clicks on country save changes
            And user selects the language as English
            And user clicks language save changes
            And verify the user is redirects to page "https://www-uat1.miles-and-more.com/row/en/static/country-language.html"
        
            And user selects the country as Poland
            And user clicks on country save changes
            And user selects the language as Polish
            And user clicks language save changes
            And verify the user is redirects to page "https://www-uat1.miles-and-more.com/pl/pl/static/country-language.html"
            Examples:
              |                 CDN url                         |
              | https://www-uat1.miles-and-more.com/at/en.html  |
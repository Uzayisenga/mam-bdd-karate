Feature: MMPI-T44: Promotion form, help & contact form and flight award (geklont)
    @TestCaseKey=TAT-T69
    Scenario: MMPI-T44: Promotion form, help & contact form and flight award (geklont)
        
            And User launch MAM page
            And User clicks on Login button
            And User enter Username & Password
              | Username        | Password |
              | 333034943601374 | 88578    |
            And clicks on Login button for Username
            And user navigates to url "https://www-uat1.miles-and-more.com/de/en/general-information/promotions/audi-on-demand.html"
            And User enters date of birth "15" "07" "1997" in promotion form
            And User enters Street and House number in promotion form
            And User enters postal code in promotion form
            And User enters City in promotion form
            And User enters "test@yopmail.com" in promotion form
            And User enters booking number in promotion form
            And User selects Usage time in promotion form
            And User enter Areacode and Number
            And User upload image in promotion form
            And User clicks on Submit button
            And User verify "Thank you for registering" message
            And User clicks on Help&Support button
            And User clicks on PIN,Password&Login
            And User clicks on Login not possible
            And User enter country code
            And User enter Areacode and Number
            And User enter message in your message here field
            And User clicks on Send button
            Then user should navigate to Thank you page.
            And User clicks on Spend Miles button
            And User clicks on Flights button
            And User enters Depature and Arrival station
            And User checks the OneWay only checkbox
            And User clicks on Search flights button
            And User verify flight availability page is displayed
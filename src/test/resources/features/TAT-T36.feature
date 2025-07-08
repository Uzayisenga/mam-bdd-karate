Feature: MMPI-T42:Validate all the main navigation  in UAT1
    @TestCaseKey=TAT-T36
        
        Scenario Outline:Validate all the main navigation
            Given user is in '<url>' page
            And user accept the neccessary cookie
            And user clicks on login trigger component
            When user logs in using '<login type>''<login_data>''<PIN/PW>' in the login component appropriately
            And User clicks on Earn Miles and navigates to  Selected offers page
            And user navigate to 'Airlines' page
            And user navigate to 'Airports' page
            And user navigate to 'Hotels' page
            And user navigate to 'Travel' page
            And user navigate to 'Mobility' page
            And user navigate to 'Entertainment' page
            And user navigate to 'Shopping' page
            And user navigate to 'Finances' page
            And user navigate to 'All offers' page
            Then user clicks on Spend Miles and navigates to Award Overview page
            And user navigate to 'Flights' page
            And user navigate to 'Hotels' page
            And user navigate to 'Rental cars' page
            And user navigate to 'Gift cards  ' page
            And user navigate to 'WorldShop' page
            And user navigate to 'Donate miles' page
            And user navigate to 'Events' page
            And user navigate to 'Other awards' page
            And user navigate to 'All awards' page
            Then user clicks on Programme and navigates to At a glance page
            And user navigate to 'Benefits when you fly and travel' page
            And user navigate to 'Status Benefits' page
            And user navigate to 'Everyday benefits' page
            And user navigate to 'Partners' page
            And user navigate to 'Credit cards' page
            Then user clicks on Account and navigates to Overview page
            And user navigate to 'Status management' page
            And user navigate to 'Mileage account' page
            And user navigate to 'Profile' page
            And user navigate to 'Bookings' page
            And user navigate to 'Inbox' page
            And user navigate to 'Mileage Pooling' page
            Then user clicks to Logout button
            Examples:
              | login type | login_data      | PIN/PW | url                                            |
              | SCN        | 992002068885702 | 23843  | https://www-uat1.miles-and-more.com/de/en.html |
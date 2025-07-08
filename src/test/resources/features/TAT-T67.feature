Feature: MMPI-T41-Login and logout with servicecardnumber_email address_Tenants (geklont)
    @TestCaseKey=TAT-T67
        Scenario Outline: Verify user is successfully logged into tenant using email id
            Given User launches '<tenant>' page
            And User accepts the proxy cookies for tenants
            And User clicks on Login button on Tenant page
            And User enter email ID & Password on Tenant
              | Email                  | PW        |
              | Uirqsmamsz@yopmail.com | Test@1234 |
            And User click on Login button on Tenant
            And User clicks on profile button on Tenant
            And User clicks Logout button on Tenant
            And User enter SCN & PIN on Tenant
              | SCN             | PIN   |
              | 992004876336027 | 56935 |
        
            Examples:
              | tenant                                             |
              | https://qa-www.lufthansa.com/ro/en/homepage        |
              | https://qa-www.austrian.com/ro/en/homepage         |
              | https://qa-www.swiss.com/ro/en/homepage            |
              | https://qa-www.brusselsairlines.com/ro/en/homepage |
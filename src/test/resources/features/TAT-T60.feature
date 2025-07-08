Feature: MMPI-T3365-TC03_Verify the functionality of login in the partners channel (geklont)
    @TestCaseKey=TAT-T60
        
        Scenario Outline: Verify the functionality of login in the partners channel
          Given '<user-type>' is enrolled via API
            | tenantid   |
            | <tenantid> |
        When user logs in using '<login type>''<PIN/PW>' in the login component appropriately in the '<Partner>' page
        Then compensaid cloud page is displayed
        
        
        Examples:
        |user-type		|login type	|PIN/PW |tenantid  | redirect_uri											   |Partner																																																																																																								|
        |TravelID FFP	|Email		|PW		| MMG      |https://compensaid.cloud/users/auth/miles_and_more/callback|https://account-uat1.miles-and-more.com/partners/de/en/login.html?client_id=TlDCDrKCoqMGIi24t6FEnZPlGgRGwc2i&target_state=AUTHENTICATED&target_url=https://consent-acc.test-msp.miles-and-more.com/&response_type=code&redirect_uri=https%3A%2F%2Fcompensaid.cloud%2Fusers%2Fauth%2Fmiles_and_more%2Fcallback&scope=urn%3Amilesandmore%3Auser%3Aprofile%3Av1%3Aread&state=null&principal_type=EMAIL&reduced_state=NONE					|
        |Legacy FFP		|SCN		|PIN	| MMG      |https://compensaid.cloud/users/auth/miles_and_more/callback|https://account-uat1.miles-and-more.com/partners/de/en/login.html?client_id=TlDCDrKCoqMGIi24t6FEnZPlGgRGwc2i&target_state=AUTHENTICATED&target_url=https://consent-acc.test-msp.miles-and-more.com/&response_type=code&redirect_uri=https%3A%2F%2Fcompensaid.cloud%2Fusers%2Fauth%2Fmiles_and_more%2Fcallback&scope=urn%3Amilesandmore%3Auser%3Aprofile%3Av1%3Aread&state=null&principal_type=SERVICE_CARD_NUMBER&reduced_state=NONE	|
        |Legacy FFP		|Username	|PW		| MMG      |https://compensaid.cloud/users/auth/miles_and_more/callback|https://account-uat1.miles-and-more.com/partners/de/en/login.html?client_id=TlDCDrKCoqMGIi24t6FEnZPlGgRGwc2i&target_state=AUTHENTICATED&target_url=https://consent-acc.test-msp.miles-and-more.com/&response_type=code&redirect_uri=https%3A%2F%2Fcompensaid.cloud%2Fusers%2Fauth%2Fmiles_and_more%2Fcallback&scope=urn%3Amilesandmore%3Auser%3Aprofile%3Av1%3Aread&state=null&principal_type=USERNAME&reduced_state=NONE				|
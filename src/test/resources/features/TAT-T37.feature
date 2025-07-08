Feature: Header and footer validation
    @TestCaseKey=TAT-T37
    Scenario: Header and footer validation
        
            And User launch MAM page
            And User verify Miles and More logo in header
            And User verify Earn miles button available in header
            And User verify Miles and More app link is available in footer
            And User verify all footer buttons
            And User clicks on Login button
            And User enter SCN & PIN
              | SCN             | PIN   |
              | 992000253610547 | 64334 |
            And clicks on Login button for SCN
            And User verify Miles and More logo in header
            And User verify Earn miles button available in header
            And User verify Miles and More app link is available in footer
            And User verify all footer buttons
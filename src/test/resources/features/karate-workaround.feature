##Feature: Download and save all approved Zephyr test cases
##
##  Background:
##    * print '*** FEATURE FILE: karate.config before any API calls:', karate.config
##    # Remove the 'Given url' and 'And header' lines for now to isolate the config loading
##    # Given url karate.config.baseUrl + '/testcases'
##    # And param projectKey = karate.config.projectKey
##    # And param status = karate.config.approvalStatus
##    # And headers karate.config.authHeader
##
##  Scenario: Download and save all approved test cases
##    # We will just assert that karate.config.baseUrl is not null/undefined
##    * def baseUrl = karate.get('baseUrl')
##    * match baseUrl != null
##    * assert karate.config.baseUrl == 'https://eu.api.zephyrscale.smartbear.com/v2'
##    * assert karate.config.authHeader != null
##    * assert karate.config.authHeader.Authorization.startsWith('Bearer ')
##
##    # Remove the actual API call for now
##    # Given url endpoint
##    # And headers { Authorization: karate.config.authHeader.Authorization }
##    # When method GET
##    # Then status 200
##    # * print 'Received Zephyr test cases:', response
#
#  # features/karate-workaround.feature
#
## @Approved # Keep or remove this tag depending on Step 2
#Feature: Download and save all approved Zephyr test cases
#
#  Background:
#    * print '*** FEATURE FILE: karate.config at start of Background:', karate.config
#    # ... rest of Background
#
#  Scenario: Just print config
#    * print 'This scenario is running.'
#    * print 'karate.config again:', karate.config
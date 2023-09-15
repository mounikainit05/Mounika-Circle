Feature: Validating Patient Book Appointment functionality

# Scenario: Validating User/Patient Booking an appointment
#   Given User navigates to the application
#   When  User enters valid credentials
#   And   Clicks on Login button
#   Then  User is navigated to the Dashboard page


  Scenario Outline: Validating User/Patient Booking an appointment
    Given User navigates to the application
    When  User navigates to find a appointment by clicking book appointment
    And User searches"<appointment_search>" and selects "<appointment_type>"
    And   User enters postcode town and clicks on search
    And   User selects the calendar date displayed
    And   User clicks on booknow option displayed
    Then  User is navigated to the booking confirmation page to finish the booking

  Examples:
    |appointment_type        |appointment_search|
    |Knee replacement surgery|knee              |


Feature: Automatic test site cars.com

  Scenario: Comparison of selected cars
    Given User was opened main page cars
    When In the search, the user choose "Read Specs & Reviews"
    Then "Read Specs & Reviews" tab is displayed

    When The user searches for randomly selected characteristics
    Then After clicking on the Search button, a page describing the auto

    When On the Trims tab, the user select the first available vehicle modification
    Then The page with the characteristics of the selected modification was opened

    When Remember 'Available Engines', 'Transmissions' for later comparison
    Then Features 'Available Engines', 'Transmissions'  saved

    When The user goes to the main page cars
    Then The main page of the site is opened

    When In the search, the user choose "Read Specs & Reviews" for second Car
    Then "Read Specs & Reviews" tab for second Car is displayed

    When The user searches for randomly selected characteristics for second Car
    Then After clicking on the Search button, a page describing the second auto

    When On the Trims tab, the user select the first available vehicle modification of second car
    Then The page with the characteristics for second car of the selected modification was opened

    When Remember 'Available Engines', 'Transmissions' of second car for later comparison
    Then Features 'Available Engines', 'Transmissions'  for second car saved

    When In the Trims list, select the first current modification for comparison
    Then Moved to the car comparison page

    When User Selects the first car for comparison press the Add Another Car button and select the desired model
    Then Models have been successfully selected for comparison

    When User checks the comparison page of 2 models
    Then The auto characteristics on the page correspond to those obtained in steps 2-7

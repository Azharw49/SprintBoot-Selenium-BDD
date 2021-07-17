Feature: Validate Visa Registration
@visa
	Scenario Outline: Register Users
		Given I am on Visa homepage
		When I enter "<firstName>" and "<lastName>"
		And I select "<fromCountry>" and "<toCountry>"
		And I select "<dateOfBirth>"
		And I enter "<email>"
		And I enter number "<phone>"
		And I add "<comments>"
		And I submit the application
		Then the request should not be null
		
	Examples:
      | fromCountry      | toCountry                   | dateOfBirth | firstName | lastName  | email              | phone          | comments |
      | Isle of Man      | Mali                        | 2011-05-31  | Kraig     | Wiza      | Kraig@nobody.com   | 1-000-884-1373 | comment1 |
      | Lithuania        | Mexico                      | 2001-01-01  | Houston   | Kertzmann | Houston@nobody.com | 284.864.6580   |          |
      | Somalia          | Greece                      | 2004-07-02  | Ruthie    | Stamm     | Ruthie@nobody.com  | 1-209-813-9712 | comment2 |
      | Christmas Island | French Southern Territories | 2019-04-05  | Shonna    | Nolan     | Shonna@nobody.com  | (162) 387-0305 |          |	
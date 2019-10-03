
Feature:  Pet feature test

	@pet
	Scenario Outline: Testing findStatus feature of Pet service
	Given I check pet service is running
	When I access endpoint <endpoint> with status <status> and petname <petname>
	Then I verify the statuscode is "200"
	And I count the total available pets
	And I verify the available pets
	
	Examples: 
	|endpoint			|petname 	|status 		|
	|findByStatus	|doggie		|available	|
	|findByStatus	|Dragon		|available	|

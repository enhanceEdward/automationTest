# README #

This README would normally document whatever steps are necessary to get your application up and running.

### What is this repository for? ###

This repository covers the needed test to verify the following;

Using the TradeMe Sandbox web site, write automation code which does the following:

* Return how many named brands of used car are available in the TradeMe UsedCarscategory.
* Check that the brand ‘Kia’ exists and return the current number of Kia cars listed.
* Check that the brand ‘Hispano Suiza’ does not exist.

### How do I get set up? ###

Basic setup of;

* Java - Primary code language used in this project.
(helpful link - https://java.com/en/download/help/download_options.xml)

* Maven - to be able to download POM files (.m2).
(helpful link - http://maven.apache.org/install.html)

* Git - to be able to clone (copy) the project.
(helpful link - https://git-scm.com/book/en/v2/Getting-Started-First-Time-Git-Setup)

* IntelliJ(or any preferred IDE of your choice) to be able to manage and run the project.
(helpful link - https://www.jetbrains.com/help/idea/installation-guide.html)

### Notes ###

When running the test;

* TradeMeUsedCarsScenarios.java = covers the API tests which would validate the checks mentioned in the description of what this repository is for. This class has three(3) checks;
	-returnsCountOfNamedBrands()
	-checkCarExists()
	-checkCarDoesntExist()
	
* TradeMeWebScenarios.java = covers the web UI tests (initially created to test the page object model setup)

### Who do I talk to? ###

* Repo owner or admin - Edward Michael Abad (edward@enhanceconsuting.co.nz)
# About

## Technologies & Frameworks
I have chosen **Java** to build this application as I am working with Java since more than 10 years.
-	Spring Framework as DI container.
-	Spring MVC as Web framework.
-	Tiles as templating framework.
-	Dozer as Java bean mapper.
-	Jackson as JSON library mapper.
-	Slf4j with log4j2 implementation as logging library,
-	JUnit4 as unit testing framework.
-	HTML, JS, jQuery, Bootstrap, CSS as front-end technologies.

## Application Features

Regarding the application features it could be summarized in the front-end section below.

However, I have tried in this application to:	
#### Front-end
- Create a simple template using tiles framework and style it with Bootstrap.
- Create a hotel search page that:
	- Has a location field integrated with **Google Location Service**.
	- Start/End Date fields that has a calendar using Bootstrap Datepicker  component and add some cross field interaction to avoid invalid date range input.
- Create Search result view that:
	- Render Offers returned in an appealing manner -I am sure there is way more to be done from what was until now. I thought to make the hotel name to be clickable and open a modal view to show further information about the hotel with **Google Maps View**.
	- The images url returned by the API are pointing to the low resolution image. So I have replaced the suffix of the url to show the higher resolution images for hotel.
	- I have created a filtering menu that works as Ajax calls to backend to filter the results. For now I am just manipulating the filters values on the backend if needed and recalling Expedia API to get a new result set. A lot of other filters could be added and the way of presenting the filters could be changed.
	- I have thought of creating a Sorting menu to sort results as per user preference. but that needs extra effort that I didn't find time for it.
- Create a general error handling page to handle any unexpected downstream errors.
#### Back-end
- Create a standalone library to consume the API so that it can be used by any other consumer and it is abstracted in case of someone needed to implement another API. The abstraction was not completed 100% as the  domain library that has all domain classes is not completed.
	> I have documented the interface for this library to see how documentation for api shall be but I didn't write full documentation for the rest of the methods because of the time constraints and objective here is just to show how it shall be done.
- Extracted some main configuration to properties files like endpoint for calling the API.
- Create Spring MVC app to handle all requests from front-end and do needed handling for requests to avoid application errors. I make the validations loose but efficient to handle almost any request.
- Integrated log4j2 and used slf4j in my application, I have  wrote some logs but definitely more can be added with details. I didn't write a lot  
- Create some helper classes, Util classes, Constants classes ... etc.
- Create model class for the web maven module and used dozer for mapping the adapter response objects to these models. The idea is to show decoupling between the maven modules.
- Create a simple JUnit testcase, I didn't invest time in building all test cases and I just shown 1 test case to show the idea. TDD and BDD development was avoided here.

This is what I have in mind and there way more to be done but I tried to keep as simple as I can ... I18N, theaming, dynamic lookups fed from backend, caching data to save API calls upon certain config and a lot of other things could be done.

I will leave the rest for the interview :).
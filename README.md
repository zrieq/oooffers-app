# Welcome to oooffers-app!

This is a simple application that views deals from Expedia by calling an Expedia API and render results with some filters.

## Project Setup Steps for your local machine
### Prerequisites
You need to have the following installed on your machine:
- Java JDK 7+
- Eclipse IDE
- Maven 3.x (Either standalone version and configure is in your eclipse workspace **OR** use embedded version of maven in your Eclipse)
- Tomcat 7+
### Steps
If you are familiar with the tools, it won't take more that **10 mins** to run the application locally.
 - Download source codes from **GitHub** [here](https://github.com/zrieq/oooffers-app).
 - Open Eclipse and import **eoa-all** project as a maven project.
	 - From Eclipse, goto File -> import.
	 - Type "Existing maven projects" -> click next.
	 - Click on browse to choose the root directory, choose the **eoa-all** directory. Wait eclipse to detect the maven modules.
	 - Click select all to import all the projects to your workspace.
	 - Click Finish.
 - Change **eoa-web** maven properties as follows:
	 - Right click on **eoa-web** -> click properties.
	 - Type maven in filter box -> click on Maven.
	 - Uncheck "Resolve dependencies from Workspace projects".
	 - Click OK.
 - Run a maven build for **eoa-all** from eclipse:
	 - Right click **eoa-all** -> Run  As -> Maven Build -> Set in the Goal field "clean install" -> Run.
	 - Wait the maven build to finish.
	 - Right click **eoa-all** -> Maven -> Update Project ... -> OK.
	 - Wait the maven update to be done.
	 - Right click **eoa-all** -> refresh.
 - Create a Tomcat server in your Eclipse:
	 - Go to Servers view.
		 - If you cannot see it then click from menubar on Window -> show view -> Servers.
	 - Right click on the Servers View -> New -> Server.
	 - Type Tomcat in filter box and select your Tomcat version -> Next
	 - If it is not the first time you create a Tomcat server then skip this step. Choose Tomcat Installation directory -> choose desired JRE -> Next.
	 - Select **eoa-web** from "Available list" -> click "Add >" button -> you shall see **eoa-web** in "Configured" list -> click Finish.
 - Run Tomcat server in you Eclipse
	 - Right click on the create tomcat server from Servers View.
	 - Select Start.
	 - Wait server to start up and check logs in Console View.
 - Open your browser and hit: **[localhost:8080/eoa-web](localhost:8080/eoa-web)**
 - Hoooray, enjoy the app!

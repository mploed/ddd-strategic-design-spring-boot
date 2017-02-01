# DDD Strategic Design with Spring Boot
Application to demonstrate Domain Driven Design Context Mapping patterns based on variosu Spring Boot applications.
Please bear in mind that the application itself is kept simplistic, in order to isolate the focus on the Context Mapping
Patterns. This is the reason why you will find some logic in Controllers that should be placed in other classes in a real-world
application or the reason why I use database IDs for a general purpose.

Also keep in mind that some of the Context Mapping Patterns _not_ best practices but are things that are found in existing, historically grown applications. Context Mapping is mostly a way to look at _existing_ solutions and this code example is an existing solution that has some intentionally built in issues.

A good starting point for your analysis is the CreditApplicationController in credit-application as it implements the
main workflow.


## Prerequisites
- You need a current version of Maven
- A basic installation of Redis must be installed and running (redis-server)

## How to run and install the example

There is no "one-stop" build and install script as of yet so you will have to take a few easy manual steps that you should
*run in this specific order*:

1. Start your redis-server
2. Build the scoring-shared-kernel module
3. Build the customer application
4. Run the customer application
5. Run mvn jaxb2:generate in credit-application while the customer application is running
6. Run the scoring application
7. Run the credit-agency application
8. Run the customer-contact application
9. Run the credit-application application
10. Start entering data at http://localhost:9090

## URLs and Ports
Each of the modules is it's own Spring Boot Application which can be accessed as follows:

<table>
    <tr>
        <th>Name</th>
        <th>Application / Enpoint Type</th>
        <th>Port</th>
        <th>URL</th>
    </tr>
    <tr>
        <td>Credit Application</td>
        <td>Web App</td>
        <td>9090</td>
        <td>http://localhost:9090/</td>
    </tr>
    <tr>
        <td>Customer</td>
        <td>WSDL Endpoint</td>
        <td>9091</td>
        <td>http://localhost:9091/ws/ or http://localhost:9091/ws/customer.wsdl for the wsdl</td>
    </tr>
    <tr>
        <td>Credit Agency</td>
        <td>REST Endpoint</td>
        <td>9092</td>
        <td>http://localhost:9092/personRating</td>
    </tr>
    <tr>
        <td>Scoring</td>
        <td>RMI Endpoint</td>
        <td>1199</td>
        <td>http://localhost:1199/scoringService</td>
    </tr>
    <tr>
        <td>Customer Contact</td>
        <td>No active server endpoint, listens to Redis on the following topics: customer-created-events, credit-application-approved-events</td>
        <td>No open port</td>
        <td>No available URL for access</td>
    </tr>
</table>

# DDD Strategic Design with Spring Boot
Application to demonstrate Domain Driven Design Context Mapping patterns based on Spring Boot

## How to run and install the example

1. Build the customer application
2. Run the customer application
3. Run mvn jaxb2:generate in credit-application while the customer application is running

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
        <td>Scoring</td>
        <td>RMI Endpoint</td>
        <td>1199</td>
        <td>http://localhost:1199/scoringService</td>
    </tr>
</table>

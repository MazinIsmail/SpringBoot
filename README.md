# Service Introduction

The service has to perform the following tasks:

1.	Validate all the mandatory fields
2.	Perform data validations
3.	Execute the steps one by one to perform the calculation.
4.	Return appropriate response to the consumer

## Table of Contents

1. [Overview](#overview)
1. [Dependencies](#dependencies)
1. [API](#api)
1. [Build](#build)
1. [Testing](#testing)
1. [Metrics](#metrics)
1. [License](#license)

## Overview

Project structure and high level description about the packages:

```
./PCCalcRequestService
 |
 |-- config
 |-- api
 |-- model

```

**config**  Contains all project related configuration.

**api**  API exposed by the services in this project.

**model**  Request, Response.


**[Back to top](#table-of-contents)**

## Dependencies

Dependent on Config Server & Swagger.

**[Back to top](#table-of-contents)**

## API

API URL: "/api/v1/calculatePC"

RequestMethod: POST

Produces: JSON

HTTP Status Codes: 200,400,404,500

HTTP Status: 200
Request Body:
{
  "policyNumber": "1234567890",
  "proposalNumber": "123456789011353565"
}
Response Body:
{
"returnCode": "RESP-001",
"returnMessage": "Success",
"submittedPC": "sumbittedPC",
"submittedCaseCount": "submittedCaseCount",
"submittedAPE": "SubmittedAPE"
}


HTTP Status: 400
Request Body:
{
  "policyNumber": "12345678909",
  "proposalNumber": ""
}
Response Body:
{
"returnCode": "RESP-002",
"returnMessage": "policyNumber exceeds the maximum lenth, proposalNumber is missing"
}

HTTP Status: 500
Request Body:
{
  "policyNumber": "12345678909"
  "proposalNumber": ""
}
Response Body:
{
"returnCode": "RESP-005",
"returnMessage": "JSON parse error: Unexpected character ('"' (code 34)): was expecting comma to separate Object entries; nested exception is com.fasterxml.jackson.core.JsonParseException: Unexpected character ('"' (code 34)): was expecting comma to separate Object entries at [Source: java.io.PushbackInputStream@5625c2da; line: 3, column: 4]"
}


**[Back to top](#table-of-contents)**

## Build

Please refer the CI folder for Build and Deployment

**[Back to top](#table-of-contents)**

## Testing

All the test classes are available in the folder: src/test/java

**Unit Test Classes:**

PCCalcTriggerControllerTest.java

RequestValidationTest.java


**Integration Test Classes:**



**[Back to top](#table-of-contents)**

## Metrics

Static Code Analysis:

JUnit Test Cases: [JUnit.PNG]

Code Coverage Details: [Coverage.PNG]

**[Back to top](#table-of-contents)**

## License

Copyright (c) 2018 Manulife International Ltd.

**[Back to top](#table-of-contents)**
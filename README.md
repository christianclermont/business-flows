# business-flows
Sample backend app to manage business processes.

This application is featuring the following:
- A REST API documented using Swagger;
- An integration with Camunda Saas platform;
- A Spring Boot App using the latest version;
- Java 21 technology;
- Fully documented and Code coverage with Unit Tests;
- A simple BPMN diagram allowing to move cash from / to a Bank account;
- A Camunda Job Worker using Spring Boot Camunda annotation to complete the tranfer service task. 

This is the initial requirement of the application. We did some experiment with GitHub Copilot around these specs.

Here is the result:

# GitHub Copilot experiment

This repo was build using GitHub Copilot AI. Original code used for experimenting:

> [Spring Boot 3 REST API example: CRUD App](https://www.bezkoder.com/spring-boot-3-rest-api/)


# Experiment summary


Wow, I'm impressed. In the short time I used to experiment GitHub Copilot, I was able to accomplish a lot of my daily tasks as a software engineer, even if I was new to this tool.

I did install a Linux subsystem on my personal laptop, add VS Code, with the GitHub Copilot interacting with my GitHub repo in a very short time.

I think this is only the tip of the iceberg. Experimenting in the day to day task at work would be a must. 

I was for a long time to have the right to use AI at work.  It remind me the Internet revolution in 1994. At the beginning of this new Era, businesses were reluctant to provide access to employe, being afraid of their staff just accessing websites for pure personal interest an entertainment.

Today, we are in the same situation with AI. But can we imagine working without internet today ? There is so much information and resources that allow to learn an be more efficient in our day to day task, that it is a no brainer.

Same for AI. I think we are just at the beginning. But early adopters will thrive and succeed. AI is a partner, a helper, someone that help you in your clerical daily task way more efficiently, and that can help and guide you. It make you more efficient. Do more, in a shorter time.

So, in summary, I think we cannot avoid it. Coding practices will change. There will be a before and an after.

I think, for businesses, they have to take a pause and think about it. Trying to produce deliverable in a short period of time with a lot of man power is doable. But the wise choice would be to invest into their employees to learn how to use AI, so that they have the ability to do more in a shorter time frame. This is for sure, the ROI on a minor investment into learning AI, would be undeniably positively impactful.

--

The following text was the original code used for the GitHub Copilot experiment.


# Spring Boot 3 REST API: CRUD example

For more detail, please visit:
> [Spring Boot 3 REST API example: CRUD App](https://www.bezkoder.com/spring-boot-3-rest-api/)

In this tutorial, we're gonna build a Spring Boot 3 Rest API example with Maven that implement CRUD operations. You'll know:
- Way to define Spring Rest Controller
- Way to handle HTTP GET, POST, PUT, DELETE requests for CRUD Operations
- How to define Data Model and Service Component

Front-end that works well with this Back-end
> [Angular 8 Client](https://www.bezkoder.com/angular-crud-app/)

> [Angular 10 Client](https://www.bezkoder.com/angular-10-crud-app/)

> [Angular 11 Client](https://www.bezkoder.com/angular-11-crud-app/)

> [Angular 12 Client](https://www.bezkoder.com/angular-12-crud-app/)

> [Angular 13 Client](https://www.bezkoder.com/angular-13-crud-example/)

> [Angular 14 Client](https://www.bezkoder.com/angular-14-crud-example/)

> [Angular 15 Client](https://www.bezkoder.com/angular-15-crud-example/)

> [Angular 16 Client](https://www.bezkoder.com/angular-16-crud-example/)

> [Angular 17 Client](https://www.bezkoder.com/angular-17-crud-example/)

> [Vue 2 Client](https://www.bezkoder.com/vue-js-crud-app/)

> [Vue 3 Client](https://www.bezkoder.com/vue-3-crud/)

> [Vuetify Client](https://www.bezkoder.com/vuetify-data-table-example/)

> [React Client](https://www.bezkoder.com/react-hooks-crud-axios-api/)

> [React Redux Client](https://www.bezkoder.com/redux-toolkit-crud-react-hooks/)

Other databases:
> [Spring Boot JPA + H2](https://www.bezkoder.com/spring-boot-jpa-h2-example/)

> [Spring Boot JPA + MySQL](https://www.bezkoder.com/spring-boot-jpa-crud-rest-api/)

> [Spring Boot JPA + PostgreSQL](https://www.bezkoder.com/spring-boot-postgresql-example/)

> [Spring Boot JPA + SQL Server](https://www.bezkoder.com/spring-boot-sql-server/)

> [Spring Boot + MongoDB](https://www.bezkoder.com/spring-boot-mongodb-crud/)

More Practice:
> [Spring Boot File upload example with Multipart File](https://www.bezkoder.com/spring-boot-file-upload/)

> [Spring Boot Pagination & Filter example | Spring JPA, Pageable](https://www.bezkoder.com/spring-boot-pagination-filter-jpa-pageable/)

> [Spring Data JPA Sort/Order by multiple Columns | Spring Boot](https://www.bezkoder.com/spring-data-sort-multiple-columns/)

> [Spring Boot Repository Unit Test with @DataJpaTest](https://www.bezkoder.com/spring-boot-unit-test-jpa-repo-datajpatest/)

> [Deploy Spring Boot App on AWS – Elastic Beanstalk](https://www.bezkoder.com/deploy-spring-boot-aws-eb/)

Exception Handling:
> [Spring Boot @ControllerAdvice & @ExceptionHandler example](https://www.bezkoder.com/spring-boot-controlleradvice-exceptionhandler/)

> [@RestControllerAdvice example in Spring Boot](https://www.bezkoder.com/spring-boot-restcontrolleradvice/)

Security:
> [Spring Boot + Spring Security JWT Authentication & Authorization](https://www.bezkoder.com/spring-boot-jwt-authentication/)

Fullstack:
> [Vue + Spring Boot example](https://www.bezkoder.com/spring-boot-vue-js-crud-example/)

> [Angular 8 + Spring Boot example](https://www.bezkoder.com/angular-spring-boot-crud/)

> [Angular 10 + Spring Boot example](https://www.bezkoder.com/angular-10-spring-boot-crud/)

> [Angular 11 + Spring Boot example](https://www.bezkoder.com/angular-11-spring-boot-crud/)

> [Angular 12 + Spring Boot example](https://www.bezkoder.com/angular-12-spring-boot-crud/)

> [Angular 13 + Spring Boot example](https://www.bezkoder.com/spring-boot-angular-13-crud/)

> [Angular 14 + Spring Boot example](https://www.bezkoder.com/spring-boot-angular-14-crud/)

> [Angular 15 + Spring Boot example](https://www.bezkoder.com/spring-boot-angular-15-crud/)

> [Angular 16 + Spring Boot example](https://www.bezkoder.com/spring-boot-angular-16-crud/)

> [Angular 17 + Spring Boot example](https://www.bezkoder.com/spring-boot-angular-17-crud/)

> [React + Spring Boot + MySQL example](https://www.bezkoder.com/react-spring-boot-crud/)

> [React + Spring Boot + PostgreSQL example](https://www.bezkoder.com/spring-boot-react-postgresql/)

Run both Back-end & Front-end in one place:
> [Integrate Angular with Spring Boot Rest API](https://www.bezkoder.com/integrate-angular-spring-boot/)

> [Integrate React.js with Spring Boot Rest API](https://www.bezkoder.com/integrate-reactjs-spring-boot/)

> [Integrate Vue.js with Spring Boot Rest API](https://www.bezkoder.com/integrate-vue-spring-boot/)

## Run Spring Boot application
```
mvn spring-boot:run
```


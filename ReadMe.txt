1️ Spring Cloud LoadBalancer Works by Default with Feign
Feign automatically integrates with Spring Cloud LoadBalancer.
Even without FeignConfig.class, Feign internally uses LoadBalancer to distribute requests to multiple instances of ORDER-SERVICE.

2️ Avoiding Manual Configuration Unless Necessary
The FeignConfig we added was manually setting a custom Client bean to use LoadBalancer.
But Spring Boot 3 & Spring Cloud 2024.0.0 already handle this automatically.

unless we need custom configurations like:
Custom timeouts or retry policies.
Logging requests between services.
Using a different load balancing strategy (e.g., Weighted, Random).
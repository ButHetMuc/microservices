package but.learnspring.cloudgateway.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/user/")
                        .filters(f-> f.circuitBreaker(c-> c.setName("breaker").setFallbackUri("/fallback/")))
                        .uri("http://localhost:9000"))
                .route(p -> p
                        .path("/department/")
                        .filters(f-> f.requestRateLimiter().configure(c-> c.setRateLimiter(redisRateLimiter())))
                        .uri("http://localhost:8081"))
                .build();
    }

    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory>  defaultCustomizer(){
        return factory-> factory.configureDefault(id-> new Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults()).timeLimiterConfig(
                        TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(2)).build()).build());
    }
    @Bean
    public RedisRateLimiter redisRateLimiter (){
        return new RedisRateLimiter(10,20);
    }

    @Bean
    KeyResolver userKeyResolver(){
        return exchange -> Mono.just("1");
    }
}

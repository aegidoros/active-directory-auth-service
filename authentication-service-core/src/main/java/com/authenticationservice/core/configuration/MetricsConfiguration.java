package com.authenticationservice.core.configuration;

        import com.tui.architecture.metrics.aspect.AbstractMetricsAspect;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;

/**
 * Created by cjrequena on 04/09/16.
 */
@Configuration
@ComponentScan(basePackages = {"com.tui.architecture.metrics"}, basePackageClasses = AbstractMetricsAspect.class)
public class MetricsConfiguration {
}

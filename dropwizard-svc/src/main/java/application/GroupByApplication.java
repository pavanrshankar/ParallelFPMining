package application;

import configuration.GroupByConfiguration;
import executor.SparkExecutor;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import parallel.SparkInitialize;
import resource.MiningResource;
import resource.GroupByResource;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import javax.servlet.FilterRegistration.Dynamic;

/**
 * Created by pavan.r on 11/05/16.
 */
public class GroupByApplication extends Application<GroupByConfiguration> {
    public static void main(String [] args) throws Exception {
        new GroupByApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<GroupByConfiguration> bootstrap) {}

    @Override
    public void run(GroupByConfiguration groupByConfiguration, Environment environment) throws Exception {
        configureCors(environment);

        SparkExecutor sparkExecutor = new SparkExecutor("SparkContextLocal.xml");
        sparkExecutor.initialize();

        SparkInitialize sparkActions = new SparkInitialize(sparkExecutor);
        sparkActions.start();

        environment.jersey().register(new GroupByResource(sparkActions));
        environment.jersey().register(new MiningResource(sparkActions));
    }
    private void configureCors(Environment environment) {
        Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,DELETE,OPTIONS");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        filter.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        filter.setInitParameter("allowedHeaders", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        filter.setInitParameter("allowCredentials", "true");
    }
}

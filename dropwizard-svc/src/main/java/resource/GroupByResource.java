package resource;

import output.SectionTotal;
import parallel.SparkInitialize;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Created by pavan.r on 11/05/16.
 */
@Path("/group")
@Produces(MediaType.APPLICATION_JSON)
public class GroupByResource {
    private SparkInitialize sparkActions;

    public GroupByResource(SparkInitialize sparkActions){
        this.sparkActions = sparkActions;
    }

    @GET
    public SectionTotal groupByField(){
        SectionTotal sectionTotal = sparkActions.group();
        return sectionTotal;
    }
}

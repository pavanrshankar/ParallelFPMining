package resource;


import output.MiningResult;
import parallel.SparkInitialize;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by pavan.r on 20/05/16.
 */
@Path("/mineRules")
@Produces(MediaType.APPLICATION_JSON)
public class MiningResource {
    private SparkInitialize sparkActions;

    public MiningResource(SparkInitialize sparkActions){
        this.sparkActions = sparkActions;
    }

    @GET
    @Path("/{support}/{confidence}")
    public MiningResult mineRules(@PathParam("support") double support,
                                  @PathParam("confidence") double confidence){
        return sparkActions.mineRules(support,confidence);
    }
}

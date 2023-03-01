package org.acme;

import org.jboss.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.TimeUnit;

@Path("/log")
@Produces(MediaType.TEXT_PLAIN)
public class LogOutput {

    private static final Logger LOGGER = Logger.getLogger(LogOutput.class);

    @GET
    public String log() {
        LOGGER.info("001 - Test");
        return "001 - Test";
    }

    @GET
    @Path("msgReceived")
    public String logRec() {
        LOGGER.info("INFO 1 --- [XNIO-2 task-2] receiveMessage : Received message: D0348A.MAH003.IN3. 3099024");
        return "INFO 1 --- [XNIO-2 task-2] receiveMessage : Received message: D0348A.MAH003.IN3. 3099024";
    }

    @GET
    @Path("msgSent")
    public String logSent() {
        LOGGER.info("INFO 1 --- [XNIO-2 task-2] sendMessage : Send message: D0348A.MAH003.IN3. 3099024");
        return "INFO 1 --- [XNIO-2 task-2] sendMessage : Send message: D0348A.MAH003.IN3. 3099024";
    }

    @GET
    @Path("msgStored")
    public String logStored() {
        LOGGER.info("INFO 1 --- [XNIO-2 task-1] c.b.dif.centralrouter.MessageRepository : Stored message CORRID: D0348A.MAH013.IN3. 3098678");
        return "INFO 1 --- [XNIO-2 task-1] c.b.dif.centralrouter.MessageRepository : Stored message CORRID: D0348A.MAH013.IN3. 3098678";
    }

    @GET
    @Path("fileReceived")
    public String logFileRec() {
        LOGGER.info("INFO 1 --- [Camel (CentralRouter) thread #2 - file:///difrouter/desbs/stg/in/] DeployedToCentralFileRoute : Filename Read: /difrouter/desbs/stg/in/D0348A_DATAGR_N0931A_003204_20221020113002.zip");
        return "INFO 1 --- [Camel (CentralRouter) thread #2 - file:///difrouter/desbs/stg/in/] DeployedToCentralFileRoute : Filename Read: /difrouter/desbs/stg/in/D0348A_DATAGR_N0931A_003204_20221020113002.zip";
    }

    @GET
    @Path("fileSent")
    public String logFileSent() {
        LOGGER.info("INFO 1 --- [Camel (CentralRouter) thread #2 - file:///difrouter/desbs/stg/in/] DeployedToCentralFileRoute : Filename Written: /difrouter/dif/out/D0348A_DATAGR_N0931A_003204_20221020113002.zip");
        return "INFO 1 --- [Camel (CentralRouter) thread #2 - file:///difrouter/desbs/stg/in/] DeployedToCentralFileRoute : Filename Written: /difrouter/dif/out/D0348A_DATAGR_N0931A_003204_20221020113002.zip";
    }

    @GET
    @Path("dupError")
    public String logDupError() {
        LOGGER.error("ERROR 1 --- [XNIO-2 task-1] removeDuplicateMessages : Duplicate message ignored, CORRID: A2971A.CA320A.IN4. 3251661");
        return "ERROR 1 --- [XNIO-2 task-1] removeDuplicateMessages : Duplicate message ignored, CORRID: A2971A.CA320A.IN4. 3251661";
    }

    @POST
    @Path("loop/{num}")
    public String loopTimes(int num) throws InterruptedException{
        for (int i = num; i > 0; i--){
            LOGGER.info("INFO 1 --- [XNIO-2 task-2] receiveMessage : Received message: D0348A.MAH003.IN3. 3099024");
            TimeUnit.SECONDS.sleep(1);
        }
        return "INFO 1 --- [XNIO-2 task-2] receiveMessage : Received message: D0348A.MAH003.IN3. 3099024";
    }

}
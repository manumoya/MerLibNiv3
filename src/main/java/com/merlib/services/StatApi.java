package com.merlib.services;

import com.merlib.models.Estadistica;
import com.merlib.process.Stats;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("stats")
public class StatApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response showStat(){
        Estadistica stat = Stats.getStats();
        return Response.ok(stat).build();
    }

}

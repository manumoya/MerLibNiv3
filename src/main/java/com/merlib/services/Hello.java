package com.merlib.services;

import com.merlib.models.Respuesta;
import com.merlib.process.Mutant;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("hello")
public class Hello {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHello(){

        Respuesta resp = new Respuesta(true);
        return Response.ok(resp).build();


    }

    @POST
    @Path("/{dna}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHello(@PathParam("dna") String dna){
        System.out.println("DNA: " + dna);
        return Response.status(Response.Status.FORBIDDEN).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delHello(String req){
        //System.out.println("DNA: " + request);

        /*  convertir json en array */
        JSONObject obj = new JSONObject(req);
        JSONArray array = obj.getJSONArray("dna");
        int largo = array.length();
        String[] arr = new String[largo];
        //JSONObject json_object = new JSONObject();
        for(int i = 0 ; i < largo ; i++){
            //JSONObject elemento = array.getJSONObject(i);
            //arr[i] = elemento.toString() ;
            arr[i]  =  array.getString(i);
            System.out.println("VAL: " + arr[i]);
        }

        //boolean isMutant = Mutant.isMutant(arr);
        boolean isMutant = Mutant.isMutant(arr);
        Respuesta resp = new Respuesta(isMutant);
        if (isMutant){
            return Response.ok(resp).build();
        }else{
            return Response.status(Response.Status.FORBIDDEN).entity(resp).build();
        }


    }
}

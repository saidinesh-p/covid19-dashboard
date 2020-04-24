package com.easyway.covid.rest;


import com.easyway.covid.domain.Records;
import com.easyway.covid.services.RecordsService;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

@Path("/covid")
public class RestService {

    ObjectMapper mapper = new ObjectMapper();

    @POST
    @Path("/addRecords")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addRecords(String recordsRequest) throws IOException {
        RecordsService recordsService = new RecordsService();
        LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
        Response.ResponseBuilder builder = null;
        try {
            System.out.println("##### recordsRequest ###" + recordsRequest);
            Records records = (Records) readObject(recordsRequest, Records.class);
            System.out.println("##### records ###" + records);
            recordsService.insertRecords(records);
            response.put("code", 200);
            response.put("description","Successfully inserted");
            String result = mapper.writeValueAsString(response);
            System.out.println("+++abc+++ "+result);
            builder = Response.status(200).entity(result);
        } catch (Exception e) {
            String exception = null;
            exception = getExceptionMessage(e.getCause());
            if(exception.contains("Duplicate entry"))
            {
                response.put("code", 200);
                response.put("description","Dulpicate entry for country");
                String result = mapper.writeValueAsString(response);
                System.out.println("+++abc+++ "+result);
                builder = Response.status(200).entity(result);
            }
            System.out.println("##### Exception ###" + e);
        }
        assert builder != null;
        return builder.build();
    }

    @GET
    @Path("/getAllRecords")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getAllRecords() throws JsonGenerationException, JsonMappingException, IOException {
        LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
        RecordsService recordsService  = new RecordsService();
        List<Records> records = recordsService.getAllRecords();
        System.out.println("records.get(0) "+records.get(0));
        response.put("total", records.size());
        response.put("Records", records);
        return Response.status(Response.Status.OK).entity(mapper.writeValueAsString(response)).build();
    }

    @GET
    @Path("/getRecordsByCountry")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getRecordsByCountry(@QueryParam("country") String country) throws JsonGenerationException, JsonMappingException, IOException {
        LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
        RecordsService recordsService  = new RecordsService();

        List<Records> records = recordsService.getRecordsByCountry(country);

        System.out.println("records.get(0) "+records.get(0));
        response.put("total", records.size());
        response.put("Records", records);
        return Response.status(Response.Status.OK).entity(mapper.writeValueAsString(response)).build();
    }

    @PUT
    @Path("/updateRecords")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateRecords(String recordsRequest) throws IOException {
        RecordsService recordsService = new RecordsService();
        LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
        Response.ResponseBuilder builder = null;
        try {
            System.out.println("##### recordsRequest ###" + recordsRequest);
            Records records = (Records) readObject(recordsRequest, Records.class);
            System.out.println("##### records ###" + records);

            recordsService.updateRecords(records);

            response.put("code", 200);
            response.put("description","Successfully updated");
            String result = mapper.writeValueAsString(response);
            System.out.println("+++abc+++ "+result);
            builder = Response.status(200).entity(result);

        } catch (Exception e) {
            System.out.println("##### Exception ###" + e);
        }
        assert builder != null;
        return builder.build();
    }
   public static Object readObject(String response, Class<?> obj)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
        mapper.setAnnotationIntrospector(introspector);
        return mapper.readValue(response, obj);
    }
   public static String getExceptionMessage(Throwable t) {

        String msg = t.getLocalizedMessage();
        if (StringUtils.isBlank(msg)) {
            msg = t.getClass().getSimpleName();
        }
        if (StringUtils.isBlank(msg)) {
            msg = t.getClass().getName();
        }
        return msg;
    }
}

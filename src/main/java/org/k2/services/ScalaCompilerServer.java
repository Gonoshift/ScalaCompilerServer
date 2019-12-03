package org.k2.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.k2.models.JsonResponseModel;
import org.k2.models.ScalaFileModel;
import org.k2.utilities.ScalaShellCompiler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

@Path("/compiler")
public class ScalaCompilerServer {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        return "Hello, hello! ";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("upload")
    public JsonResponseModel saveFile(ScalaFileModel sfm) throws IOException {
        String filename = UUID.randomUUID().toString();

        if(!new File("/opt/tomcat/uploads/"+filename+"/sourcecode.scala").exists())
        {
            File myfile = new File("/opt/tomcat/uploads/"+filename+"/sourcecode.scala");
            //Create subfolder with UUID name that will contain file
            myfile.getParentFile().mkdirs();
            //Then create file
            myfile.createNewFile();

            FileWriter writer = new FileWriter("/opt/tomcat/uploads/"+filename+"/sourcecode.scala");
            writer.write(sfm.getProgramContent());
            writer.close();
            JsonResponseModel response = new JsonResponseModel(filename,0);
            return response;
        }
        JsonResponseModel response = new JsonResponseModel(
                "",
                1,
                "File Exists"
        );
        return response;

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("compile")
    public JsonResponseModel Compiler(ScalaFileModel sfm) throws JsonProcessingException {
        ScalaShellCompiler shellCompiler = new ScalaShellCompiler();
        JsonResponseModel response = new JsonResponseModel(shellCompiler.runCompiler(sfm.getProgramName()),0);
        return response;
    }

}
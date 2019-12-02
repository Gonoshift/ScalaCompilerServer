package org.k2.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonResponseModel {

    private String result;
    private int error;
    private String errorMsg;

    public JsonResponseModel(String result, int error, String errorMsg) {
        this.result = result;
        this.error = error;
        this.errorMsg = errorMsg;
    }

    public JsonResponseModel(String result, int error) {
        this.result = result;
        this.error = error;
    }

    public String getJsonResponse(JsonResponseModel jrm) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonResponse = mapper.writeValueAsString(jrm);
        return jsonResponse;
    }

    //Getters are needed by Jackson library

    public String getResult() {
        return result;
    }

    public int getError() {
        return error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}

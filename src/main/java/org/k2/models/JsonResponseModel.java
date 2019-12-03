package org.k2.models;

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

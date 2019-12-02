package org.k2.models;

public class ScalaFileModel {

    private String programName;
    private int datasetID;
    private String programContent;

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getDatasetID() {
        return datasetID;
    }

    public void setDatasetID(int datasetID) {
        this.datasetID = datasetID;
    }

    public String getProgramContent() {
        return programContent;
    }

    public void setProgramContent(String programContent) {
        this.programContent = programContent;
    }
}
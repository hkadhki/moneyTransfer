package com.example.kp_transfer.model;

public class SchemaResponse {

    private String operationId;

    public SchemaResponse(String operationId){
        this.operationId = operationId;
    }
    public SchemaResponse(){
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }
}

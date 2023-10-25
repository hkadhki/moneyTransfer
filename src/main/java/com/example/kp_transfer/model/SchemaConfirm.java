package com.example.kp_transfer.model;

public class SchemaConfirm {
    private String operationId;
    private String code;

    public SchemaConfirm(String operationId , String code){
        this.operationId = operationId;
        this.code = code;
    }
    public SchemaConfirm(){
    }


    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

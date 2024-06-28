package com.rabbiter.cm.model.vo.response;

public class ParameterErrorVO {
    private String fieldName;
    private String message;

    public ParameterErrorVO() {

    }

    public ParameterErrorVO(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ParameterErrorVO{" +
                "fieldName='" + fieldName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

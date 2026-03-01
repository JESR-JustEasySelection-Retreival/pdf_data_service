package com.w.callum.pdf_service_data.model.request;

public class MetaRequest {
    private String base64;

    public MetaRequest() {
    }

    public MetaRequest(String base64) {
        this.base64 = base64;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}

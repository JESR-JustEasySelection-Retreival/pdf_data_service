package com.w.callum.pdf_service_data.model;

public record ExtractionRequest(String documentUid, String base64EncodedDocument, Selection... selections) {
}

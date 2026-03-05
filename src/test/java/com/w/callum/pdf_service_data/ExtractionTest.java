package com.w.callum.pdf_service_data;

import com.w.callum.pdf_service_data.extraction.ExtractionTextStripper;
import com.w.callum.pdf_service_data.model.Coordinate;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ExtractionTest {
    @Test
    public void ExtractionTestOne() {
        File encodedDocument = new File("src/test/java/com/w/callum/pdf_service_data/invoice_Phillip Breyer_11502.txt");
        try (FileInputStream fileInputStream = new FileInputStream(encodedDocument)) {
            byte[] data = fileInputStream.readAllBytes();
            String encodedData = new String(data, StandardCharsets.UTF_8);
            byte[] decodedDocument = Base64.getDecoder().decode(encodedData);

            try (PDDocument document = Loader.loadPDF(decodedDocument)) {
                Coordinate coordinate = new Coordinate(0, document.getPage(0).getMediaBox().getWidth(), 0, document.getPage(0).getMediaBox().getHeight());
                ExtractionTextStripper extractionTextStripper = new ExtractionTextStripper(coordinate);
                extractionTextStripper.setPageStart("0");
                extractionTextStripper.setPageEnd("0");
                extractionTextStripper.getText(document);

                Assertions.assertFalse(extractionTextStripper.getStrippedData().isEmpty());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
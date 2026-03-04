package com.w.callum.pdf_service_data.extraction;

import com.w.callum.pdf_service_data.model.Coordinate;
import com.w.callum.pdf_service_data.model.Selection;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExtractionTextStripper extends PDFTextStripper {
    public ExtractionTextStripper(PDDocument document, Coordinate... coordinate) {
    }

    @Override
    public String getText(PDDocument doc) throws IOException {
        return super.getText(doc);
    }

    @Override
    protected void writeString(String text, List<TextPosition> textPositions) throws IOException {
        super.writeString(text, textPositions);

        System.out.println(text);
    }

    @Override
    protected void writeLineSeparator() throws IOException { //Writes \n called the line sep character.
        super.writeLineSeparator();
    }

    @Override
    protected void writeWordSeparator() throws IOException { //Writes the space in between words.
        super.writeWordSeparator();
    }
}
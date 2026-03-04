package com.w.callum.pdf_service_data.extraction;

import com.w.callum.pdf_service_data.model.Coordinate;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class ExtractionTextStripper extends PDFTextStripper implements AutoCloseable {
    private final Coordinate[] selectionCoordinates;
    private final Writer output;

    public ExtractionTextStripper(Coordinate... coordinate) {
        this.selectionCoordinates = coordinate;
        output = new StringWriter();
    }

    public ExtractionTextStripper(Writer output, Coordinate... coordinate) {
        this.selectionCoordinates = coordinate;
        this.output = output;
    }

    @Override
    public String getText(PDDocument doc) throws IOException {
        return super.getText(doc);
    }

    @Override
    protected void writeString(String text, List<TextPosition> textPositions) throws IOException {
        List<Coordinate> textCoordinates = textPositions.stream().map(textPosition -> new Coordinate(textPosition.getX(),
                textPosition.getX() + textPosition.getWidth(),
                textPosition.getY(),
                textPosition.getY() + textPosition.getHeight())).toList();

        for (Coordinate textCoord : textCoordinates) {
            for (Coordinate selCoord : selectionCoordinates) {
                if (textCoord.isColliding(selCoord)) {
                    output.write(text);
                    return;
                }
            }
        }
    }

    @Override
    protected void writeLineSeparator() throws IOException { //Writes \n called the line sep character.
        super.writeLineSeparator();
    }

    @Override
    protected void writeWordSeparator() throws IOException { //Writes the space in between words.
        super.writeWordSeparator();
    }

    @Override
    public void close() throws Exception {
        output.close();
    }
}
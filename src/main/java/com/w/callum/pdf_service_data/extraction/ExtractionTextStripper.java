package com.w.callum.pdf_service_data.extraction;

import com.w.callum.pdf_service_data.model.Coordinate;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class ExtractionTextStripper extends PDFTextStripper {
    private final Coordinate[] selectionCoordinates;
    private final Map<Double, List<TextData>> strippedData = new HashMap<>();

    public ExtractionTextStripper(Coordinate... coordinate) {
        this.selectionCoordinates = coordinate;
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
                    write(text, textCoord, selCoord);
                    return;
                }
            }
        }
    }

    protected void write(String text, Coordinate textCoordinate, Coordinate selectionCoordinate){
        System.out.println(text);

        double mapKey = textCoordinate.y1();
        List<TextData> listArr = strippedData.getOrDefault(mapKey, new ArrayList<>());
        listArr.add(new TextData(text, textCoordinate, selectionCoordinate));
        strippedData.put(mapKey, listArr);
    }

    public Map<Double, List<TextData>> getStrippedData() {
        return strippedData;
    }

    public record TextData(String text, Coordinate textCoordinate, Coordinate SelectionCoordinate){}
}
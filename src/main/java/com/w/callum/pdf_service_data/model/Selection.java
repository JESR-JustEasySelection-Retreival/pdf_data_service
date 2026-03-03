package com.w.callum.pdf_service_data.model;

import java.util.ArrayList;
import java.util.List;

public record Selection(String selectionUUID, String documentUUID, Coordinate coordinate, int pageNumber, String pageKey) {
    public static Coordinate[] CoordinatesToSelection(Selection... selections){
        Coordinate[] arr = new Coordinate[selections.length];

        for (int x = 0; x < selections.length; x++){
            arr[x] = selections[x].coordinate;
        }

        return arr;
    }

    public static List<Coordinate> CoordinatesToSelection(List<Selection> selections){
        List<Coordinate> arr = new ArrayList<>(selections.size());

        for (Selection selection : selections) {
            arr.add(selection.coordinate);
        }

        return arr;
    }
}

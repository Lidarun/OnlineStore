package com.example.gadgetariumb7.dto.converter;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ColorNameMapper {

    private static final Map<String, String> colorMap = new HashMap<>();

    static {
        colorMap.put("#FFFFFF", "White");
        colorMap.put("#FFBEBE", "Peach");
        colorMap.put("#FFEBBE", "Pink");
        colorMap.put("#FFD37F", "Pale Orange");
        colorMap.put("#FFFFBE", "Yellow");
        colorMap.put("#D1FF73", "Lime");
        colorMap.put("#BEFFE8", "Turquoise");
        colorMap.put("#BEE8FF", "Baby Blue");
        colorMap.put("#BED2FF", "Lavender");
        colorMap.put("#FFBEE8", "Light Pink");
        colorMap.put("#CD6666", "Tomato");
        colorMap.put("#FFA77F", "Bright Orange");
        colorMap.put("#FFAA00", "Bright Yellow");
        colorMap.put("#72FFE0", "Turquoise");
        colorMap.put("#73DFFF", "Turquoise");
        colorMap.put("#C500FF", "Purple");
        colorMap.put("#CCCCCC", "Gray");
        colorMap.put("#FF0000", "Red");
        colorMap.put("#E69800", "Golden");
        colorMap.put("#00C5FF", "Turquoise");
        colorMap.put("#040097", "Deep Blue");
        colorMap.put("#A900E6", "Purple");
        colorMap.put("#FF00C5", "Pink");
        colorMap.put("#A80000", "Dark Red");
        colorMap.put("#4CE600", "Bright Green");
        colorMap.put("#172973", "Dark Blue");
        colorMap.put("#E8BEFF", "Lavender");
        colorMap.put("#E1E1E1", "Light Gray");
        colorMap.put("#FFFF72", "Bright Yellow");
        colorMap.put("#D1FF74", "Bright Lime");
        colorMap.put("#73B2FF", "Bright Purple");
        colorMap.put("#012E95", "Deep Blue");
        colorMap.put("#FF73DF", "Bright Pink");
        colorMap.put("#FF5500", "Orange");
        colorMap.put("#E6E600", "Yellow");
        colorMap.put("#AAFF00", "Lime");
        colorMap.put("#00FFC5", "Turquoise");
        colorMap.put("#0071FF", "Blue");
        colorMap.put("#B2B2B2", "Gray");
        colorMap.put("#E60000", "Bright Red");
        colorMap.put("#A87000", "Bright Orange");
        colorMap.put("#A8A800", "Bright Yellow");
        colorMap.put("#00E6A9", "Bright Turquoise");
        colorMap.put("#00A9E6", "Bright Light Blue");
        colorMap.put("#005CE6", "Bright Blue");
        colorMap.put("#00329A", "Bright Navy");
        colorMap.put("#8400A8", "Bright Violet");
        colorMap.put("#A80084", "Bright Fuchsia");
        colorMap.put("#9C9C9C", "Light Gray");
        colorMap.put("#A80002", "Bright Red");
        colorMap.put("#732600", "Brown");
        colorMap.put("#734C00", "Dark Orange");
        colorMap.put("#737300", "Olive");
        colorMap.put("#38A800", "Green");
        colorMap.put("#00A884", "Teal");
        colorMap.put("#0084A8", "Dark Blue");
        colorMap.put("#004DA8", "Dark Violet");
        colorMap.put("#0A29C0", "Indigo");
        colorMap.put("#4C0073", "Violet");
        colorMap.put("#73004C", "Violet");
        colorMap.put("#686868", "Gray");
        colorMap.put("#730000", "Maroon");
        colorMap.put("#D7B09E", "Beige");
        colorMap.put("#D7C29E", "Beige");
        colorMap.put("#D7D79E", "Beige");
        colorMap.put("#267300", "Green");
        colorMap.put("#00734C", "Green");
        colorMap.put("#004C73", "Blue");
        colorMap.put("#002673", "Blue");
        colorMap.put("#3B3AC4", "Blue");
        colorMap.put("#C29ED7", "Lavender");
        colorMap.put("#D69DBC", "Lavender");
        colorMap.put("#343434", "Gray");
        colorMap.put("#F57A7A", "Red");
        colorMap.put("#CD8966", "Tan");
        colorMap.put("#F5CA7A", "Yellow");
        colorMap.put("#CDCD66", "Yellow");
        colorMap.put("#A5F57A", "Yellow");
        colorMap.put("#9ED7C2", "Aquamarine");
        colorMap.put("#9EBBD7", "Aquamarine");
        colorMap.put("#9EAAD7", "Aquamarine");
        colorMap.put("#035FE4", "Blue");
        colorMap.put("#AA66CD", "Purple");
        colorMap.put("#CD6699", "Purple");
        colorMap.put("#000000", "Black");
        colorMap.put("#894444", "Brown");
        colorMap.put("#895A44", "Brown");
        colorMap.put("#CDAA66", "Yellow");
        colorMap.put("#898944", "Yellow");
        colorMap.put("#5C8944", "Green");
        colorMap.put("#66CDAB", "Turquoise");
        colorMap.put("#6699CD", "Turquoise");
        colorMap.put("#7A8EF5", "Turquoise");
        colorMap.put("#0370CB", "Blue");
        colorMap.put("#704489", "Purple");
        colorMap.put("#894465", "Purple");
    }

    public String getColorName(String hexCode) {
        return colorMap.getOrDefault(hexCode, "Unknown");
    }
}

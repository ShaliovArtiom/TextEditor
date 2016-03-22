package by.bsuir.iit.ppvis.lab1.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laptop on 07.03.16.
 */
public class Glyph {
    private char simbol;
    private int size;
    private int font;
    private List<String> list = new ArrayList<>();

    public Glyph(){}

    public void location(){}
    public void sizeOfElement(){}
    public void fontOfElement(){}
    public void contentOfElement(String s){
        list.add(s);
    }

}

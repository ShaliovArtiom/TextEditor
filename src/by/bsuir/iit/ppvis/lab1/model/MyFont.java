package by.bsuir.iit.ppvis.lab1.model;

/**
 * Created by TyZiK on 03.04.2016.
 */
public class MyFont {
    private String name;
    private int size;
    private int style;

    public MyFont(String name, int size, int style) {
        this.name = name;
        this.size = size;
        this.style = style;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }
}

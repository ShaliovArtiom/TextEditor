package by.bsuir.iit.ppvis.lab1.model;

/**
 * Created by TyZiK on 08.04.2016.
 */
public class Line {
    private int maxSizeOfElement;
    private int y;

    public Line(Document document) {
        maxSizeOfElement = 0;
    }

    public int getMaxSizeOfElement() {
        return maxSizeOfElement;
    }

    public void setMaxSizeOfElement(int maxSizeOfElement) {
        this.maxSizeOfElement = maxSizeOfElement;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

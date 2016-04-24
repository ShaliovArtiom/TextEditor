package by.bsuir.iit.ppvis.lab1.view;

import by.bsuir.iit.ppvis.lab1.model.Carriage;

class CarriageView {
    private Carriage carriage;

    public CarriageView() {
        carriage = new Carriage();
    }


    public Carriage getCarriage() {
        return carriage;
    }

    public void setCarriage(Carriage carriage) {
        this.carriage = carriage;
    }
}

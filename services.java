//all services are assumed true unless surveys say otherwise for now


public class services {
    private boolean housing = true;
    private boolean food = true;
    private boolean electric = true;

    public services(boolean housing, boolean food, boolean electric) {
        this.housing = housing;
        this.food = food;
        this.electric = electric;
    }

    public boolean getHousing() {
        return housing;
    }

    public boolean getFood() {
        return food;
    }

    public boolean getElectric() {
        return electric;
    }

    public void setHousing(boolean housing) {
    this.housing = housing;
    }
    public void setFood(boolean food) {
    this.food = food;
    }

    public void setElectric(boolean electric) {
    this.electric = electric;
    }





}


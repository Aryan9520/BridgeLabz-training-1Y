class FuelextendsCheckpoint {

    Fuel(String id, String name, double d, int e, int a) {
        super(id, name, d, e, a);
    }

    double penalty() {
        return delayed() ? 10 : 0;
    }

    String type() {
        return "Fuel";
    }
}
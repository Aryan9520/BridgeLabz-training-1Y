class DeliveryextendsCheckpoint {

    Delivery(String id, String name, double d, int e, int a) {
        super(id, name, d, e, a);
    }

    double penalty() {
        return delayed() ? (actual - expected) * 2 : 0;
    }

    String type() {
        return "Delivery";
    }
}
class RestextendsCheckpoint {

    Rest(String id, String name, double d, int e, int a) {
        super(id, name, d, e, a);
    }

    double penalty() {
        return (actual - expected) > 30 ? (actual - expected) * 0.5 : 0;
    }

    String type() {
        return "Rest";
    }
}
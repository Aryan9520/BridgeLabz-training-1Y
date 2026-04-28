public class Main {
    public static void main(String[] args) {

        RouteLinkedList<Checkpoint> route =
                new RouteLinkedList<>();

        route.add(new Delivery("1","Warehouse",30,20,30));
        route.add(new Fuel("2","Pump",20,15,15));
        route.add(new Rest("3","Motel",25,20,55));
        route.add(new Delivery("4","Client Hub",45,30,45));

        route.print();
    }
}
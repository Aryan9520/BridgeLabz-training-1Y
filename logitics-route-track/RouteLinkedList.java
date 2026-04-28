class RouteLinkedList<T extends Checkpoint> {
    Node<T> head;

    void add(T c) {
        if (head == null) {
            head = new Node<>(c);
            return;
        }

        Node<T> temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = new Node<>(c);
    }

    void print() {
        Node<T> temp = head;
        double dist = 0, pen = 0;

        while (temp != null) {
            System.out.println(temp.data.type() + " - " +
                    temp.data.name + " Penalty: " +
                    temp.data.penalty());

            dist += temp.data.distance;
            pen += temp.data.penalty();

            temp = temp.next;
        }

        System.out.println("Total Distance: " + dist);
        System.out.println("Total Penalty: " + pen);
        System.out.println("Route Score: " + (dist - pen));
    }
}
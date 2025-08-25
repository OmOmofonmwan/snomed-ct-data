package dev.ikm.maven;

public class Main {
    
    class Node {
        private String value;
        private Node next;
        
        public Node(String value) {
            this(value, null);
        }
        
        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
        
        public void setValue(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return this.value;
        }
        
        public void setNextNode(Node next) {
            this.next = next;
        }
        
        public Node getNextNode(){
            return this.next;
        }
        
        public String toString() {
            return this.value;
        }
    }
    
    public static void main(String[] args) {
        Main test = new Main();
        String[] games = {"Resident Evil 4", "God of War", "Max Payne", "Prince of Persia", "Budokai 3", "Red Dead Redemption"};
        for(String game: games) test.insertIntoList(game);
        test.printList();
    }
    
    private Node head;
    private int size;
    
    public Main() {
        this.head = null;
        this.size = 0;
    }
    
    private boolean isEmpty() {
        return size == 0 || head == null;
    }
    
    public void insertIntoList(String value) {
        insertTail(value);
    }
    
    public String removeFromList() {
        return removeTail();
    }
    
    private void insertHead(String value) {
        Node newNode = new Node(value, head);
         System.out.println("Head: " + new Node(value, head));
        head = new Node(value, head);
        size++;
    }
    
    private void insertTail(String value) {
        if (isEmpty()){
            insertHead(value);
            return;
        } 
        Node curr = head;
        while (curr.getNextNode() != null) curr = curr.getNextNode();
        curr.setNextNode(new Node(value));
        size++;
    }
    
    private String removeHead() {
        if (isEmpty()) return null;
        String removed = head.getValue();
        head = head.getNextNode();
        size--;
        return removed;
    }
    
    private String removeTail() {
        if (isEmpty() || size == 1) return removeHead();
        Node curr = head;
        while (curr.getNextNode().getNextNode() != null) curr = curr.getNextNode();
        String removedValue = curr.getNextNode().getValue();
        curr.setNextNode(null);
        size--;
        return removedValue;
    }
    
    private void printList() {
        if (isEmpty()) {
            System.out.println("Linked List Is Currently Empty!!");
            return;
        }
        Node curr = head;
        int index = 0;
        while (curr != null) {
            System.out.print(curr + " ");
            if (index < size - 1) System.out.print(" -> ");
            index++;
            curr = curr.getNextNode();
        }
    }
}

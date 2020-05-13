package crudEstrutura;

public class DynamicList {
    private Node start;
    private Node end;
    private int amount;

    public DynamicList() {
        start = end = null;
        amount = 0;
    }

    public int size() {
        return amount;
    }
    
    public boolean isEmpty() {
        return start==null;
    }

    public boolean exist(String data) {
        if (!isEmpty()) {
            Node current = start;
            while (current!=null) {
                if (current.firstName==data) return true;
                current = current.next;
            }
        }
        return false;
    }

    public void add(int id, String firstName, String lastName, String birthDay, String phoneNumber) {
        if (id<=size() && id>-1) {
            Node newNode = new Node(firstName, lastName, birthDay, phoneNumber);
            
            if (id==0 && isEmpty()) {
                start = end = newNode;
            } else if (id==0 && !isEmpty()) {
                newNode.next = start;
                start = newNode;
            } else if (id==size()) {
                end.next = newNode;
                end = newNode;
            } else {
                Node previous = start;
                
                for (int i = 0; i < id-1; i++) {
                    previous = previous.next;                    
                }

                newNode.next = previous.next;
                previous.next = newNode;
            }
            amount++;
        }
    }

    public void add(String firstName, String lastName, String birthDay, String phoneNumber) {
        add
        (
            size(),
            firstName, 
            lastName, 
            birthDay, 
            phoneNumber
            
        );
    }

    public String remove(int id) throws Exception {
        if (id==0) {
            Node temp = start;
            if (size() > 1) {
                start = start.next;
            } else {
                start = end = null;
            }
            amount--;
            return temp.firstName;
        }
        try {
            Node previous = start;

            for (int counter = 0; counter<id-1; counter++) {
                previous = previous.next;
            }
            
            Node temp = previous.next;
            previous.next = temp.next;
            amount--;
            return temp.firstName;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void set(String newData, int id) {
        if (id<size() && id>-1) {
            Node current = start;
            
            for (int counter=0; counter!=id; counter++) {
                current = current.next;
            }
            current.firstName = newData;
        }
    }

    public String get(int id) throws Exception{
        try {
            Node current = start;

            for (int counter=0; counter!=id; counter++) {
                current = current.next;
            }
            
            return current.firstName + " " + current.lastName + " " + current.birthDay + " " + current.phoneNumber;
            
        } catch (Exception e) {
            throw new Exception(e);
        }
        
    }

    @Override
    public String toString() {
        String dataString = "";
        Node temp = start;

        while (temp != null) {
            dataString += temp.firstName + " " + temp.lastName + " " + temp.birthDay + " " + temp.phoneNumber +"\n";
            temp = temp.next;
        }
        return dataString;
    }
    
}
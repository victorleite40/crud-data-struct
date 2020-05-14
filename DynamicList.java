package crudEstrutura;

import javax.swing.text.Position;

public class DynamicList {
    private Person start;
    private Person end;
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

    public int getPosById(int id) {
        Person current = start;
        
        for (int counter=0; counter<size(); counter++) {
            if (current.id==id) return counter;
            current = current.next;
        }
        return -1;
    }

    public boolean existId(int id) {
        if (!isEmpty()) {
            Person current = start;
            while (current!=null) {
                if(current.id==id) return true;
                current = current.next;
            }
        }
        return false;
    }

    public void add(int id, String firstName, String lastName, String birthDay, String phoneNumber, int position) {
        if (position<=size() && position>-1) {
            Person newNode = new Person(id, firstName, lastName, birthDay, phoneNumber);
            
            if (position==0 && isEmpty()) {
                start = end = newNode;
            } else if (position==0 && !isEmpty()) {
                newNode.next = start;
                start = newNode;
            } else if (position==size()) {
                end.next = newNode;
                end = newNode;
            } else {
                Person previous = start;
                
                for (int i = 0; i < position-1; i++) {
                    previous = previous.next;                    
                }

                newNode.next = previous.next;
                previous.next = newNode;
            }
            amount++;
        }
    }

    public void add(int id, String firstName, String lastName, String birthDay, String phoneNumber) throws Exception {
        if (!existId(id)) {
            add
            (
                id,
                firstName, 
                lastName, 
                birthDay, 
                phoneNumber,
                size()
                
            );
        } else {
            System.out.println("ID " + id + " já cadastrado.");
        }
    }

    public void remove(int id) throws Exception {
        int position = getPosById(id);

        if (position == 0) {
            Person temp = start;
            if (size() > 1) {
                start = start.next;
            } else {
                start = end = null;
            }
            amount--;
        }
        try {
            Person previous = start;
            int contador = 0;
            while (contador < position - 1) {
                previous = previous.next;
                contador++;
            }
            Person temp = previous.next;
            previous.next = temp.next;
            amount--;
            
        } catch (NullPointerException e) {
           System.err.println( "ID " + id + " não encontrado.");
        }
    }

    public void set(String newData, int id) {
        int position = getPosById(id);

        if (position<size() && position>-1) {
            Person current = start;
            
            for (int counter=0; counter!=position; counter++) {
                current = current.next;
            }
            current.firstName = newData;
        }
    }

    public String get(int id) throws Exception{
        try {
            Person current = start;
            int position = getPosById(id);

            for (int counter=0; counter!=position; counter++) {
                current = current.next;
            }

            return current.firstName + " " + current.lastName + " " + current.birthDay + " " + current.phoneNumber;
            
        } catch (NullPointerException e) {
            return "ID " + id + " não encontrado.";
        }
        
    }

    @Override
    public String toString() {
        String dataString = "";
        Person temp = start;

        while (temp != null) {
            dataString += temp.firstName + " " + temp.lastName + " " + temp.birthDay + " " + temp.phoneNumber +"\n";
            temp = temp.next;
        }
        return dataString;
    }
    
}
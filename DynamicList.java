package crudEstrutura;

import java.util.ArrayList;
import java.util.List;

public class DynamicList 
{
    private Person start;
    private Person end;
    private int amount;

    public DynamicList() 
    {
        start = end = null;
        amount = 0;
    }

    public int size() 
    {
        return amount;
    }
    
    public boolean isEmpty() 
    {
        return start==null;
    }

    public int getPosById(int id)
    {
        Person current = start;
        
        for (int i=0; i<size(); i++) {
            if (current.id==id) return i;
            current = current.next;
        }
        return -1;
    }

    public boolean existId(int id) 
    {
        if (!isEmpty()) {
            Person current = start;
            while (current!=null) {
                if(current.id==id) return true;
                current = current.next;
            }
        }
        return false;
    }

    public void add(int id, String firstName, String lastName, String birthDay, String phoneNumber, int position) 
    {
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

    public void add(int id, String firstName, String lastName, String birthDay, String phoneNumber) throws Exception 
    {
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

    public void remove(int id) throws Exception 
    {
        int position = getPosById(id);
        
        if (position>-1) {
            if (position==0) {
                if (size()>1) {
                    start = start.next;
                } else {
                    start = end = null;
                }
                amount--;
            } else {
                try {
                    Person previous = start;
                    
                    for (int i = 0; i<position-1; i++) {
                        previous = previous.next;
                    }
                    
                    Person temp = previous.next;
                    previous.next = temp.next;
                    amount--;
                    
                } catch (NullPointerException e) {
                    System.err.println("ID " + id + " não encontrado."); // TESTAR
                    // throw new Exception( "ID " + id + " não encontrado." );
                }
            }
        } else {
            System.err.println("ID " + id + " não encontrado.");
        }
    }

    public void set(String newData, int id) 
    {
        int position = getPosById(id);

        if (position<size() && position>-1) {
            Person current = start;
            
            for (int i=0; i!=position; i++) {
                current = current.next;
            }
            current.firstName = newData;
        }
    }

    public String get(int id) throws Exception
    {
        try {
            int position = getPosById(id);
            Person current = start;

            for (int i=0; i!=position; i++) {
                current = current.next;
            }

            return current.firstName + " " + current.lastName + " " + current.birthDay + " " + current.phoneNumber;
        } catch (NullPointerException e) {
            return "ID " + id + " não encontrado.";
        }   
    }

    public int search(String arg1[], String arg2[], String arg3[], String arg4[])
    {
        if (!isEmpty()) {
            Person current = start;
            while (current!=null) {
                if(current.id==id) return true;
                current = current.next;
            }
        }
        return 1;
    }

    public String query(String input[]) 
    {
        String dataString = "";

        Person current = start;

        if (input.length==1) {
            return "Argumentos insulficientes.";
        } else {
            if (input.length==2) 
            {
                String arg1[] = input[1].split(":");

                while (current!=null)
                {
                    if (arg1[1].equals(current.firstName) || arg1[1].equals(current.lastName) || arg1[1].equals(current.birthDay) || arg1[1].equals(current.phoneNumber))
                    {
                        dataString += current.id + " ";
                    }
                    current = current.next;
                }                
            }
            else if (input.length==3)
            {
                String arg1[] = input[1].split(":");
                String arg2[] = input[2].split(":");
                
                while (current!=null)
                {
                    if (arg1[1].equals(current.firstName) || arg1[1].equals(current.lastName) || arg1[1].equals(current.birthDay) || arg1[1].equals(current.phoneNumber)
                        &&
                        arg2[1].equals(current.firstName) || arg2[1].equals(current.lastName) || arg2[1].equals(current.birthDay) || arg2[1].equals(current.phoneNumber))
                    {
                        dataString += current.id + " ";
                    }
                    current = current.next;
                }        

            }
            else if (input.length==4)
            {
                String arg3[] = input[3].split(":");
            }
            else if (input.length==5)
            {
                String arg4[] = input[4].split(":");
            }
        }

        return dataString;
    }

    @Override public String toString() 
    {
        String dataString = "";
        Person temp = start;

        for (int i = 0; temp!=null; i++) 
        {
            dataString += (i>0) ? "\n" : "" ;
            dataString += "[" + temp.id + "] "  + temp.firstName + " " + temp.lastName + " " + temp.birthDay + " " + temp.phoneNumber;
            temp = temp.next;
        }

        return dataString += "\nSize: " + size();
    }
}
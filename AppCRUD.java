package crudEstrutura;

import java.util.Scanner;

public class AppCRUD {

    public static int toInt(final String string) {
        return Integer.parseInt(string);
    }
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        DynamicList list = new DynamicList();

        boolean stop = false;
        while (!stop)
        {
            String input = scan.nextLine();
            String [] inputHandled =  input.split(" ");

            

            switch (inputHandled[0]) {
                case "add":
                    list.add(toInt(inputHandled[1]), inputHandled[2], inputHandled[3], inputHandled[4], inputHandled[5]);
                    break;

                case "del":
                    list.remove(toInt(inputHandled[1]));
                    break;

                case "info":
                    System.out.println(list.get( toInt(inputHandled[1]) ));
                    break;

                case "000":
                    stop = true;
                    break;

                default:
                    break;
            }
        }
        scan.close();
        
        /*
        
        list.add(0, "Roberto", "Carlos", "01/01/1960", "+55-11-0169-0369");
        list.add(1, "Capitao", "Nascimento", "11/05/1979", "+55-21-0190-0190");
        System.out.println(list.get(1));
        

         
        list.add(10, 0);
        System.out.println(list);
        list.add(20, 0);
        System.out.println(list);
        list.add(30, 2);
        System.out.println(list);
        list.add(40, 1);
        System.out.println(list);
        System.out.println(list.exist(40));
        System.out.println(list.exist(50));
        list.add(50);
        System.out.println(list.get(3));
        System.out.println(list);
        list.set(90,3);
        */
    }
}
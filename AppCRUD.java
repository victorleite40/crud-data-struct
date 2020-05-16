package crudEstrutura;

import java.util.Scanner;

public class AppCRUD {

    public static int toInt(String string) {
        return Integer.parseInt(string);
    }
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        DynamicList list = new DynamicList();

        boolean runMenu = true;

        

        while (runMenu)
        {
            String input[] = scan.nextLine().split(" ");

            //try {
                switch (input[0]) {
                    case "add":
                        list.add(toInt(input[1]), input[2], input[3], input[4], input[5]);
                        // "add <id> <first_name> <last_name> <birtday> <phone_number>";
                        break;
                        
                    case "del":
                        list.remove(toInt(input[1]));
                        // "del <id>";
                        break;

                    case "info":
                        System.out.println(list.get( toInt(input[1]) ));
                        // "info <id>";
                        break;

                    case "query":
                        System.out.println(list.query(input));
                        break;

                    case "000":
                        runMenu = false;
                        break;
                        
                    case "list": // DEV
                        System.out.println(list);
                        break;

                    default:
                        break;
                }
            /*} catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Argumentos insuficientes.");
            }*/
        }

        scan.close();
                
        
        /** 
         * TESTS
        */

        /*
        list.add(69, "Roberto", "Carlos", "01/01/1960", "+55-11-0169-0369");
        list.add(190, "Capitao", "Nascimento", "11/05/1979", "+55-21-0190-0190");
        //System.out.println(list.get(1));
        System.out.println(list.get(190));

        */
    }
}
// К калькулятору из предыдущего дз добавить логирование.


import java.util.Scanner;
import java.io.IOException;


import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task_2 {
  
    static int scanNumber() {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        return number;
    }

    static String scanOperations() {
        Scanner scan = new Scanner(System.in);
        String operations = scan.nextLine();
        return operations;

    }

    static int GetResult(String opr, int num1, int num2) throws IOException {
        Logger loger = Logger.getLogger(task_2.class.getName());
        FileHandler fHandler = new FileHandler("Task_2.txt");
        SimpleFormatter sFormatter = new SimpleFormatter();
        fHandler.setFormatter(sFormatter);
        loger.addHandler(fHandler);
        
        int result = 0;
        switch (opr) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;

            default:
                System.out.println("Введите оператор действия: -, +, *, /");
                break;
        }
        loger.info(opr);;
        return result;

    }

    public static void main(String[] args) throws IOException {
        System.out.println("Введите число A: ");
        int num1 = scanNumber();
        System.out.println("Введите оператор действия: -, +, *, /");
        String operations = scanOperations();
        System.out.println("Введите число B: ");
        int num2 = scanNumber();
        int result = GetResult(operations, num1, num2);
        System.out.printf("%d %s %d = %d", num1, operations, num2, result);

    }

}
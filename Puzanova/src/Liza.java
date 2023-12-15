import java.util.Scanner;
public class Liza {
   public static void main(String[] args) {
      double num1;
      double num2;
      double ans;
      char op;
      Scanner reader = new Scanner(System.in);
      System.out.print("Введите два числа: ");
      num1 = reader.nextDouble();
      num2 = reader.nextDouble();
      System.out.print("\nВыберите операцию (+, -, *, /): ");
      op = reader.next().charAt(0);
      switch(op) {
         case '+': ans = num1 + num2;
            break;
         case '-': ans = num1 - num2;
            break;
         case '*': ans = num1 * num2;
            break;
         case '/': ans = num1 / num2;
            break;
         default:  System.out.printf("Ошибка! Введена некорреткная операция");
            return;
      }
      System.out.print("\nРезультат Пузанова:\n");
      System.out.printf(num1 + " " + op + " " + num2 + " = " + ans);
   }
}
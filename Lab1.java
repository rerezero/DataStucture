import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyArrayLinearList l1 = new MyArrayLinearList();
        boolean running = true;

        while (running) {
            System.out.println("\nҮйлдэлээ сонгоно уу:");
            System.out.println("1 - Шинэ жагсаалт үүсгэх");
            System.out.println("2 - Шинэ жагсаалт үүсгэх");
            System.out.println("3 - Max утгыг олох");
            System.out.println("4 - Min утгыг олох");
            System.out.println("5 - Жагсаалтын нийлбэрийг олох");
            System.out.println("6 - Жагсалтын дундаж утгыг олох");
            System.out.println("7 - Сондгой элементүүдыг устгах");
            System.out.println("8 - Өсөхөөр эрэмблэх");
            System.out.println("9 - Давхардсан элементыг устгах");
            System.out.println("10 - Жагсаалтыг урвуу болгох");
            System.out.println("11 - Жагсаалтыг холих");
            System.out.println("12 - Гарах");

            int choice = scanner.nextInt();

            switch (choice) {
            case 1:
                System.out.println("Хэдэн элементтэй жагсаалт үүсгэх вэ");
                int count = scanner.nextInt(); 
                System.out.println(+ count + " элемент оруулна уу ");
                for (int i = 0; i < count; i++) {
                    int numberToAdd = scanner.nextInt();
                    l1.add(l1.size(), numberToAdd);
                }
                break;
               
                case 2:
                	displayList(l1);
                	break;
                case 3:
                    if (l1.size() > 0) 
                        System.out.println("Max утга: " + l1.Max());
                     else 
                        System.out.println("Жагсаалт хоосон байна");
                    
                    break;
                case 4:
                    if (l1.size() > 0) {
                        System.out.println("Min утга: " + l1.Min());
                    } else 
                        System.out.println("Жагсаалт хоосон байна");
                    break;
                case 5:
                	  if (l1.size() > 0)
                    System.out.println("Нийлбэр: " + l1.Sum());
                	  else 
                          System.out.println("Жагсаалт хоосон байна");
                    break;
                case 6:
                	  if (l1.size() > 0)
                    System.out.println("Дундаж утга: " + l1.Average());
                	  else 
                          System.out.println("Жагсаалт хоосон байна");
                    break;
                case 7:
                	  if (l1.size() > 0) {
                    l1.removeOdd();
                    System.out.println("Сондгой элементүүдийг устгах:");
                    displayList(l1);}
                    else 
                        System.out.println("Жагсаалт хоосон байна");
                    break;
                case 8:
                	  if (l1.size() > 0) {
                    l1.sort();
                    System.out.println("Өсөхөөр эрэмблэх:");
                    displayList(l1);}
                    else 
                        System.out.println("Жагсаалт хоосон байна");
                    break;
                case 9:
                	  if (l1.size() > 0) {
                    l1.unique();
                    System.out.println("Давхардсан елемент устгах:");
                    displayList(l1);}
                    else 
                        System.out.println("Жагсаалт хоосон байна");
                    break;
                case 10:
                	  if (l1.size() > 0) {
                    MyArrayLinearList reversedList = l1.Reverse();
                    System.out.println("Урвуу жагсаалт:");
                    displayList(reversedList);}
                    else 
                        System.out.println("Жагсаалт хоосон байна");
                    break;
                case 11:
                	  if (l1.size() > 0) {
                    l1.rand();
                    System.out.println("Холисон жагсаалт:");
                    displayList(l1);}
                    else 
                        System.out.println("Жагсаалт хоосон байна");
                    break;
                case 12:
                    System.out.println("Баяртай");
                    scanner.close();
                    return;
                default:
                    System.out.println("Тийм сонголт алга");
            }
        }
    }
    public static void displayList(MyArrayLinearList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

}

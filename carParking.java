import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dataStructures.ArrayStack;
public class carParking extends ArrayStack {
    private ArrayStack temppark;

    public carParking() {
        super(10);
        temppark = new ArrayStack(10);
    }

    public void input(String number) {
        if (this.top == this.stack.length - 1) {
            System.out.println("Zogsool duursen uchir " + number + " dugaartai mashiniig oruulah bolomjgui");
        } else {
            boolean exists = false;
            for (int i = 0; i <= this.top; i++) {
                if (this.stack[i].equals(number)) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                System.out.println(number + " dugaartai mashin ali hediin zogsoold orson baina.");
            } else {
                this.push(number);
                System.out.println(number + " dugaartai mashiniig amjilttai oruulaw");
            }
        }
    }

    public void output(String number) {
        if (this.empty()) {
            System.out.println("Zogsool hooson baina " + number + " dugaartai mashin zogsoold baihkue");
        } else {
            this.process(number);
        }
    }

    public void process(String number) {
        int k = 0;
        while (!this.empty()) {
            if (!this.peek().equals(number)) {
                temppark.push(this.pop());
                k++;
            } else
                break;
        }
        if (this.empty()) {
            System.out.println(number + " Dugaartai mashiin zogsoold bhkue");
        } else {
            System.out.println(k + " mashiin tru gargasnii daraa " + this.pop() + " dugaartai mashin zogsooloos garlaa");
        }
        while (!temppark.empty()) {
            this.push(temppark.pop());
        }
        if (k > 0 && k <= this.top)
            System.out.println(k + " mashiiniig butsaaj park luu oruulaw");
    }

    public void listCars() {
        if (this.empty()) {
            System.out.println("Zogsoold mashin baihgui baina.");
        } else {
            System.out.println("Zogsoold baigaa mashinuud:");
            for (int i = 0; i <= this.top; i++) {
                System.out.println(this.stack[i]);
            }
        }
    }

    public static void main(String[] args) {
        carParking cp = new carParking();
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.println("\nUildlee songono uu:");
            System.out.println("1: Cars.txt file-aas mashinuudiig bolovsruulah");
            System.out.println("2: Mashin oruulah");
            System.out.println("3: Mashin gargah");
            System.out.println("4: Zogsoold baigaa mashinuudiig harah");
            System.out.println("5: Program haah");
            System.out.print("Tanii songolt: ");

            int choice = Integer.parseInt(userInput.nextLine());

            switch (choice) {
                case 1:
                    try {
                        File file = new File("cars.txt");
                        Scanner sc = new Scanner(file);
                        while (sc.hasNext()) {
                            String[] inputline = sc.nextLine().split(" ");
                            if (inputline[0].equals("A")) {
                                cp.input(inputline[1]);
                            } else {
                                cp.output(inputline[1]);
                            }
                        }
                        sc.close();
                    } catch (FileNotFoundException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case 2: 
                    System.out.print("Oruulah mashinii dugaar: ");
                    String addNumber = userInput.nextLine();
                    cp.input(addNumber);
                    break;

                case 3: 
                    System.out.print("Gargah mashinii dugaar: ");
                    String removeNumber = userInput.nextLine();
                    cp.output(removeNumber);
                    break;

                case 4: 
                    cp.listCars();
                    break;

                case 5: 
                    System.out.println("Program duussan.");
                    userInput.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Buruu songolt. Dahin oroldono uu.");
            }
        }
    }
}

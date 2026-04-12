class Loops{
    public static void main(String[] args) {
        int a = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        while (a < 5) { 
            System.out.println("its true");
            a++;
            if (a == 3) break; // exit loop when a is 3
        }
        do {
            System.out.println("a is " + a);
            a++;
            
        } while (a<5);
    }
}
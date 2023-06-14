public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter first number - ");
            var a = sc.nextBigDecimal();
            System.out.print("Enter second number - ");
            var b = sc.nextBigDecimal();
            sc.nextLine();
            System.out.print("Enter sign for calculation (+,-,/,*)- ");
            String c = sc.nextLine();
            switch (c) {
                case "+":
                    System.out.println(a.add(b));
                    break;
                case "-":
                    System.out.println(a.subtract(b));
                    break;
                case "*":
                    System.out.println(a.multiply(b));
                    break;
                case "/":
                    System.out.println(a.divide(b));
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
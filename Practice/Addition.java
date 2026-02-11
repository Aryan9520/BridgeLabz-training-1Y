class Addition {
int add(int a, int b) {
return  a+b;
}
public static void main(String[]args) {
Addition obj = new Addition();
int result = obj.add(7,8);
System.out.println("Sum=" +result);
}
}
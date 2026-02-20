public class ZaraBonusCalculator {

    public static double[][] generateSalaryAndService(int n) {
        double[][] data = new double[n][2]; // [salary, years of service]

        for (int i = 0; i < n; i++) {
            int salary = (int)(Math.random() * 90000) + 10000; // 5-digit salary (10000–99999)
            int yearsOfService = (int)(Math.random() * 11); // 0 to 10 years

            data[i][0] = salary;
            data[i][1] = yearsOfService;
        }

        return data;
    }

    public static double calculateBonus(double salary, double yearsOfService) {
        if (yearsOfService > 5) {
            return salary * 0.05; // 5% bonus
        } else {
            return salary * 0.02; // 2% bonus
        }
    }

    public static void main(String[] args) {
        int employees = 10;
        double[][] empData = generateSalaryAndService(employees);

        double totalBonus = 0;

        System.out.println("Zara Company - Employee Bonus Details");
        System.out.println("Emp\tOld Salary\tYears\tBonus\t\tNew Salary");

        for (int i = 0; i < employees; i++) {
            double oldSalary = empData[i][0];
            double years = empData[i][1];

            double bonus = calculateBonus(oldSalary, years);
            double newSalary = oldSalary + bonus;

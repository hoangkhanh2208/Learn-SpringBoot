public class App {
    public static void main(String[] args) throws Exception {
       
        DemoStream.filterOutAge(25, 45);
        System.out.println("-----------------------------");
        DemoStream.filterOutAverageAge();
        System.out.println("-----------------------------");
        DemoStream.filterOutAverageAgeByNationality();
    }
}

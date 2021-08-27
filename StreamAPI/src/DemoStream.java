import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.List.*;

public class DemoStream {

  public static ArrayList<Person> people = new ArrayList<>(of(
    new Person("Vinh", "Vietnam", 28),
    new Person("Lan", "Vietnam", 24),
    new Person("John", "USA", 27),
    new Person("Lee", "China", 67),
    new Person("Kim", "Korea", 22),
    new Person("Long", "Vietnam", 18),
    new Person("Jungho", "Korea", 19),
    new Person("Tian", "China", 20),
    new Person("Clara", "USA", 40),
    new Person("Mikura", "Japan", 27),
    new Person("Sony", "Japan", 29),
    new Person("Xiang", "China", 78),
    new Person("Peter", "France", 18),
    new Person("Haloy", "Malaysia", 20),
    new Person("Magie", "Malaysia", 32)
    ));


  //Bài tập thực hành

  //Lọc người từ độ tuổi X -> Y
  public static void filterOutAge(int start, int end) {
    people.stream()
        .filter(p -> p.getAge() >= start && p.getAge() <= end)
        .forEach(System.out::println);
  }

  //Tuổi trung bình
  public static void filterOutAverageAge() {
    Integer result = people.stream()
                            .mapToInt(s -> s.getAge())
                            .reduce(0, (s1, s2) -> s1 + s2);

    System.out.println(result / people.size());
  }
  
  //Tuổi trung bình theo từng quốc tịch
  public static void filterOutAverageAgeByNationality() {
    Set<String> nationalityList = people.stream()
        .map(s -> s.getNationality())
        .collect(Collectors.toSet()); //dùng hàm collect thu thập kết quả của stream sang Collection Set
    Iterator<String> iterator = nationalityList.iterator();
    while (iterator.hasNext()) {
      String nationality = iterator.next();
      double result = people.stream()
          .filter(p -> p.getNationality().equals(nationality))
          .mapToDouble(s -> s.getAge())
          // .reduce(0, (s1, s2) -> s1 + s2);
          .average()
          .orElse(Double.NaN);

      System.out.println(nationality + " - " + result);
    }             
  }
  
  // public static long countPeopleByNationality(String nationality) {
  //     return people.stream()
  //                       .filter(p -> p.getNationality().equals(nationality))
  //                       .count();
  // }

}

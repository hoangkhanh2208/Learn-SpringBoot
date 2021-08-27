# Thymeleaf căn bản

#### Cấu trúc thư mục 
<img width="225" alt="anh1" src="https://user-images.githubusercontent.com/80346800/125388539-dcf66900-e3c9-11eb-89eb-3f3c8a4c5ad8.png">

#### 

## 1. Hiển thị danh sách people

#### Tạo model `Person` sử dụng Lombok

_Person.java_

```java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private String name;
    private String nationality;
    private LocalDate birthdate;
    private String gender;

    
}
```

#### Tầng Repository tạo class `InMemoryRepository` để đọc dữ liệu từ JSON 

_repository/InMemoryRepository.java_

```java
package com.techmaster.basicthymeleaf.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.techmaster.basicthymeleaf.model.Person;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

@Repository
public class InMemoryRepository {
    private List<Person> persons = new ArrayList<>();

    //Constructor đọc toàn bộ dữ liệu từ JSON vào
    public InMemoryRepository() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    File file;

    try {
    file = ResourceUtils.getFile("classpath:static/people2.json");
    persons.addAll(mapper.readValue(file, new TypeReference<List<Person>>() {
    }));
    } catch (JsonParseException e) {
    e.printStackTrace();
    } catch (JsonMappingException e) {
    e.printStackTrace();
    } catch (IOException e) {
    e.printStackTrace();
    }
    }

    public List<Person> getPerson() {
        return persons;
    }

}
```
#### Tầng Controller tạo class `PersonController` để nhận các request từ phía người dùng, và trả về template

_controller/PersonController.java_

```java
package com.techmaster.basicthymeleaf.controller;

import com.techmaster.basicthymeleaf.repository.InMemoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {
    
    @Autowired
    private InMemoryRepository repository;

    @GetMapping("/listperson")
    public String getPerson(Model model) {
        model.addAttribute("persons", repository.getPerson());
        return "listperson";
    }

    @GetMapping("/listperson2")
    public String getPerson2(Model model) {
        model.addAttribute("persons", repository.getPerson());
        return "listperson2";
    }
}
```

#### Templates

Sử dụng Template Engine Thymeleaf để xử lý các templates này và trả về webpage cho người dùng.

Sử dụng ```th:each``` trong **thymeleaf** để lặp và lấy ra từng đối tượng trong ```persons```
```java
  th:each="person : ${persons}"
 ```
  
![image](https://user-images.githubusercontent.com/80346800/125434182-b18ee899-0dd0-4722-b9e9-2438dc81da1a.png)

## 2. Tính hai số
#### Tạo model `Calculator` sử dụng Lombok

_Calculator.java_

```java
package com.techmaster.basicthymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculator {
    private Integer firstNumber;
    private Integer secondNumber;
    private Character operator;
}
```

#### Tầng Service chứa class `CalculatorService` để tính toán và trả về kết quả cho Controller

_service/CalculatorService.java_

```java
package com.techmaster.basicthymeleaf.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int calculate(int firstNumber, int secondNumber, char operator) {
        
        switch (operator) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                try {
                    return firstNumber / secondNumber;
                } catch (ArithmeticException e) {
                    e.printStackTrace();
                } 
            default:
                break;
        }
        return 0;
    }
}
```

#### Tầng Controller chứa class `CalculatorController` nơi nhận các request từ phía người dùng, và chuyển tiếp xử lý xuống tầng Service, sau đó trả về template

_controller/CalculatorController.java_

```java
package com.techmaster.basicthymeleaf.controller;

import com.techmaster.basicthymeleaf.model.Calculator;
import com.techmaster.basicthymeleaf.service.CalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calService;
    
    @GetMapping
    public String getCalculatorFrom(Model model) {
        model.addAttribute("calculator", new Calculator());
        return "calculator";
    }
    
    @PostMapping
    public String handleCalculatorFrom(@ModelAttribute Calculator cal, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            int result = calService.calculate(cal.getFirstNumber(), cal.getSecondNumber(), cal.getOperator());

            model.addAttribute("calcutator", cal);
            model.addAttribute("result", result);
        }
        return "calculator";
    }
}
```
#### Templates

Tầng Controller đã trả về templates, tiếp theo là sử dụng Template Engine **Thymeleaf** để xử lý các templates này và trả về webpage cho người dùng.

_calculator.html_

```html
<!DOCTYPE html>
<html lang="en">
<head th:replace="index.html :: header">
</head>
<body>

    <header th:insert="index.html :: topmenu"></header><br>

    <div>
        <form th:action="@{/calculator}" th:object="${calculator}" method="post">
            <p>First Number: <input type="text" placeholder="First Number" th:field="*{firstNumber}"></p>
            <p>Second Number: <input type="text" placeholder="Second Number" th:field="*{secondNumber}"></p>
            <p><input class="operator" type="hidden" placeholder="+, -, *, /" th:field="*{operator}"></p>
            <input class="btn btn-success" type="submit" value="+" onclick="dis('+')">     
            <input class="btn btn-success" type="submit" value="-" onclick="dis('-')">     
            <input class="btn btn-success" type="submit" value="*" onclick="dis('*')">     
            <input class="btn btn-success" type="submit" value="/" onclick="dis('/')">              
        </form>
        <b>Kết quả: </b><strong th:text="${result}"></strong>
    </div>

    <script>
        function dis(val)
         {
             document.getElementById("operator").value = val
         }
    </script>
</body>
</html>
```

![image](https://user-images.githubusercontent.com/80346800/125434326-8c9d1e67-964d-428c-8384-54815fba34f6.png)

## 3. Hiển thị danh sách people theo 2 cột
  ```java
  th:each="person, index : ${persons}" th:if="${index.even}"
  ```
  Sử dụng biến thứ 2 của ```th:each``` sau đó sử dụng ```th:if``` để phân loại và in ra 2 cột. Câu lệnh trên sẽ in ra những phần tử có thứ tự chẵn.
  

![image](https://user-images.githubusercontent.com/80346800/125434421-ee460d00-3c5d-47bb-9d8a-c52b33479eae.png)

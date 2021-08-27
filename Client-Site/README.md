# 1. Chạy ví dụ trong bài

Tôi tạo ra hai thư mục :
1. book: ứng dụng Spring Boot lắng nghe ở cổng 8080
2. bookvue: ứng dụng Vuejs (v3) lắng nghe ở cổng 3000

## 1.1 Chạy thử bằng command line

1. Chuyển vào thư mục book: `cd book`
2. Gõ lệnh maven chạy Spring Boot: `mvn spring-boot:run`
3. Mở trình duyệt gõ `http://localhost:8080/api/books`
4. Tiếp đến chúng ta chuyển đến thư mục bookvue bằng cách `cd bookvue`
5. Khởi động ứng dụng bằng `npm run dev`
6. Mở trình duyệt gõ `http://localhost:3000`
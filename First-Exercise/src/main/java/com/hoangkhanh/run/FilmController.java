package com.hoangkhanh.run;

import com.hoangkhanh.run.Film;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FilmController {
    List<Film> films;
    public FilmController(){
        films = new ArrayList<>();
        films.add(new Film("The Shawshank Redemption", "The Shawshank Redemption được mệnh danh là bộ phim hay nhất mọi thời đại và tính đến nay nó vẫn đứng thứ nhất trong top 100 phim điện ảnh. Phim kể về quá trình vượt ngục của Andrew, một nhân viên nhà băng, bị kết án chung thân và bị giam tại nhà tù Shawshank sau khi giết vợ và nhân tình của cô. \n" +
                "\n" +
                "Tại đây, thế giới ngầm của các phạm nhân, sự hà khắc của hệ thống quản giáo xung đột và giành nhau quyền thống trị. Để tồn tại, anh vừa cố thích nghi với cuộc sống mới vừa lên kế hoạch cho cuộc vượt ngục vĩ đại.", "Tâm lý", 1994));
        films.add(new Film("The Godfather", "abc", "Hình sự", 1972));
        films.add(new Film("Chuyện Tào Lao", "abc", "Tâm lý tội phạm", 1994));
        films.add(new Film("The Good, The Bad And The Ugly", "abc", "Hành động", 1996));
        films.add(new Film("Hiệp Sĩ Bóng Đêm", "abc", "Hành động", 2008));
    }


    @GetMapping("/listFilm")
    public String listFilm( Model model){
        model.addAttribute("listFilm", films);
        return "listFilm";
    }

    @GetMapping("/addFilm")
    public String addFilm( Model model){
        model.addAttribute("film", new Film());
        return "addFilm";
    }

    @PostMapping("/film")
    public String addFilm(@ModelAttribute  Film film){
        films.add(film);
        return "success";
    }
}

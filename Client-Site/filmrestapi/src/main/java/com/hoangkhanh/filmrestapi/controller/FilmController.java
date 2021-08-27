package com.hoangkhanh.filmrestapi.controller;

import java.util.List;

import com.hoangkhanh.filmrestapi.model.Film;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class FilmController {
    @GetMapping("/films")
    public ResponseEntity<List<Film>> getAllFilm() {
        List<Film> films = List.of(
            new Film("Gone with the Wind", "Victor Fleming, David O. Selznick", 1939),
            new Film("Bố Già", "Trấn Thành", 2020),
            new Film("Parasite", "Bong Joon-ho", 2019),
            new Film("Money Heist", "Álex Pina", 2018),
            new Film("The Shawshank Redemption", "Frank Darabont", 1994),
            new Film("The Godfather", "Francis Ford Coppola", 1972)
        );
        return ResponseEntity.ok().body(films);
    }
}

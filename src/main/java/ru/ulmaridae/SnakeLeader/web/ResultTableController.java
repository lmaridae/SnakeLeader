package ru.ulmaridae.SnakeLeader.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/results")
@Controller
public class ResultTableController {

    @GetMapping
    public String showGame(Model model) {
        return "home";
    }

//    @PostMapping
//    public String postUserResults (Object userResults, Model model) {
//        return "???"; // возвращаем пользователю информацию о том, какое место он занял (в процентах)
//    }
}

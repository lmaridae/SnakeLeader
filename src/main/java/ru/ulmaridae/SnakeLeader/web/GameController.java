package ru.ulmaridae.SnakeLeader.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ulmaridae.SnakeLeader.UserResult;
import ru.ulmaridae.SnakeLeader.data.ResultRepository;

import java.util.Date;

@Slf4j
@Controller
@RequestMapping("/")
public class GameController {

    private final ResultRepository resultRepository;

    @Autowired
    public GameController (ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @GetMapping
    public String showGame(Model model) {

        return "home";
    }

    @PostMapping
    public String postUserResults (UserResult userResults, Model model) {
        // здесь кладем информацию об игре + дату в репозиторий
        userResults.setDate(new Date());
        resultRepository.save(userResults);
        model.addAttribute("Percentage", resultRepository.getPercent(userResults.getUserScore()));
        return "home"; // возвращаем пользователю информацию о том, какое место он занял (в процентах)
    }
}

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
        model.addAttribute("userResult", new UserResult());
        return "home";
    }

    @PostMapping
    public String postUserResults (UserResult userResult, Model model) {
        resultRepository.save(userResult);
        log.info("new result: " + userResult);
        model.addAttribute("percentage", resultRepository.getPercent(userResult.getUserScore()));
        return "home"; // возвращаем пользователю информацию о том, какое место он занял (в процентах)
    }
}

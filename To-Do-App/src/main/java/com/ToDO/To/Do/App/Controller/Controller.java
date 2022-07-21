package com.ToDO.To.Do.App.Controller;

import com.ToDO.To.Do.App.DataBase.DataBaseRepository;
import com.ToDO.To.Do.App.DataBase.DatabaseTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private DataBaseRepository dataBaseRepository;

    @GetMapping("/")
    public String Greeting(Model model){
        return "greeting";
    }
    @GetMapping("/login")
    public String Login(Model model){
        return "login";
    }

    @GetMapping("/Main")
    public String MainPage(Model model){
        Iterable<DatabaseTable> databaseTables= dataBaseRepository.findAll();
        model.addAttribute("todo",databaseTables);
        return "Main";
    }

    @PostMapping("/Main")
        public String AddTodo(@RequestParam String full_text,  Model model ){
        DatabaseTable databaseTable = new DatabaseTable(full_text);
        dataBaseRepository.save(databaseTable);

            return"redirect:/Main";
        }

        @GetMapping("/Main/{id}")
    public String getInfo(@PathVariable(value = "id") Long id,Model model){
        if(!dataBaseRepository.existsById(id)){
            return "redirect:/Main";
        }
            dataBaseRepository.deleteById(id);

            return "redirect:/Main";

        }
}

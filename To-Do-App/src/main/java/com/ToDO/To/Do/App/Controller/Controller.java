package com.ToDO.To.Do.App.Controller;

import com.ToDO.To.Do.App.DataBase.DataBaseRepository;
import com.ToDO.To.Do.App.DataBase.DatabaseTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private DataBaseRepository dataBaseRepository;

    @GetMapping("/")
    public String MainPage(Model model){
        Iterable<DatabaseTable> databaseTables= dataBaseRepository.findAll();
        model.addAttribute("todo",databaseTables);
        return "Main";
    }

    @PostMapping("/")
        public String AddTodo(@RequestParam String full_text,  Model model ){
        DatabaseTable databaseTable = new DatabaseTable(full_text);
        dataBaseRepository.save(databaseTable);

            return"redirect:/";
        }

        @GetMapping("/{id}")
    public String getInfo(@PathVariable(value = "id") Long id,Model model){
        if(!dataBaseRepository.existsById(id)){
            return "redirect:/";
        }
            dataBaseRepository.deleteById(id);
        Optional<DatabaseTable> databaseTableOptional= dataBaseRepository.findById(id);
            ArrayList<DatabaseTable> databaseTableArrayList=new ArrayList<>();
            databaseTableOptional.ifPresent(databaseTableArrayList::add);

            model.addAttribute("post",databaseTableArrayList);

            return "redirect:/";

        }
}

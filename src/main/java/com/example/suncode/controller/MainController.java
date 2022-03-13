package com.example.suncode.controller;

import com.example.suncode.domain.Test;
import com.example.suncode.repos.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {


    static List<String> columns;

    static {
        columns = new ArrayList<>();
        columns.add("kolumna1");
        columns.add("kolumna2");
        columns.add("kolumna3");
        columns.add("kolumna4");
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("columns", columns);
        return "main";
    }


    public List<Map<String, Object>> duplicateValue(String column) {
        return jdbcTemplate.queryForList(
                "WITH DuplicateValue AS (\n" +
                        "        SELECT "+ column +", COUNT(*) AS CNT\n" +
                        "        FROM tabela_testowa\n" +
                        "        GROUP BY "+ column +"\n" +
                        "        HAVING COUNT(*) > 1\n" +
                        "   )\n" +
                        "SELECT *\n" +
                        "FROM tabela_testowa\n" +
                        "WHERE "+ column +" IN (SELECT "+ column +" FROM DuplicateValue)");
    }

    public List<Map<String, Object>> uniqueValue(String column) {
        return jdbcTemplate.queryForList(
                "WITH DuplicateValue AS (\n" +
                        "        SELECT "+ column +", COUNT(*) AS CNT\n" +
                        "        FROM tabela_testowa\n" +
                        "        GROUP BY "+ column +"\n" +
                        "        HAVING COUNT(*) = 1\n" +
                        "   )\n" +
                        "SELECT *\n" +
                        "FROM tabela_testowa\n" +
                        "WHERE "+ column +" IN (SELECT "+ column +" FROM DuplicateValue)");
    }

    @PostMapping("/result")
    public String postMain(Model model, @RequestParam String column, @RequestParam String option){
        if(option.equals("unique")){
            model.addAttribute("columns", uniqueValue(column));
            model.addAttribute("column", "Unique value : "+column);
        }else {
            model.addAttribute("columns", duplicateValue(column));
            model.addAttribute("column", "Duplicate value : "+column);
        }

        return "result";
    }


//    @GetMapping(path="/all")
//    public @ResponseBody
//    Iterable<Test> getAllUsers() {
//        // This returns a JSON or XML with the users
//        return testRepository.findAll();
//    }
}

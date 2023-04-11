package com.example.toad.controller;

import com.example.toad.models.Test;
import com.example.toad.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    public TestController(TestService testService){
        this.testService = testService;
    }
    private final TestService testService;

    @GetMapping("/tests")
    public String findAll( Model model){
        List<Test> tests = testService.findAll();
        model.addAttribute("tests",tests);
        return "tests";
    }

    @GetMapping("/testAdd")
    public String createTestForm(Test test){
        return "testAdd";
    }

    @PostMapping("/testAdd")
    public String createTest(Test test){
        testService.saveTest(test);
        return "redirect:/tests";
    }

    @GetMapping("/testEdit/{id}")
    public String editTestForm(@PathVariable("id") Long id, Model model){
        Test test = testService.findById(id);
        model.addAttribute("test",test);
        return "/testEdit";
    }

    @PostMapping("/testEdit")
    public String editTest(Test test){
        testService.saveTest(test);
        return "redirect:/tests";
    }

    @GetMapping("/testDelete/{id}")
    public String deleteTest(@PathVariable("id") Long id){
        testService.deleteById(id);
        return "redirect:/tests";
    }
}

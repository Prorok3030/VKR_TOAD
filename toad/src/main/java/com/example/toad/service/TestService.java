package com.example.toad.service;

import com.example.toad.models.Test;
import com.example.toad.repo.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }
    private final TestRepository testRepository;

    public List<Test> findAll(){
        return testRepository.findAll();
    }

    public Test saveTest(Test test){
        return testRepository.save(test);
    }

    public void deleteById(Long id){
        testRepository.deleteById(id);
    }

    public Test findById(Long id) {
        return testRepository.findById(id).orElse(null);
    }
}

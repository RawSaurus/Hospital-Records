package com.example.hospitalrecords.test.controller;

import com.example.hospitalrecords.test.dto.TestDto;
import com.example.hospitalrecords.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tests")
public class TestController {

    private final TestService testService;

    @GetMapping("/{id}/{testName}")
    @PreAuthorize("hasAuthority('patient:read')")
    public TestDto getTest(@PathVariable Long id, @PathVariable String testName){
        return testService.getTest(id, testName);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('patient:read')")
    public List<TestDto> getAllTests(@PathVariable Long id){
        return testService.getAllTests(id);
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('doctor:create')")
    public TestDto postTest(@PathVariable Long id, @RequestBody TestDto testDto){
        return testService.postTest(id, testDto);
    }

    @PutMapping("/{id}/{testName}")
    @PreAuthorize("hasAuthority('admin:update')")
    public TestDto updateTest(@PathVariable Long id,@PathVariable String testName, @RequestBody TestDto testDto){
        return testService.updateTest(id, testName, testDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity deleteTest(@PathVariable Long id){
        return testService.deleteTest(id);
    }


}

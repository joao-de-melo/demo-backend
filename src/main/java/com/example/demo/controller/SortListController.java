package com.example.demo.controller;

import com.example.demo.services.sorting.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/list")
public class SortListController {
    private final SortingService sortingService;

    @Autowired
    public SortListController(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    @ResponseBody
    @RequestMapping(path = "/sort", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public List<Integer> sort (@RequestBody List<Integer> numbers) {
        return sortingService.quicksort(numbers);
    }
}

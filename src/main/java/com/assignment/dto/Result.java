package com.assignment.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
public class Result {
    private String title;
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    private Optional<Double> win;


}

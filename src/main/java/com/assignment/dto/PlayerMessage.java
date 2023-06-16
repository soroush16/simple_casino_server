package com.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlayerMessage {
    @Min(value = 1, message = "Minimum bet amount is 1 €")
    private long bet;
    @Min(value = 1, message = "Minimum number you can enter is 1")
    @Max(value = 99, message = "Maximum number you can enter is 99")
    private int number;
}

package org.UnitTest.HomeWork.Week4.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {
    private String accessory;
    private int warrantyYear;
    private double discount;
}

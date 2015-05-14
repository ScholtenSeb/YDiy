package com.example.sebastian.ydiy;

/**
 * Created by sebastian on 15/05/14.
 */
public class StepCounter {
    private Integer value;
    public Integer getValue() {
        return value;
    }
    public void addOne() { value++; }
    public void subtractOne() { value--; }
    public void setValue(Integer value) {
        this.value = value;
    }
}

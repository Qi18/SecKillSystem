package com.example.SecKillSys.enums;

/**
 * @author: rich
 * @date: 2022/10/15 10:29
 * @description:
 */
public enum Gender {
    男生("0"),
    女生("1");

    private String value;

    Gender(String s) { this.value = s;}
    @Override
    public String toString(){ return value;}
}

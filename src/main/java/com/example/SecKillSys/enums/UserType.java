package com.example.SecKillSys.enums;

/**
 * @author: rich
 * @date: 2022/10/13 20:04
 * @description:
 */
public enum UserType {
    Student("1"),
    Student_Admin("2"),
    Building_Admin("3");
    private String value;

    UserType(String value) {this.value = value; }
    @Override
    public String toString(){ return value;}

}

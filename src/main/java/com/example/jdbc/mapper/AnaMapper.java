package com.example.jdbc.mapper;

import com.example.jdbc.pojo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnaMapper {
    int addAddress(ana10 ana);
    List<ana1> getAna1();
    List<ana2> getAna2();
    List<ana3> getAna3();
    List<ana4> getAna4();
    List<ana5> getAna5();
    List<ana6> getAna6();
    List<ana7> getAna7();
    List<ana8> getAna8();
    List<ana9> getAna9();
    List<ana10> getAna10();
}
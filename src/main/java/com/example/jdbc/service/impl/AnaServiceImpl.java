package com.example.jdbc.service.impl;

import com.example.jdbc.mapper.AnaMapper;
import com.example.jdbc.pojo.*;
import com.example.jdbc.service.AnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaServiceImpl implements AnaService {

    @Autowired
    AnaMapper anaMapper;

    @Override
    public List<ana1> getAna1() { return anaMapper.getAna1(); }

    @Override
    public List<ana2> getAna2() { return anaMapper.getAna2(); }

    @Override
    public List<ana3> getAna3() { return anaMapper.getAna3(); }

    @Override
    public List<ana4> getAna4() { return anaMapper.getAna4(); }

    @Override
    public List<ana5> getAna5() { return anaMapper.getAna5(); }

    @Override
    public List<ana6> getAna6() { return anaMapper.getAna6(); }

    @Override
    public List<ana7> getAna7() { return anaMapper.getAna7(); }

    @Override
    public List<ana8> getAna8() { return anaMapper.getAna8(); }

    @Override
    public List<ana9> getAna9() { return anaMapper.getAna9(); }

    @Override
    public List<ana10> getAna10() { return anaMapper.getAna10(); }
}

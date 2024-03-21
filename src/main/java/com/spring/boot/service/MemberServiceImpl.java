package com.spring.boot.service;

import com.spring.boot.dao.MemberDAO;
import com.spring.boot.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public List<Member> getAllMembers() {
        return memberDAO.findAll();
    }

    @Override
    public Member getMemberById(Long id) {

        return memberDAO.findById(id).orElse(null);


    }

    @Override
    public void create(Member member) {
        memberDAO.save(member);
    }

    @Override
    public void remove(Long id) {
        memberDAO.deleteById(id);
    }
}

package com.spring.boot.service;

import com.spring.boot.model.Member;

import java.util.List;

public interface MemberService {
    List<Member> getAllMembers();
    Member getMemberById(Long id);
    void create(Member member);
    void remove(Long id);
}

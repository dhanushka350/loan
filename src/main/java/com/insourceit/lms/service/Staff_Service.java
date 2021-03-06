package com.insourceit.lms.service;

import com.insourceit.lms.dto.BorrowerDto;
import com.insourceit.lms.dto.MemberGroupDto;
import com.insourceit.lms.dto.ResponseDto;
import com.insourceit.lms.dto.UserLogin;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Staff_Service {

    public String userLogin(UserLogin login);

    public boolean userLogout(String name);

    public ResponseDto saveBorrower(BorrowerDto borrowerDto);

    public List<BorrowerDto> allBorrowers();

    public List<String> allUsers();

    public BorrowerDto checkBorrowerID(String id);

    public ResponseDto saveMemberGroup(MemberGroupDto dto);

    public List<MemberGroupDto> allGroupList();

    public MemberGroupDto getGroupByID(int id);

    public List<ResponseDto> getGroupMembersByID(int id);


}

package com.insourceit.lms.service.impl;

import com.insourceit.lms.controller.rest.System_User;
import com.insourceit.lms.dto.BorrowerDto;
import com.insourceit.lms.dto.MemberGroupDto;
import com.insourceit.lms.dto.ResponseDto;
import com.insourceit.lms.dto.UserLogin;
import com.insourceit.lms.modal.Borrower;
import com.insourceit.lms.modal.MemberGroup;
import com.insourceit.lms.modal.User;
import com.insourceit.lms.repository.BorrowerRepository;
import com.insourceit.lms.repository.MemberGroupRepository;
import com.insourceit.lms.repository.RoleRepository;
import com.insourceit.lms.repository.UserRepository;
import com.insourceit.lms.service.Staff_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class Staff_Service_Impl implements Staff_Service {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BorrowerRepository borrowerRepository;
    @Autowired
    private MemberGroupRepository groupRepository;

    private static final Logger LOG = LoggerFactory.getLogger(Staff_Service_Impl.class);


    @Override
    public String userLogin(UserLogin login) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        LOG.info("[APP-STAFF-SERVICE-LOGIN] - check login details - " + dateFormat.format(date));
        User user = userRepository.findByNameEqualsAndPasswordEquals(login.getName(), login.getPassword());
        String returnVal = "error";

        if (user == null) {
            return "wrong entry";
        } else {

            if (user.getRole().getRole().equalsIgnoreCase("ADMIN")) {

                if (user.getActive().equalsIgnoreCase("INACTIVE")) {
                    returnVal = "/admin_dash";
                    LOG.info("[APP-STAFF-SERVICE-LOGIN] - admin " + user.getName() + " logged in.. ");
                    user.setLast_login(dateFormat.format(date));
                    user.setActive("ACTIVE");
                    userRepository.saveAndFlush(user);
                    LOG.info("[APP-STAFF-SERVICE-LOGIN] - last login and status updated. ");
                } else {
                    returnVal = "already in";
                    LOG.warn("[APP-STAFF-SERVICE-LOGIN] - admin " + user.getName() + " already logged in. ");
                }

            } else if (user.getRole().getRole().equalsIgnoreCase("AGENT")) {
                if (user.getActive().equalsIgnoreCase("INACTIVE")) {
                    returnVal = "/admin_dash";
                    LOG.info("[APP-STAFF-SERVICE-LOGIN] - staff member " + user.getName() + " logged in");
                    user.setLast_login(dateFormat.format(date));
                    user.setActive("ACTIVE");
                    userRepository.saveAndFlush(user);
                    LOG.info("[APP-STAFF-SERVICE-LOGIN] - last login and status updated.");
                } else {
                    returnVal = "already in";
                    LOG.warn("[APP-STAFF-SERVICE-LOGIN] - staff member " + user.getName() + " already logged in. ");
                }
            }

            return returnVal;
        }
    }

    @Override
    public boolean userLogout(String name) {
        LOG.info("[APP-STAFF-SERVICE] - logging out user - " + name);
        User user = userRepository.findByNameEquals(name);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        user.setLast_logout(dateFormat.format(date));
        user.setActive("INACTIVE");
        userRepository.saveAndFlush(user);
        LOG.info("[APP-STAFF-SERVICE] - successfully logged out");
        return true;
    }


    // borrower registration
    @Override
    public ResponseDto saveBorrower(BorrowerDto borrowerDto) {
        LOG.info("[APP-STAFF-SERVICE-SAVE BORROWER] - Received borrower named - " + borrowerDto.getFname());
        ResponseDto responseDto = new ResponseDto();
        Borrower borrower = borrowerRepository.saveAndFlush(setBorrowerModal(borrowerDto));
        if (borrower != null) {
            responseDto.setStatus(1);
            responseDto.setMessage("Registration Successful");
            LOG.info("[APP-STAFF-SERVICE-SAVE BORROWER] - Registration Success..");
        } else {
            responseDto.setStatus(0);
            responseDto.setMessage("Registration Failed..");
            LOG.info("[APP-STAFF-SERVICE-SAVE BORROWER] - Registration Failed..");
        }
        return responseDto;
    }

    @Override
    public List<BorrowerDto> allBorrowers() {
        LOG.info("[APP-STAFF-SERVICE-SAVE BORROWERS] - getting all borrowers");
        return makeBorrowerListDto(borrowerRepository.findAll());
    }

    @Override
    public List<String> allUsers() {
        LOG.info("[APP-STAFF-SERVICE-STAFF LIST] - getting all staff members");
        List<String> list = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            list.add(user.getName());
        }
        LOG.info("[APP-STAFF-SERVICE-STAFF LIST] - return all staff members");
        return list;
    }

    @Override
    public BorrowerDto checkBorrowerID(String id) {
        BorrowerDto dto = null;
        Borrower borrower = borrowerRepository.getByUniqueID(id);
        if (borrower != null) {
            dto = new BorrowerDto();
            dto.setWorkstatus(borrower.getWorkstatus());
            dto.setTitle(borrower.getTitle());
            dto.setProvince(borrower.getProvince());
            dto.setMobile(borrower.getMobile());
            dto.setLname(borrower.getLname());
            dto.setLandphone(borrower.getLandphone());
            dto.setGender(borrower.getGender());
            dto.setFname(borrower.getFname());
            dto.setEmail(borrower.getEmail());
            dto.setDescription(borrower.getDescription());
            dto.setCity(borrower.getCity());
            dto.setBusiness(borrower.getBusiness());
            dto.setAddress(borrower.getAddress());
            dto.setRegisteredby(borrower.getRegisteredby().getName());
            dto.setRegdate(borrower.getRegdate());
            dto.setGroup(borrower.getGroup().getMGID());
        }
        return dto;
    }

    @Override
    public ResponseDto saveMemberGroup(MemberGroupDto dto) {
        LOG.info("[APP-STAFF-SERVICE-MEMBER-GROUP-REGISTRATION] - Start group registration");
        ResponseDto responseDto = new ResponseDto();
        MemberGroup memberGroup = new MemberGroup();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        memberGroup.setArea(dto.getArea());
        memberGroup.setCollectionDay(dto.getCollectionDay());
        memberGroup.setDescription(dto.getDescription());
        memberGroup.setMemberCount(dto.getMemberCount());
        memberGroup.setName(dto.getName() + "-" + dto.getArea());
        memberGroup.setRergDate(dateFormat.format(date));
        memberGroup.setStatus(dto.getStatus());
        memberGroup.setRegby(userRepository.findByNameEquals(dto.getRegBy()));
        memberGroup.setUser(userRepository.findByNameEquals(dto.getCollector()));
        MemberGroup save = groupRepository.save(memberGroup);
        if (save != null) {
            responseDto.setMessage("Successfully Registered");
            responseDto.setStatus(0);
            LOG.info("[APP-STAFF-SERVICE-MEMBER-GROUP-REGISTRATION] - Success");
        } else {
            responseDto.setMessage("Registration Failed.. \n Please Contact Developers..");
            responseDto.setStatus(1);
            LOG.info("[APP-STAFF-SERVICE-MEMBER-GROUP-REGISTRATION] - Failed");
        }
        LOG.info("[APP-STAFF-SERVICE-MEMBER-GROUP-REGISTRATION] - Stop group registration");
        return responseDto;
    }

    @Override
    public List<MemberGroupDto> allGroupList() {
        LOG.info("[APP-STAFF-SERVICE-MEMBER-GROUP-LIST] - getting all groups");
        List<MemberGroupDto> list = new ArrayList<>();
        MemberGroupDto dto = null;
        for (MemberGroup group : groupRepository.findAll()) {
            dto = new MemberGroupDto();
            dto.setArea(group.getArea());
            dto.setCollectionDay(group.getCollectionDay());
            dto.setCollector(group.getUser().getName());
            dto.setDescription(group.getDescription());
            dto.setMemberCount(group.getMemberCount());
            dto.setName(group.getName());
            dto.setMGID(group.getMGID());
            dto.setStatus(group.getStatus());
            dto.setRegDate(group.getRergDate());
            dto.setRegBy(group.getRegby().getName());
            list.add(dto);
        }
        LOG.info("[APP-STAFF-SERVICE-MEMBER-GROUP-LIST] - returning group list");
        return list;
    }

    @Override
    public MemberGroupDto getGroupByID(int id) {
        LOG.info("[APP-STAFF-SERVICE-MEMBER-GROUP-LIST] - searching group using id - " + id);
        MemberGroupDto dto = null;
        MemberGroup one = groupRepository.getOne(id);
        if (one != null) {
            dto = new MemberGroupDto();
            dto.setRegDate(one.getRergDate());
            dto.setRegBy(one.getRegby().getName());
            dto.setStatus(one.getStatus());
            dto.setMGID(one.getMGID());
            dto.setName(one.getName());
            dto.setMemberCount(one.getMemberCount());
            dto.setDescription(one.getDescription());
            dto.setCollector(one.getUser().getName());
            dto.setCollectionDay(one.getCollectionDay());
            dto.setArea(one.getArea());
        }
        return dto;
    }

    @Override
    public List<ResponseDto> getGroupMembersByID(int id) {
        LOG.info("[APP-STAFF-SERVICE-GET-BORROWERS-BY-GROUP-ID] - searching using id - " + id);
        List<ResponseDto> list = new ArrayList<>();
        ResponseDto dto = null;
        MemberGroup one = groupRepository.getOne(id);
        if (one != null) {
            LOG.info("[APP-STAFF-SERVICE-GET-BORROWERS-BY-GROUP-ID] - found member group");
            for (Borrower borrower : one.getBorrowers()) {
                dto = new ResponseDto();
                dto.setStatus(Integer.parseInt(borrower.getUniqueID().split("V")[0]));
                dto.setMessage(borrower.getTitle() + " " + borrower.getFname());
                list.add(dto);
            }

        }
        LOG.info("[APP-STAFF-SERVICE-GET-BORROWERS-BY-GROUP-ID] - returning  " + one.getBorrowers().size() + " member's details");
        return list;
    }

    private Borrower setBorrowerModal(BorrowerDto borrowerDto) {
        LOG.info("[APP-STAFF-SERVICE-SAVE BORROWER] - setting model for registration");
        Borrower borrower = borrowerRepository.getByUniqueID(borrowerDto.getUniqueID());
        if (borrower == null) {
            borrower = new Borrower();
            LOG.info("[APP-STAFF-SERVICE-SAVE BORROWER] - new borrower");
        } else {
            LOG.info("[APP-STAFF-SERVICE-SAVE BORROWER] - existing borrower found");
        }

        borrower.setAddress(borrowerDto.getAddress());
        borrower.setBusiness(borrowerDto.getBusiness());
        borrower.setCity(borrowerDto.getCity());
        borrower.setDescription(borrowerDto.getDescription());
        borrower.setEmail(borrowerDto.getEmail());
        borrower.setFiles(borrowerDto.getFiles());
        borrower.setFname(borrowerDto.getFname());
        borrower.setGender(borrowerDto.getGender());
        borrower.setLandphone(borrowerDto.getLandphone());
        borrower.setLname(borrowerDto.getLname());
        borrower.setMobile(borrowerDto.getMobile());
        borrower.setProvince(borrowerDto.getProvince());
        borrower.setRegdate(borrowerDto.getRegdate());
        borrower.setTitle(borrowerDto.getTitle());
        borrower.setUniqueID(borrowerDto.getUniqueID());
        borrower.setWorkstatus(borrowerDto.getWorkstatus());
        borrower.setRegisteredby(userRepository.findByNameEquals(borrowerDto.getRegisteredby()));
        borrower.setGroup(groupRepository.getOne(borrowerDto.getGroup()));
        LOG.info("[APP-STAFF-SERVICE-SAVE BORROWER] - returning model..");
        return borrower;
    }

    private List<BorrowerDto> makeBorrowerListDto(List<Borrower> list) {
        LOG.info("[APP-STAFF-SERVICE-LIST BORROWERS] - setting dto list");
        List<BorrowerDto> borrowerDtoList = new ArrayList<>();
        BorrowerDto dto = null;
        int count = 0;
        for (Borrower borrower : list) {
            dto = new BorrowerDto();
            dto.setAddress(borrower.getAddress());
            dto.setBusiness(borrower.getBusiness());
            dto.setCity(borrower.getCity());
            dto.setDescription(borrower.getDescription());
            dto.setEmail(borrower.getEmail());
            dto.setFiles(borrower.getFiles());
            dto.setFname(borrower.getFname());
            dto.setGender(borrower.getGender());
            dto.setLandphone(borrower.getLandphone());
            dto.setLname(borrower.getLname());
            dto.setMobile(borrower.getMobile());
            dto.setProvince(borrower.getProvince());
            dto.setRegdate(borrower.getRegdate());
            dto.setRegisteredby(borrower.getRegisteredby().getName());
            dto.setUniqueID(borrower.getUniqueID());
            dto.setTitle(borrower.getTitle());
            dto.setWorkstatus(borrower.getWorkstatus());
            borrowerDtoList.add(dto);
            count++;
        }
        LOG.info("[APP-STAFF-SERVICE-LIST BORROWERS] - returning dto list.. found " + count + " records.");
        return borrowerDtoList;
    }
}

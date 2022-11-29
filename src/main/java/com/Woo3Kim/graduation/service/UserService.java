package com.Woo3Kim.graduation.service;

import com.Woo3Kim.graduation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private User user;
    private boolean pwdConcord;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   //회원가입
    void saveUserData(String userId, String pwd, String job, String email, String studentId, String admissionYear, String engLv, float engScore, String minor) {
    	user.setUserId(userId);
    	user.setPwd(pwd);
    	user.setJob(job);
    	user.setEmail(email);
    	user.setStudentId(studentId);
    	user.setAdmissionYear(admissionYear);
    	user.setEngLv(engLv);
    	user.setEngScore(engScore);
    	user.setMinor(minor);
    	
    	userRepository.saveUser(user);
    }

    //비밀번호 찾기
    String findPwd(String inputId) {
    	user = userRepository.getUser(inputId);
    	//이메일에 비밀번호 보내기(work in progress)
    }

    //로그인
    void login(String inputId, String inputPwd) {
    	if(inputPwd.equals(userRepository.getUser(inputId).getPwd())) {
    		pwdConcord = true;
    	}
    	else {
    		pwdConcord = false;
    	}
    }
}

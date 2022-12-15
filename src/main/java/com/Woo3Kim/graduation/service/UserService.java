package com.Woo3Kim.graduation.service;

import com.Woo3Kim.graduation.dto.User;
import com.Woo3Kim.graduation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
	public UserService userService;
	private User user;
    private boolean pwdConcord;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   //회원가입
    public void saveUserData(String userId, String pwd, String job, String email, String studentId, String admissionYear, String engLv, int engScore, String minor) {
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
    public String findPwd(String inputId) {
    	user = userRepository.getUserById(inputId).get();

		//이메일에 비밀번호 보내기(work in progress)

		return user.getPwd();
    }

    //로그인 - *** session에 userId Attribute add 필요 ***
    public void login(String inputId, String inputPwd) {
    	if(inputPwd.equals(userRepository.getUserById(inputId).get().getPwd())) {
    		pwdConcord = true;
    	}
    	else {
    		pwdConcord = false;
    	}
    }

	//사용자 아이디를 통해 유저 객체 찾기
	public Optional<User> getUserById(String userId) {
		Optional<User> user = userRepository.getUserById(userId);

		return user;
	}
}

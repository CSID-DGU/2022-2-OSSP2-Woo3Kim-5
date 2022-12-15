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
    public void saveUserData(User user) {
    	user.setUserId(user.getUserId());
    	user.setPwd(user.getPwd());
    	user.setJob(user.getJob());
    	user.setEmail(user.getEmail());
    	user.setStudentId(user.getStudentId());
    	user.setAdmissionYear(user.getAdmissionYear());
    	user.setEngLv(user.getEngLv());
    	user.setEngScore(user.getEngScore());
		user.setMinor(user.getMinor());
    	user.setUnit(user.getUnit());

    	userRepository.saveUser(user);
    }

    //비밀번호 찾기
    public String findPwd(String inputId) {
    	user = userRepository.getUserById(inputId).get();

		//이메일에 비밀번호 보내기(work in progress)

		return user.getPwd();
    }

    //로그인
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

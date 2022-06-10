package team2.api.mobile.gplx.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.google.gson.Gson;

import team2.api.mobile.gplx.commondata.GenericServiceImpl;
import team2.api.mobile.gplx.dto.DtoLogin;
import team2.api.mobile.gplx.dto.LoginResponse;
import team2.api.mobile.gplx.dto.SignupDto;
import team2.api.mobile.gplx.models.Account;
import team2.api.mobile.gplx.models.AccountStatus;
import team2.api.mobile.gplx.models.Role;
import team2.api.mobile.gplx.repository.AccountRepository;
import team2.api.mobile.gplx.repository.RoleRepository;
import team2.api.mobile.gplx.service.interfaces.AccountService;

@Service
public class AccountServiceImpl extends GenericServiceImpl<Account, String> implements AccountService {

	@Autowired
	private AccountRepository repo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public Account update(String id, Account account) {
		try {
			Account updatedAccount = repo.findById(id).get();
			updatedAccount.setPassword(account.getPassword());
			updatedAccount.setFullName(account.getFullName());
			updatedAccount.setAvatar(account.getAvatar());
			updatedAccount.setStatus(account.getStatus());
			return repo.save(updatedAccount);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public LoginResponse Login(DtoLogin dto) {
		try {
			Optional<Account> account = Optional.ofNullable(repo.findByUsernameAndPassword(dto.getUsername(),dto.getPassword()).orElse(null));
			LoginResponse acc = new LoginResponse();
			acc.setId(account.get().getId());
			acc.setUsername(account.get().getUsername());
			acc.setRoleId(account.get().getRoleId());
			return acc;
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public List<String> Register(SignupDto dto) {
		List<String> errorList = new LinkedList<String>();
		boolean[] flag = { false, false, false };
		List<Account> accounts = repo.findAll();
		for (Account account : accounts) {
			if (account.getEmail().equals(dto.getEmail())) {
				if (!flag[0]) {
					flag[1] = true;
					errorList.add("Email");
				}
			}
			if (account.getUsername().equals(dto.getUsername())) {
				if (!flag[0]) {
					flag[0] = true;
					errorList.add("Username");
				}
			}
		}
		if (!errorList.isEmpty()) {
			return errorList;
		} else {
			try {
				Role role = roleRepo.findByRoleName("User");
				Account account = new Account();
				account.setEmail(dto.getEmail());
				account.setFullName(dto.getFullName());
				account.setUsername(dto.getUsername());
				account.setPassword(dto.getPassword());
				account.setRoleId(role.getId());
				account.setStatus(AccountStatus.ACTIVE);
				repo.save(account);
				errorList.add("Success");
				return errorList;
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				return null;
			}
		}
	}

}

package team2.api.mobile.gplx.service.interfaces;

import java.util.List;

import team2.api.mobile.gplx.commondata.GenericService;
import team2.api.mobile.gplx.dto.DtoLogin;
import team2.api.mobile.gplx.dto.LoginResponse;
import team2.api.mobile.gplx.dto.SignupDto;
import team2.api.mobile.gplx.models.Account;

public interface AccountService extends GenericService<Account, String> {
	Account update(String id, Account account);
	LoginResponse Login(DtoLogin account);
	List<String> Register(SignupDto dto);
}

package ch.hearc.holygram.services;

public interface SecurityService {
	String findLoggedInUsername();

    void autoLogin(String username, String password);
}

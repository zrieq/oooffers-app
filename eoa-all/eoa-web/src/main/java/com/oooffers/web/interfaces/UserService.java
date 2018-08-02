/**
 * 
 */
package com.oooffers.web.interfaces;

import java.util.List;

import com.oooffers.domain.User;
import com.oooffers.domain.UserSearchHistory;

/**
 * @author Zrieq
 *
 */
public interface UserService {
	User findById(int id);
    
    User findByUsername(String username);
     
    void saveUser(User user);
     
    boolean isUsernameUnique(Integer id, String username);
    
    void saveUserSearchHistory(UserSearchHistory userSearchHistory);
    
    List<UserSearchHistory> findAllUserSearchHistoryByUserId(Integer userId);
}

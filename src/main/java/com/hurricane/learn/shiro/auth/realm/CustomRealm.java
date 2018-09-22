package com.hurricane.learn.shiro.auth.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.hurricane.learn.shiro.user.entity.User;

@Component("customRealm")
public class CustomRealm extends AuthorizingRealm{

	@Autowired
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		super.setCredentialsMatcher(credentialsMatcher);
	}
	
	/**
	 * 授权
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
		//获取到当前用户
		Object primaryPrincipal = collection.getPrimaryPrincipal();
		//通过获取到的用户名，封装对应的权限并返回
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRole("role1");
		info.addStringPermission("user:add");
		return info;
	}

	/**
	 * 验证
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		if (StringUtils.isEmpty(token.getPrincipal())) return null;
		User dbUser = findUserByUserName(token.getPrincipal());
		if (dbUser==null) {
			return null;
		}
//		这里面的password为从数据库中得到的,这里传入的principle可以在授权时通过collection.getPrimaryPrincipal()获取到
		AuthenticationInfo info = new SimpleAuthenticationInfo(dbUser,dbUser.getPassword(),ByteSource.Util.bytes(dbUser.getSalt()),"realm1");
		return info;
	}
	
	/**
	 * 这一步需要从数据库中获取数据，这里只是模拟相应的数据
	 * @param principal 用户名 
	 * @return 从数据库中查询到的用户实体
	 */
	private User findUserByUserName(Object principal) {
		if (StringUtils.isEmpty(principal)) {
			return null;
		}
		String username = "hurricane";
		if (!principal.equals(username)) {
			return null;
		}
		User user = new User();
		user.setId("1");
		user.setUserName(username);
		user.setNickName("小刚");
		user.setSalt("sss");
		//123加盐sss并进行两次md5散列
		user.setPassword("755ac1a684638060155ccc37625b954b");
		return user;
	}

}

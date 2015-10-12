package com.alpha.common;

import com.alpha.models.User;
import com.alpha.service.IRoleService;
import com.alpha.service.IUserService;
import com.alpha.service.RoleService;
import com.alpha.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class UserBean {

    @ManagedProperty(value = "#{roleHolderBean}")
    private RoleHolderBean roleHolderBean;
    private static IUserService userService;
    private static IRoleService roleService;

    public UserBean() {
        userService = new UserService();
        roleService = new RoleService();
    }

    public List<User> getUsers() {
        return userService.findAll(User.FIELD_ROLES);
    }

    public boolean isAdmin(User user) {
        return roleService.userHasRole(user, roleHolderBean.getAdmin());
    }

    public boolean isOrganizer(User user) {
        return roleService.userHasRole(user, roleHolderBean.getOrganizer());
    }

    public RoleHolderBean getRoleHolderBean() {
        return roleHolderBean;
    }

    public void setRoleHolderBean(RoleHolderBean roleHolderBean) {
        this.roleHolderBean = roleHolderBean;
    }
}

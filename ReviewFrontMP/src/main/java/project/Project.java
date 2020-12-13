/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author root
 */
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "MyReview",
        callerQuery = "SELECT Password FROM users WHERE Email=?",
        groupsQuery = "select RoleName from users u,role r, userrole ur where ur.UserId = u.UserId and ur.RoleId = r.RoleId and u.Email = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30)
@ApplicationScoped
public class Project {

}

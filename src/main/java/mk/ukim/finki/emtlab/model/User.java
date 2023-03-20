//package mk.ukim.finki.emtlab.model;
//
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Table;
//import lombok.Data;
//import mk.ukim.finki.emtlab.model.enumerations.Role;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.Enumerated;
//import javax.persistence.Id;
//import java.util.Collection;
//import java.util.Collections;
//
//@Data
//@Entity
//@Table(name="library_users")
//public class User implements UserDetails {
//    @Id
//    private String username;
//
//    private String password;
//
//    private String name;
//
//    private String surname;
//
//    private boolean isAccountNonExpired = true;
//    private boolean isAccountNonLocked = true;
//    private boolean isCredentialsNonExpired = true;
//    private boolean isEnabled = true;
//    @Enumerated(value = EnumType.STRING)
//    private Role role;
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singletonList(role);
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return isAccountNonExpired;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return isAccountNonLocked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return isCredentialsNonExpired;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return isEnabled;
//    }
//
//}

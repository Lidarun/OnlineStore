package com.example.gadgetariumb7.db.entity;

import javax.persistence.*;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

import static javax.persistence.CascadeType.*;

@Entity
@Builder
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1, initialValue = 30)
    private Long id;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    @Column(length = 10000)
    private String image;
    private String address;

    @ElementCollection
    @CollectionTable(name = "user_basket_list", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyJoinColumn(name = "subproduct_id")
    @Column(name = "count_of_product")
    private Map<Subproduct, Integer> basketList;

    @ManyToMany(cascade = {MERGE, DETACH, REFRESH})
    private List<Product> favoritesList;

    @OneToMany(cascade = {MERGE, DETACH, REFRESH, REMOVE}, mappedBy = "user")
    private List<Review> userReviews;

    @ManyToMany(cascade = {MERGE, DETACH, REFRESH})
    private List<Product> compareProductsList;

    @ManyToMany(cascade = {MERGE, DETACH, REFRESH})
    private List<Product> orderHistoryList;

    @ManyToMany(cascade = {MERGE, DETACH, REFRESH})
    private List<Product> viewedProductsList;

    public void addViewedProduct(Product product) {
        if (!viewedProductsList.contains(product)) {
            if (viewedProductsList.size() == 7)
                viewedProductsList.remove(0);
            viewedProductsList.add(product);
        }
    }

    @OneToMany(cascade = {MERGE, DETACH, REFRESH}, mappedBy = "user")
    private List<Order> orders;

    @ManyToOne(cascade = {PERSIST, REFRESH, MERGE, DETACH})
    @JoinColumn(name = "role_id")
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

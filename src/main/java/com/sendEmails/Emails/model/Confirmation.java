package com.sendEmails.Emails.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "confirmations")
public class Confirmation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private LocalDateTime date;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name ="user_id")
    private User user;

    public Confirmation(User user){
        this.user = user;
        this.token= UUID.randomUUID().toString();
        this.date = LocalDateTime.now();


    }

}

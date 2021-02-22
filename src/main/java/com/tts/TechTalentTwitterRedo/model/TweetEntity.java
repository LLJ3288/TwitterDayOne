package com.tts.TechTalentTwitterRedo.model;

import com.tts.TechTalentTwitterRedo.repo.TweetRepo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tweet")
@Entity

public class TweetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tweet_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity user;

   // @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   // @JoinTable(name = "tweet_tag", joinColumns = @JoinColumn(name = "tweet_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
   //private List<Tag> tags;

    @NotEmpty(message = "Tweet cannot be empty")
    @Length(max = 280, message = "Tweet cannot have more than 280 characters")
    private String message;                                     //private List<TweetRepo> message;

    @CreationTimestamp
    private ZonedDateTime createdAt;

}

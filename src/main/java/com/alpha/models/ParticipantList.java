package com.alpha.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = ParticipantList.TABLE_NAME)
public class ParticipantList implements IModel {

    private static final long serialVersionUID = 1L;

    public static final String FIELD_USER = "user";
    public static final String TABLE_NAME = "participant_lists";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_UPDATED_AT = "updated_at";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_USER_ID = "user_id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ParticipantList.COLUMN_ID)
    private Long id;

    @Column(name = ParticipantList.COLUMN_NAME, nullable = false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = ParticipantList.COLUMN_CREATED_AT, nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = ParticipantList.COLUMN_UPDATED_AT, nullable = false)
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = ParticipantList.COLUMN_USER_ID)
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = ParticipantListing.TABLE_NAME,
            joinColumns =
            @JoinColumn(name = ParticipantListing.COLUMN_PARTICIPANT_LIST_ID),
            inverseJoinColumns =
            @JoinColumn(name = ParticipantListing.COLUMN_PARTICIPANT_ID))
    private Set<Participant> participants;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }
}

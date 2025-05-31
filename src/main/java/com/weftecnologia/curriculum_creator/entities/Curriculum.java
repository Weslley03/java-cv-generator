package com.weftecnologia.curriculum_creator.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Curriculum {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String city;

  @Column(nullable = false)
  private String number;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String aboutMe;
  
  @OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<WorkExperience> workExperience = new ArrayList<>();
 
  @OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<Skill> skills = new ArrayList<>();

  @OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<Objective> objective = new ArrayList<>();

  // Getters e Setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAboutMe() {
    return aboutMe;
  }

  public void setAboutMe(String aboutMe) {
    this.aboutMe = aboutMe;
  }

  public List<WorkExperience> getWorkExperience() {
    return workExperience;
  }

  public void setWorkExperience(List<WorkExperience> workExperience) {
    this.workExperience = workExperience;
  }

  public List<Skill> getSkills() {
    return skills;
  }

  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }

  public List<Objective> getObjective() {
    return objective;
  }

  public void setObjective(List<Objective> objective) {
    this.objective = objective;
  }
}

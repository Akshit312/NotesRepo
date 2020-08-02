package com.we.springmvcboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.we.springmvcboot.Model.UserNotes;

@Repository
public interface UserNotesRepository extends JpaRepository<UserNotes, Integer> {
	
}

package com.we.springmvcboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.we.springmvcboot.Model.Notes;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Integer> {

}

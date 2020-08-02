package com.we.springmvcboot.Repository;


import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.we.springmvcboot.Model.Notes;

@Repository
public interface UserRepository extends JpaRepository<Notes, Long> {
    
    @Query(value="SELECT notes.notesID, notes.title, notes.message, notes.Date from usernotes JOIN notes on usernotes.notesID=notes.notesID where usernotes.notesID IN (Select usernotes.notesID from usernotes where usernotes.userID IN (Select User.userID from User where User.emailID=?1))", nativeQuery=true)
	List<Notes> findNotesByEmail(String email);

	@Query(value="SELECT userID from User where emailID=?1", nativeQuery=true)
	int getUserIDfromEmail(String email);

	
	@Modifying 
    @Transactional
	@Query(value="insert into User(emailID) values(?1)", nativeQuery=true)
	void addEmail(String email);

	@Modifying 
    @Transactional
    @Query(value="Update Notes SET title=?1, Message=?2, Date=?3 where notesID=?4", nativeQuery=true)
	void updateNotes(String title, String message, java.sql.Date date,int notesID);

	
	@Query(value="SELECT notes.notesID, notes.title, notes.message, notes.Date from usernotes JOIN notes on usernotes.notesID=notes.notesID where usernotes.notesID IN (Select usernotes.notesID from usernotes where usernotes.userID=?1)",nativeQuery=true)
	List<Notes> findNotesByUserID(int userID);

	@Modifying 
    @Transactional
    @Query(value="insert into UserNotes(UserID) Values(?1) ", nativeQuery=true)
	void generateNotesID(int userID);

	@Query(value="select last_insert_id()", nativeQuery=true)
	int getNotesID();

	@Modifying 
    @Transactional	
    @Query(value="insert into Notes(notesID, title, message, date) Values(?1, ?2, ?3, ?4) ", nativeQuery=true)
    void addNotes(int notesId, String title, String message, Date date);

	@Modifying 
    @Transactional	
    @Query(value="delete from Notes where notesID=?1",nativeQuery=true)
	void deleteNoteFromNotes(int notesID);

	@Modifying 
    @Transactional	
    @Query(value="delete from UserNotes where userID=?1 and notesID=?2", nativeQuery=true)
	void deleteNoteFromUserNotes(int userID, int notesID);
	
	
}
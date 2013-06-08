package org.fiteagle.core.userdatabase;

public interface UserDB {

	public void add(User u) throws DuplicateUsernameException, DatabaseException, NotEnoughAttributesException, InValidAttributeException;
	
	public void delete(String UID) throws DatabaseException;
	public void delete(User u) throws DatabaseException;
	
	public void update(User u) throws RecordNotFoundException, DatabaseException, NotEnoughAttributesException, InValidAttributeException; 
	public void addKey(String UID, String key) throws RecordNotFoundException, DatabaseException, InValidAttributeException;
	
	public User get(String UID) throws RecordNotFoundException, DatabaseException;
	public User get(User u) throws RecordNotFoundException, DatabaseException;
	
	public int getNumberOfUsers() throws DatabaseException;
	
	public void deleteAllEntries() throws DatabaseException;

		
	public static class RecordNotFoundException extends RuntimeException {		
		private static final long serialVersionUID = 2315125279537534064L;
	}
	
	public class DuplicateUsernameException extends RuntimeException {
		private static final long serialVersionUID = -7242105025265481986L;		
	}
	
  public class DatabaseException extends RuntimeException {
    private static final long serialVersionUID = -8002909402748409082L;
  }
  
  public class NotEnoughAttributesException extends RuntimeException {
    private static final long serialVersionUID = -8279867183643310351L;
  }
  
  public class InValidAttributeException extends RuntimeException {
    private static final long serialVersionUID = -1299121776233955847L;
  }
}

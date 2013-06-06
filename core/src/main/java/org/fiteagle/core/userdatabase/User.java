package org.fiteagle.core.userdatabase;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import net.iharder.Base64;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.fiteagle.core.userdatabase.UserDB.InValidAttributeException;
import org.fiteagle.core.userdatabase.UserDB.NotEnoughAttributesException;

public class User {
	
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	@JsonIgnore
	private String passwordHash;
	@JsonIgnore
	private String passwordSalt;
	private List<String> publicKeys;

	private final static int MINIMUM_PASSWORD_LENGTH = 3;
	
	public User(String username, String firstName, String lastName, String email, String passwordHash, String passwordSalt, List<String> publicKeys){
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passwordHash = passwordHash;
		this.passwordSalt =  passwordSalt;
		if(publicKeys == null){
		  this.publicKeys = new ArrayList<>();
		}
		else{
		  this.publicKeys = publicKeys;
		}		
	}
	
	public User(String username, String firstName, String lastName, String email, String password) throws NoSuchAlgorithmException{ 
	  this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;    
  
    byte[] salt = generatePasswordSalt();
    this.passwordSalt = Base64.encodeBytes(salt);        
    this.passwordHash = generatePasswordHash(salt, password);
    
    this.publicKeys = new ArrayList<String>();
	}
	
	public User(String username, String firstName, String lastName, String email, String password, List<String> publicKeys) throws NoSuchAlgorithmException{ 
	  this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;    
  
    byte[] salt = generatePasswordSalt();
    this.passwordSalt = Base64.encodeBytes(salt);        
    this.passwordHash = generatePasswordHash(salt, password);
    
    if(publicKeys == null){
      this.publicKeys = new ArrayList<>();
    }
    else{
      this.publicKeys = publicKeys;
    }   
	}
	
	public void checkAttributes() throws NotEnoughAttributesException, InValidAttributeException{  
    if(username == null || firstName == null || lastName == null || email == null || passwordHash == null || passwordSalt == null){
      throw new UserDB.NotEnoughAttributesException();
    }
    if(username.length() == 0 || firstName.length() == 0 || lastName.length() == 0 || email.length() == 0 ||
        !email.contains("@") || passwordHash.length() == 0 || passwordSalt.length() == 0){
      throw new UserDB.InValidAttributeException();
    }
  }
	
	private byte[] generatePasswordSalt(){
	  SecureRandom random = new SecureRandom();
    return random.generateSeed(20);
	}
	
	private String generatePasswordHash(byte[] salt, String password) throws NoSuchAlgorithmException{
	  if(password == null || password.length() < MINIMUM_PASSWORD_LENGTH){
      return null;
	  }
    
	  byte[] passwordBytes = createHash(salt, password);
    return Base64.encodeBytes(passwordBytes);
	}
	
  private byte[] createHash(byte[] salt, String password) throws NoSuchAlgorithmException {    
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    digest.reset();
    digest.update(salt);
    return digest.digest(password.getBytes());
  }
	
  public static User createMergedUser(User oldUser, User newUser){
    if(newUser.getFirstName() == null){
      newUser.setFirstName(oldUser.getFirstName());
    }
    if(newUser.getLastName() == null){
      newUser.setLastName(oldUser.getLastName());
    }
    if(newUser.getPublicKeys() == null || newUser.getPublicKeys().size() == 0){
      newUser.setPublicKeys(oldUser.getPublicKeys());
    }
    if(newUser.getEmail() == null){
      newUser.setEmail(oldUser.getEmail());
    }
    if(newUser.getPasswordSalt() == null || newUser.getPasswordHash() == null){
      newUser.setPasswordSalt(oldUser.getPasswordSalt());
      newUser.setPasswordHash(oldUser.getPasswordHash());
    }
    return newUser;    
  }
  
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<String> getPublicKeys() {
		return publicKeys;
	}

	public void setPublicKeys(List<String> publicKeys) {
		this.publicKeys = publicKeys;
	}
	
	public void addPublicKey(String publicKey){
		if(!this.publicKeys.contains(publicKey)){
			this.publicKeys.add(publicKey);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (publicKeys == null) {
			if (other.publicKeys != null)
				return false;
		} else if (!publicKeys.equals(other.publicKeys))
			return false;
		return true;
	}
	
	@Override
  public String toString() {
    return "User [username=" + username + ", firstName=" + firstName + ", lastName="
        + lastName + ", publicKeys=" + publicKeys + "]";
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public String getPasswordSalt() {
    return passwordSalt;
  }
    
  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

  public void setPasswordSalt(String passwordSalt) {
    this.passwordSalt = passwordSalt;
  }
}

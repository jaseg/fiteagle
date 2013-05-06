package org.fiteagle.core.aaa;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import junit.framework.Assert;

import org.fiteagle.core.userdatabase.User;
import org.fiteagle.core.userdatabase.UserManager;
import org.junit.Before;
import org.junit.Test;

public class CertificateAuthorityTest {
  CertificateAuthority CA ;
  UserManager um;
  User dummyUser ;
  @Before
  public void setUp() throws Exception {
    CA = new CertificateAuthority();
    um = new UserManager();
    dummyUser = um.getUserById("fiteagle.av.test");
  }
  
  
  @Test
  public void testReadCACert() throws IOException, CertificateException{
    X509Certificate caCert = CA.readCACert();
    System.out.println(caCert.toString());
    Assert.assertNotNull(caCert);
  }
  
  @Test 
  public void testReadPrivateKey() throws IOException, GeneralSecurityException{
    PrivateKey pkey = CA.readCAPrivateKey();
    System.out.println(pkey.toString());
    Assert.assertNotNull(pkey);
   }
  @Test
  public void testCreateCertificateForDummyUser() throws Exception {
    X509Certificate userCert =   CA.createCertificate(dummyUser);
    System.out.println(userCert);
    Assert.assertTrue(userCert != null);   
  }
  
//  @Test 
//  public void testWriteCertificate() throws Exception{
//    X509Certificate cert = CA.createCertificate(dummyUser);
//    CA.saveCertificate("acceptedCert.pem", cert);
//  }
//  
}
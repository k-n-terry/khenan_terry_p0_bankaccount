package dev.terry.utilities;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MakeUniqueId_impl implements MakeUniqueId{
    // fields
    private String firstName;
    private String lastName;
    private String accountPin;
    private String uniqueString;
    private String uniqueId;

    // constructor
    // This will make an MD5 string, and use it as unique ID
    public MakeUniqueId_impl(String firstName, String lastName, String accountPin){
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountPin = accountPin;

        this.uniqueString = firstName+lastName+accountPin;
        MessageDigest messageDigest = null;

        // I'm using MD5 algorithm for the sake of this project, however it would be unwise to use
        // for real applications, as MD5 has unsatisfactory collision-resistance.
        try{
            messageDigest = MessageDigest.getInstance("MD5");

            // update messageDigest object to hold the bytes of the password string
            messageDigest.update(this.uniqueString.getBytes());

            // assign the messageDigest object to a digest variable as a byte array
            byte[] messageDigestBytes = messageDigest.digest();

            // convert bytes from digest into hexadecimal, and then convert into string.
            this.uniqueId = DatatypeConverter.printHexBinary(messageDigestBytes).toUpperCase();

        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
            this.uniqueId = null;
        }
    }

    // getter
    public String getUniqueId(){
        return this.uniqueId;
    }
}

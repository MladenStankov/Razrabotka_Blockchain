package blockchain;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

class Wallet {
    private String publicKey;
    private String privateKey;
    private double balance;
    
    public Wallet() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(512);
        KeyPair keyPair = keyGen.generateKeyPair();
        
        this.publicKey = bytesToHex(keyPair.getPublic().getEncoded());
        this.privateKey = bytesToHex(keyPair.getPrivate().getEncoded());
        this.balance = 0;
    }
    
    public String getPublicKey() {
        return publicKey;
    }
    
    public String getPrivateKey() {
        return privateKey;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void addBalance(double amount) {
        balance += amount;
    }
    
    public void subtractBalance(double amount) {
        balance -= amount;
    }
    
    public String toString() {
        return "Public Key: " + publicKey + "\nPrivate Key: " + privateKey + "\nBalance: " + balance;
    }
    
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
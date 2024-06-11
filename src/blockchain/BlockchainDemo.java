package blockchain;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class BlockchainDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Blockchain blockchain = new Blockchain(3);
        
        Wallet walletA = new Wallet();
        Wallet walletB = new Wallet();
        
        Transaction transaction1 = new Transaction(walletA.getPublicKey(), walletB.getPublicKey(), 5.0);
        Transaction transaction2 = new Transaction(walletB.getPublicKey(), walletA.getPublicKey(), 10.0);
        
        Block block1 = new Block(1, System.currentTimeMillis(), new ArrayList<>(), blockchain.getLatestBlock().getHash());
        block1.addTransaction(transaction1);
        blockchain.addBlock(block1);
        
        Block block2 = new Block(2, System.currentTimeMillis(), new ArrayList<>(), blockchain.getLatestBlock().getHash());
        block2.addTransaction(transaction2);
        blockchain.addBlock(block2);
        
        System.out.println("Is blockchain valid? " + blockchain.isChainValid());
    }
}

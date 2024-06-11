package blockchain;

import java.util.ArrayList;

class Blockchain {
    private ArrayList<Block> chain;
    private int difficulty;
    
    public Blockchain(int difficulty) {
        this.chain = new ArrayList<>();
        this.difficulty = difficulty;
        chain.add(new Block(0, System.currentTimeMillis(), new ArrayList<>(), "0"));
    }
    
    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }
    
    public void addTransaction(Transaction transaction) {
        Block latestBlock = getLatestBlock();
        latestBlock.addTransaction(transaction);
    }
    
    public void addBlock(Block newBlock) {
        newBlock.mineBlock(difficulty);
        chain.add(newBlock);
    }
    
    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);
            
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }
            
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }
}
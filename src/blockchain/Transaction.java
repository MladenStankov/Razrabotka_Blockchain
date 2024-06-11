package blockchain;

class Transaction {
    private String sender;
    private String recipient;
    private double amount;
    
    public Transaction(String sender, String recipient, double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }
    
    public String toString() {
        return sender + " sent " + amount + " to " + recipient;
    }
}

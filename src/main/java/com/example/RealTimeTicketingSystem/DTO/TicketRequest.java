package com.example.RealTimeTicketingSystem.DTO;

public class TicketRequest {
    private int numTickets;
    private int releaseRate;
    private int retrievalRate;
    private int maxTicketCapacity;

    public TicketRequest(int numTickets, int releaseRate, int retrievalRate, int maxTicketCapacity) {
        this.numTickets = numTickets;
        this.releaseRate = releaseRate;
        this.retrievalRate = retrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public int getReleaseRate() {
        return releaseRate;
    }

    public int getRetrievalRate() {
        return retrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    public void setReleaseRate(int releaseRate) {
        this.releaseRate = releaseRate;
    }

    public void setRetrievalRate(int retrievalRate) {
        this.retrievalRate = retrievalRate;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }
}

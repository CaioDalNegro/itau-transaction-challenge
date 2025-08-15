package br.com.itauchallenge.itau_transaction_challenge.model;

public class StatisticModel {
    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    //  Construtor --------------------->
    public StatisticModel(long count, double sum, double avg, double min, double max) {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }

    // Getters e Setters ---------------->
    public long getCount() {
        return count;
    }
    public void setCount(long count) {
        this.count = count;
    }
    public double getSum() {
        return sum;
    }
    public void setSum(double sum) {
        this.sum = sum;
    }
    public double getAvg() {
        return avg;
    }
    public void setAvg(double avg) {
        this.avg = avg;
    }
    public double getMin() {
        return min;
    }
    public void setMin(double min) {
        this.min = min;
    }
    public double getMax() {
        return max;
    }
    public void setMax(double max) {
        this.max = max;
    }

    
}

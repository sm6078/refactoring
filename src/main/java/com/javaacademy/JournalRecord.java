package com.javaacademy;

public class JournalRecord {
    private double garbageWeight;
    private Bottle bottle;
    private Cartoon cartoon;

    public JournalRecord(Bottle bottle) {
        this.bottle = bottle;
    }

    public JournalRecord(double garbageWeight) {
        this.garbageWeight = garbageWeight;
    }

    public JournalRecord(Cartoon cartoon) {
        this.cartoon = cartoon;
    }

    @Override
    public String toString() {
        if (bottle != null) {
            return "Переработан стеклянный мусор, получились бутылки объема " + bottle.getVolume() + " мл";
        } else if (cartoon != null) {
            return "Переработан картон, получилось " + cartoon.getWeight() + " кг картона";
        }
        return "Не переработано: " + garbageWeight + " килограмм мусора";
    }
}
